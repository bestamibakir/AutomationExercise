package pages;

import locators.CartPageLocators;
import locators.CommonLocators;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartPageLoaded(){
        return isElementExist(CartPageLocators.shoppingCartText) ||
                waitUntilUrlContains(ConfigReader.get("cart.url"),
                        Integer.parseInt(ConfigReader.get("timeout.default")));
    }

}
