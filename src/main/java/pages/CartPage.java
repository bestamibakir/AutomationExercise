package pages;

import locators.CartPageLocators;
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

    public String getProductNameByIndex(int index){
        return getText(CartPageLocators.getShoppingCartProductNameByIndex(index));
    }

    public String getProductPriceByIndex(int index){
        return getText(CartPageLocators.getShoppingCartProductPriceByIndex(index));
    }

    public String getProductQuantityByIndex(int index){
        return getText(CartPageLocators.getShoppingCartProductQuantityByIndex(index));
    }

    public String getProductTotalPriceByIndex(int index){
        return getText(CartPageLocators.getShoppingCartProductTotalPriceByIndex(index));
    }

    public int getProductPriceAsInt(int index) {
        String priceText = getProductPriceByIndex(index);

        if (priceText == null || priceText.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(priceText.replaceAll("[^0-9]", ""));
    }

    public int getProductQuantityAsInt(int index) {
        String quantityText = getProductQuantityByIndex(index);

        if (quantityText == null || quantityText.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(quantityText.replaceAll("[^0-9]", ""));
    }

    public int getProductTotalPriceAsInt(int index) {
        String totalPriceText = getProductTotalPriceByIndex(index);

        if (totalPriceText == null || totalPriceText.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(totalPriceText.replaceAll("[^0-9]", ""));
    }

}
