package locators;

import org.openqa.selenium.By;

public class AccountCreatedPageLocators {
    // xpath olarak şu da kullanılabilir -> //*[@data-qa='account-created']
    // ya da cssSelector olarak -> cssSelector("[data-qa='account-created']");
    // hatta eğer ki sayfa kaynak kodunda data-qa, data-test ya da data-testid gibi attributelar varsa onları kullan
    // bu attributelar test otomasyon için biçilmiş kaftan
    public static final By accountCreatedText = By.xpath("//h2[contains(@class, 'text-center')]//b[contains(normalize-space(),'Account')]");
    public static final By continueButton = By.cssSelector("[data-qa='continue-button']");


}
