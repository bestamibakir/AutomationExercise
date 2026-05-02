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


}
