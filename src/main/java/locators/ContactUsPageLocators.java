package locators;

import org.openqa.selenium.By;

public class ContactUsPageLocators {
    public static final By getInTouchTitle = By.xpath("//h2[contains(text(),'Get In Touch')]");
    public static final By nameInput = By.cssSelector("[data-qa='name']");
    public static final By emailInput = By.cssSelector("[data-qa='email']");
    public static final By subjectInput = By.cssSelector("[data-qa='subject']");
    public static final By messageInput = By.cssSelector("[data-qa='message']");
    public static final By uploadFileInput = By.name("upload_file");
    public static final By submitButton = By.cssSelector("[data-qa='submit-button']");
    public static final By successMessage = By.xpath("//div[@class='contact-form']//div[contains(@class,'alert-success')]");
}
