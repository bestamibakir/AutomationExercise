package tests;

import locators.CommonLocators;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestCasesPage;

public class TestCasesPageTest extends BasePageTest{

    @Test
    public void testCasesPageTest(){
        HomePage homePage = new HomePage(driver);
        TestCasesPage testCasesPage = new TestCasesPage(driver);

        Assert.assertTrue(homePage.isHomePageLoaded());
        homePage.click(CommonLocators.testCasesButtonLocator);

        Assert.assertTrue(testCasesPage.isTestCasesPageLoaded());

    }
}
