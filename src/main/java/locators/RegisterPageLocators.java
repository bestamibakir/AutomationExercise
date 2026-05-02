package locators;

import org.openqa.selenium.By;

public class RegisterPageLocators{

    public static final By formTitle = By.xpath("//h2/b[contains(text(),'Enter')]");

//  public static final By userGender1RadioButton = By.id("id_gender1");
//  public static final By userGender2RadioButton = By.id("id_gender2");

    // (//input[@type='radio'])[1] ya da (//input[@type='radio'])[2] şeklinde girerek rastgele seçim yapılabilir
    public static final String userGenderRadioButton = "//label[normalize-space()='%s']/div/span/input";
    public static final By passwordInput = By.id("password");

    public static final By dateOfBirthDayInput = By.id("days");
    public static final By dateOfBirthMonthInput = By.id("months");
    public static final By dateOfBirthYearInput = By.id("years");

    public static final By newsletterCheckbox = By.id("newsletter");
    public static final By offerCheckbox = By.id("optin");

    public static final By addressFirstNameInput = By.id("first_name");
    public static final By addressLastNameInput = By.id("last_name");
    public static final By companyNameInput = By.id("company");
    public static final By address1Input = By.id("address1");
    public static final By address2Input = By.id("address2");
    public static final By countryInput = By.id("country");
    public static final By stateInput = By.id("state");
    public static final By cityInput = By.id("city");
    public static final By zipcodeInput = By.id("zipcode");
    public static final By phoneNumberInput = By.id("mobile_number");

    //xpath olarak şu da kullanılabilir -> //button[contains(@class,'btn-default') and normalize-space()='Create Account']
    public static final By creatAccountButton = By.xpath("//button[contains(@class,'btn-default') and contains(normalize-space(),'Create')]");

}
