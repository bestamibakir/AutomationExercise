package locators;

import org.openqa.selenium.By;

public class CartPageLocators {

    public static final By shoppingCartText = By.cssSelector(".breadcrumb li.active");

    public static final By allCartNames = By.xpath("//table[@id='cart_info_table']//h4/a");
    public static final By allCartPrices = By.xpath("//table[@id='cart_info_table']//td[@class='cart_price']//p");
    public static final By allCartQuantities = By.xpath("//table[@id='cart_info_table']//td[@class='cart_quantity']//button");
    public static final By allCartTotalPrices = By.xpath("//table[@id='cart_info_table']//td[@class='cart_total']/p[@class='cart_total_price']");

}
