package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountDeletedPage;
import pages.LoginPage;

public class LoginPageTest extends BasePageTest {


    private LoginPage loginPage;
    private AccountDeletedPage accountDeletedPage;

    @BeforeMethod
    public void initPages() {
        loginPage = new LoginPage(driver);
        accountDeletedPage = new AccountDeletedPage(driver);
    }

    @Test
    public void registerForLogin() {
        registerNewUser();
    }

    // eğer birden fazla method'a bağımlılık varsa
    // dependsOnMethod = {"method1", "method2"} şeklinde yazılır.
    @Test(dependsOnMethods = "registerForLogin")
    public void successLoginTest() {

        Assert.assertTrue(homePage.isHomePageLoaded(), "Ana sayfa yüklenemedi!");
        homePage.clickSignupLoginButton();
        loginPage.fillLoginForm(randomPerson.email, randomPerson.password);
        Assert.assertTrue(homePage.isUserLoggedIn(), "Login başarısız!");
        homePage.deleteAccount();
        Assert.assertTrue(accountDeletedPage.isAccountDeleted(), "Hesap silinemedi");
        accountDeletedPage.clickContinueButton();
    }

    @Test(dependsOnMethods = "registerForLogin")
    public void unsuccessLoginTest() {

        Assert.assertTrue(homePage.isHomePageLoaded(), "Ana sayfa yüklenemedi!");
        homePage.clickSignupLoginButton();
        loginPage.fillLoginForm(randomPerson.email, randomPerson.password + "q");
        Assert.assertTrue(loginPage.isIncorrectEmailOrPasswordMessageDisplayed(),"Kullanıcı adı veya şifre yanlış");
    }

    @Test(dependsOnMethods = "registerForLogin")
    public void logoutTest() {

        Assert.assertTrue(homePage.isHomePageLoaded(), "Ana sayfa yüklenemedi!");
        homePage.clickSignupLoginButton();
        loginPage.fillLoginForm(randomPerson.email, randomPerson.password);
        Assert.assertTrue(homePage.isUserLoggedIn(), "Login başarısız!");
        homePage.clickLogoutButton();
        Assert.assertTrue(loginPage.isLoginPageLoaded(), "Logout başarısız, login sayfasına yönlendirilemedi!");
    }
}
