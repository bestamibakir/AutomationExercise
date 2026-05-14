package locators;

import org.openqa.selenium.By;

public class CartPageLocators {

    public static final By shoppingCartText = By.cssSelector(".breadcrumb li.active");

    public static By getShoppingCartProductNameByIndex(int index){
        return By.xpath("(//table[@id='cart_info_table']//h4/a)["+ index +"]");
    }

    public static By getShoppingCartProductPriceByIndex(int index){
        return By.xpath("(//table[@id='cart_info_table']//td[@class='cart_price']//p)["+ index +"]");
    }

    public static By getShoppingCartProductQuantityByIndex(int index){
        return By.xpath("(//table[@id='cart_info_table']//td[@class='cart_quantity']//button)["+ index +"]");
    }

    public static By getShoppingCartProductTotalPriceByIndex(int index){
        return By.xpath("(//table[@id='cart_info_table']//td[@class='cart_total']/p[@class='cart_total_price'])["+ index +"]");
    }



}
