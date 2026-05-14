package pages;

import locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillLoginForm(String email, String password) {
        sendKeys(LoginPageLocators.loginEmailInput, email);
        sendKeys(LoginPageLocators.loginPasswordInput, password);
        click(LoginPageLocators.loginButton);
    }

    public void fillSignUpForm(String firstName, String email){
        sendKeys(LoginPageLocators.signUpNameInput, firstName);
        sendKeys(LoginPageLocators.signUpEmailInput, email);
        click(LoginPageLocators.signUpButton);
    }

    public boolean isLoginPageLoaded() {
        return isElementExist(LoginPageLocators.loginFormTitle, Integer.parseInt(ConfigReader.get("timeout.default"))) ||
                isElementExist(LoginPageLocators.signUpEmailInput, Integer.parseInt(ConfigReader.get("timeout.default"))) ||
                waitUntilUrlContains(ConfigReader.get("login.url"));
    }

    public boolean isIncorrectEmailOrPasswordMessageDisplayed() {
        return isElementExist(LoginPageLocators.incorrectEmailOrPassword);
    }

    public boolean isEmailAlreadyExistMessageDisplayed() {
        return isElementExist(LoginPageLocators.emailAlreadyExist);
    }
}
