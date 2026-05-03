package tests;

import base.RandomPersonForRegistration;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class RegisterPageTest extends BasePageTest{

    @Test
    public void registerUser() {
        registerNewUser();

        HomePage homePage = new HomePage(driver);
        AccountDeletedPage accountDeletedPage = new AccountDeletedPage(driver);

        Assert.assertTrue(homePage.isUserLoggedIn(), "Kullanıcı girişi başarılı olamadı");
        homePage.deleteAccount();
        Assert.assertTrue(accountDeletedPage.isAccountDeleted(), "Hesap silinemedi");
        accountDeletedPage.clickContinueButton();
    }

    @Test
    public void registerWithExistingEmail() {
        registerNewUser();

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Kullanıcı giriş yapmış durumda, önce çıkış yapıyoruz
        Assert.assertTrue(homePage.isUserLoggedIn(), "Kullanıcı giriş yapmış olmalı!");
        homePage.clickLogoutButton();

        // Logout sonrası login sayfasına yönlendirilir
        Assert.assertTrue(loginPage.isLoginPageLoaded(), "Login sayfası yüklenemedi!");

        // Aynı email ile tekrar kayıt olmaya çalışıyoruz
        loginPage.fillSignUpForm(randomPerson.firstName, randomPerson.email);

        Assert.assertTrue(loginPage.isEmailAlreadyExistMessageDisplayed(),
                "Email zaten kayıtlı uyarısı görüntülenemedi!");
    }

}
