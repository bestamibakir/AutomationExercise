package pages;

import locators.ContactUsPageLocators;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isGetInTouchVisible() {
        return isElementExist(ContactUsPageLocators.getInTouchTitle);
    }

    public void fillContactForm(String name, String email, String subject, String message) {
        sendKeys(ContactUsPageLocators.nameInput, name);
        sendKeys(ContactUsPageLocators.emailInput, email);
        sendKeys(ContactUsPageLocators.subjectInput, subject);
        sendKeys(ContactUsPageLocators.messageInput, message);
    }

    public void uploadFile(String filePath) {
        sendKeys(ContactUsPageLocators.uploadFileInput, filePath);
    }

    public void clickSubmitButton() {
        click(ContactUsPageLocators.submitButton);
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public boolean isSuccessMessageVisible() {
        return isElementExist(ContactUsPageLocators.successMessage);
    }
}
