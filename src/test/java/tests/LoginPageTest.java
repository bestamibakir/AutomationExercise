package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountDeletedPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends BasePageTest {

    @Test
    public void registerForLogin() {
        registerNewUser();
    }

    // eğer birden fazla method'a bağımlılık varsa
    // dependsOnMethod = {"method1", "method2"} şeklinde yazılır.
    @Test(dependsOnMethods = "registerForLogin")
    public void successLoginTest() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);

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
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(homePage.isHomePageLoaded(), "Ana sayfa yüklenemedi!");
        homePage.clickSignupLoginButton();
        loginPage.fillLoginForm(randomPerson.email, randomPerson.password + "q");
        Assert.assertTrue(loginPage.isIncorrectEmailOrPasswordMessageDisplayed(),"Kullanıcı adı veya şifre yanlış");
    }

    @Test(dependsOnMethods = "registerForLogin")
    public void logoutTest() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(homePage.isHomePageLoaded(), "Ana sayfa yüklenemedi!");
        homePage.clickSignupLoginButton();
        loginPage.fillLoginForm(randomPerson.email, randomPerson.password);
        Assert.assertTrue(homePage.isUserLoggedIn(), "Login başarısız!");
        homePage.clickLogoutButton();
        Assert.assertTrue(loginPage.isLoginPageLoaded(), "Logout başarısız, login sayfasına yönlendirilemedi!");
    }
}
