package pages;

import locators.CommonLocators;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageLoaded() {
        return (isElementExist(CommonLocators.navbarLocator)
                && isElementExist(CommonLocators.activeNavbarButton)) || waitUntilUrlContains(ConfigReader.get("base.url"));
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

    public void clickLogoutButton() {
        click(CommonLocators.logoutButtonLocator);
    }

    public void subscribeWithEmail(String email) {
        scrollToBottom();
        sendKeys(CommonLocators.footerSubscription, email);
        click(CommonLocators.subscribeButtonLocator);
    }

    public boolean isSubscriptionSuccessVisible() {
        return isElementVisible(CommonLocators.subscriptionSuccessText);
    }
}
