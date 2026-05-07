package locators;

import org.openqa.selenium.By;

public class CommonLocators {
    public static final By navbarLocator = By.className("navbar-nav");

    //normalize-space aranan textin tamamını ister
    public static final By homePageButtonLocator = By.xpath("//a[normalize-space()='Home']");
    public static final By loginSignUpButtonLocator = By.xpath("//a[contains(text(),'Signup')]");
    public static final By productsButtonLocator = By.xpath("//a[contains(text(),'Products')]");
    public static final By cartButtonLocator = By.xpath("//a[normalize-space()='Cart']");
    public static final By testCasesButtonLocator = By.xpath("//a[contains(text(),'Test Cases')]");
    public static final By contactUsButtonLocator = By.xpath("//a[normalize-space()='Contact us']");
    public static final By loggedUserLocator = By.xpath("//a[contains(text(),'Logged')]");
    public static final By deleteAccountButtonLocator = By.xpath("//a[contains(text(),'Delete')]");
    public static final By logoutButtonLocator = By.xpath("//a[contains(text(),'Logout')]");

    public static final By activeNavbarButton = By.xpath("//a[@href='/' and @style='color: orange;']");

}
