package pages;

import locators.TestCasesPageLocators;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class TestCasesPage extends BasePage{
    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTestCasesPageLoaded() {
        return isElementExist(TestCasesPageLocators.testCaseTitle, Integer.parseInt(ConfigReader.get("timeout.default"))) ||
                waitUntilUrlContains(ConfigReader.get("test.cases.url"));
    }
}
