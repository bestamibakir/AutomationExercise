package pages;

import locators.AccountDeletedPageLocators;
import org.openqa.selenium.WebDriver;

public class AccountDeletedPage extends BasePage{
    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountDeleted(){
        return isElementExist(AccountDeletedPageLocators.accountDeletedText);
    }

    public void clickContinueButton(){
        click(AccountDeletedPageLocators.continueButton);
    }
}
