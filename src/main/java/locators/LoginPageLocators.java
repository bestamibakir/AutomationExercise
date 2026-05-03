package locators;


import org.openqa.selenium.By;

public class LoginPageLocators {
    public static final By activeNavbarButton = By.xpath("//a[@href='/login' and @style='color: orange;']");

    // LOGIN FORM
    public static final By loginFormTitle = By.xpath("//div[@class='login-form']/h2[contains(text(),'Login')]");

    //xpath olarak şu da kullanılabilir -> //div[@class='login-form']//input[normalize-space(@placeholder)='Email Address']
    public static final By loginEmailInput = By.xpath("//div[@class='login-form']//input[contains(normalize-space(@placeholder),'Email')]");
    public static final By loginPasswordInput = By.xpath("//div[@class='login-form']//input[normalize-space(@placeholder)='Password']");

    public static final By loginButton = By.xpath("//div[@class='login-form']//button[text()='Login']");

    public static final By incorrectEmailOrPassword = By.xpath("//p[contains(text(),'incorrect')]");

    public static final By emailAlreadyExist = By.xpath("//p[contains(text(),'already exist')]");


    // SIGNUP FORM
    public static final By signUpFormTitle = By.xpath("//div[@class='signup-form']/h2[contains(text(),'New User Signup')]");

    //xpath olarak şu da kullanılabilir -> //div[@class='signup-form']//input[contains(@placeholder,'Name')]
    public static final By signUpNameInput = By.xpath("//div[@class='signup-form']//input[normalize-space(@placeholder)='Name']");

    //xpath olarak şu da kullanılabilir -> //div[@class='signup-form']//input[contains(@placeholder,'Email')]
    public static final By signUpEmailInput = By.xpath("//div[@class='signup-form']//input[normalize-space(@placeholder)='Email Address']");

    public static final By signUpButton = By.xpath("//div[@class='signup-form']//button[text()='Signup']");
}
