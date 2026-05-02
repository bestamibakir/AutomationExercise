package pages;

import locators.AccountCreatedPageLocators;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage{
    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public boolean continueButtonClick(){
        return click(AccountCreatedPageLocators.continueButton);
    }

    public boolean isAccountCreated(){
        return isElementExist(AccountCreatedPageLocators.accountCreatedText);
    }
}
