package tests;

import locators.CommonLocators;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TestCasesPage;

public class TestCasesPageTest extends BasePageTest{

    private TestCasesPage testCasesPage;

    @BeforeMethod
    public void initPages() {
        testCasesPage = new TestCasesPage(driver);
    }

    @Test
    public void testCasesPageTest(){

        Assert.assertTrue(homePage.isHomePageLoaded(), "Ana sayfa yüklenemedi");
        homePage.click(CommonLocators.testCasesButtonLocator);

        Assert.assertTrue(testCasesPage.isTestCasesPageLoaded(), "Test cases sayfası yüklenemedi");

    }
}
