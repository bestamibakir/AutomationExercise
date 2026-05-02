package locators;

import org.openqa.selenium.By;

public class AccountDeletedPageLocators {

    public static final By accountDeletedText = By.xpath("//h2[contains(@class, 'text-center')]//b[contains(normalize-space(),'Account')]");
    public static final By continueButton = By.cssSelector("[data-qa='continue-button']");

}
