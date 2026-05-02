package pages;

import locators.CommonLocators;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageLoaded() {
        return isElementExist(CommonLocators.navbarLocator)
                && isElementExist(CommonLocators.activeNavbarButton);
    }

    public void clickSignupLoginButton() {
        click(CommonLocators.loginSignUpButtonLocator);
    }

    public boolean isUserLoggedIn() {
        return isElementExist(CommonLocators.loggedUserLocator);
    }

    public void deleteAccount() {
        click(CommonLocators.deleteAccountButtonLocator);
    }
}
