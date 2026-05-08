package tests;

import base.RandomPersonForRegistration;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.ConfigReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasePageTest {

    protected WebDriver driver;
    protected RandomPersonForRegistration randomPerson;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegisterPage registerPage;
    protected AccountCreatedPage accountCreatedPage;

    // her test başlamadan önce tarayıcıyı aç
    @BeforeMethod
    public void setUp() {
        ChromeOptions options = getChromeOptions();
        driver = new ChromeDriver(options);
        // Reklam domainlerini tamamen engelle
        ((ChromeDriver) driver).executeCdpCommand(
                "Network.setBlockedURLs",
                Map.of("urls", List.of(
                        "*googlesyndication.com*",
                        "*doubleclick.net*",
                        "*google-analytics.com*",
                        "*googleadservices.com*"
                ))
        );
        ((ChromeDriver) driver).executeCdpCommand("Network.enable", Map.of());
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("base.url"));

        homePage = new HomePage(driver);
    }


    // her test bittikten sonra tarayıcıyı kapat
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @NonNull
    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-component-update");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.ads", 2);          // reklamları engelle
        prefs.put("profile.default_content_setting_values.popups", 2);       // popup'ları engelle
        prefs.put("profile.default_content_setting_values.notifications", 2); // bildirimleri engelle
        prefs.put("autofill.profile_enabled", false);
        prefs.put("autofill.address_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    protected void registerNewUser() {
        randomPerson = new RandomPersonForRegistration();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);

        Assert.assertTrue(homePage.isHomePageLoaded(), "Ana sayfa yüklenemedi!");
        homePage.clickSignupLoginButton();
        Assert.assertTrue(loginPage.isLoginPageLoaded(), "Login sayfası yüklenemedi!");
        loginPage.fillSignUpForm(randomPerson.firstName, randomPerson.email);
        Assert.assertTrue(registerPage.isSignUpPageLoaded(), "Kayıt sayfası yüklenemedi!");
        registerPage.fillRegistrationFrom(randomPerson);
        Assert.assertTrue(accountCreatedPage.isAccountCreated(), "Kullanıcı oluşturulamadı");
        accountCreatedPage.continueButtonClick();
    }

}
