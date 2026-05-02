package pages;

import base.RandomPersonForRegistration;
import locators.RegisterPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    public void fillRegistrationFrom(RandomPersonForRegistration randomPerson){
        try {
            // male female -> mr. mrs. dönüşümü
            String randomTitle = randomPerson.gender.equalsIgnoreCase("Male") ? "Mr." : "Mrs.";
            // dönüştürdüğümüz mr. mrs. radio buttonlarına rastgele tıklatma işlemi
            selectTitle(randomTitle);

            sendKeys(RegisterPageLocators.passwordInput,randomPerson.password);
            fillBirthDate(randomPerson.birthDay,randomPerson.birthMonth,randomPerson.birthYear);
            selectNewsletterCheckbox();
            selectOfferCheckbox();
            sendKeys(RegisterPageLocators.addressFirstNameInput,randomPerson.firstName);
            sendKeys(RegisterPageLocators.addressLastNameInput,randomPerson.lastName);
            sendKeys(RegisterPageLocators.companyNameInput,randomPerson.companyName);
            sendKeys(RegisterPageLocators.address1Input,randomPerson.fullAddress);
            sendKeys(RegisterPageLocators.address2Input,randomPerson.address2);
            new Select(driver.findElement(RegisterPageLocators.countryInput)).selectByVisibleText(randomPerson.countryName);
            sendKeys(RegisterPageLocators.stateInput,randomPerson.state);
            sendKeys(RegisterPageLocators.cityInput,randomPerson.city);
            sendKeys(RegisterPageLocators.zipcodeInput,randomPerson.zipcode);
            sendKeys(RegisterPageLocators.phoneNumberInput,randomPerson.phoneNumber);

            click(RegisterPageLocators.creatAccountButton);
        } catch (ElementNotInteractableException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectTitle(String gender){
        String dynamicXPath = String.format((RegisterPageLocators.userGenderRadioButton), gender);
        click(By.xpath(dynamicXPath));
    }

    public void fillBirthDate(String birthDay, String birthMonth, String birthYear) {

        //Bir objeyi sadece bir kez kullanacaksan değişkene atamak şart değil. Birden fazla kullanacaksan muhakkak değişkene ata.

        // aşağıdaki kullanım da bir seçim şekli
//        Select dayDropdown = new Select(driver.findElement(RegisterPageLocators.dateOfBirthDayInput));
//        dayDropdown.selectByVisibleText(randomPerson.birthDay);

        // burada direkt zincirleme işlem yapıyoruz.
        // Gün seçimi (sayısal: "15" gibi)
        try {
            new Select(driver.findElement(RegisterPageLocators.dateOfBirthDayInput))
                    .selectByVisibleText(birthDay);
            // Ay seçimi (tam isim: "January", "February" gibi)
            new Select(driver.findElement(RegisterPageLocators.dateOfBirthMonthInput))
                    .selectByVisibleText(birthMonth);
            // Yıl seçimi (sayısal: "1990" gibi)
            new Select(driver.findElement(RegisterPageLocators.dateOfBirthYearInput))
                    .selectByVisibleText(birthYear);
        } catch (ElementNotInteractableException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectNewsletterCheckbox(){
        WebElement checkbox = driver.findElement(RegisterPageLocators.newsletterCheckbox);

        if (!checkbox.isSelected()){
            click(RegisterPageLocators.newsletterCheckbox);
        }
    }

    public void selectOfferCheckbox(){
        WebElement checkbox = driver.findElement(RegisterPageLocators.offerCheckbox);

        if (!checkbox.isSelected()){
            click(RegisterPageLocators.offerCheckbox);
        }
    }

    public boolean isSignUpPageLoaded() {
        return isElementExist(RegisterPageLocators.formTitle, Integer.parseInt(ConfigReader.get("timeout.default")));
    }

}
