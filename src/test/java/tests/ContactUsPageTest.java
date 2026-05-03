package tests;

import base.RandomContactUsData;
import locators.CommonLocators;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsPageTest extends BasePageTest {

    @Test
    public void contactUsFormTest() {
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        RandomContactUsData randomContactUsData = new RandomContactUsData();

        Assert.assertTrue(homePage.isHomePageLoaded(), "Ana sayfa yüklenemedi!");

        homePage.click(CommonLocators.contactUsButtonLocator);
        Assert.assertTrue(contactUsPage.isGetInTouchVisible(), "'Get In Touch' başlığı görünmüyor!");
        contactUsPage.fillContactForm(
                randomContactUsData.name,
                randomContactUsData.email,
                randomContactUsData.subject,
                randomContactUsData.message);
        contactUsPage.uploadFile(System.getProperty("user.dir") + "/src/main/resources/contact-us.txt");
        contactUsPage.clickSubmitButton();
        contactUsPage.acceptAlert();
        Assert.assertTrue(contactUsPage.isSuccessMessageVisible(), "Başarı mesajı görüntülenemedi!");


        homePage.click(CommonLocators.homePageButtonLocator);
        Assert.assertTrue(homePage.isHomePageLoaded(), "Ana sayfaya dönülemedi!");
    }
}
