package pages;

import locators.CartPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartPageLoaded(){
        return isElementExist(CartPageLocators.shoppingCartText) ||
                waitUntilUrlContains(ConfigReader.get("cart.url"),
                        Integer.parseInt(ConfigReader.get("timeout.default")));
    }

    public List<Integer> getAllProductPricesAsInt() {
        List<WebElement> priceElements = getAllVisibleElements(CartPageLocators.allCartPrices);
        List<Integer> pricesList = new ArrayList<>();

        for (WebElement element : priceElements) {
            String text = element.getText(); // Örn: "Rs. 500"
            pricesList.add(Integer.parseInt(text.replaceAll("[^0-9]", ""))); // 500 olarak listeye ekle
        }
        return pricesList;
    }

    public List<Integer> getAllProductQuantitiesAsInt() {
        List<WebElement> quantityElements = getAllVisibleElements(CartPageLocators.allCartQuantities);
        List<Integer> quantityList = new ArrayList<>();

        for (WebElement element : quantityElements) {
            quantityList.add(Integer.parseInt(element.getText().replaceAll("[^0-9]", "")));
        }
        return quantityList;
    }

    public List<Integer> getAllProductTotalPricesAsInt() {
        List<WebElement> totalElements = getAllVisibleElements(CartPageLocators.allCartTotalPrices);
        List<Integer> totalList = new ArrayList<>();

        for (WebElement element : totalElements) {
            totalList.add(Integer.parseInt(element.getText().replaceAll("[^0-9]", "")));
        }
        return totalList;
    }

    public List<String> getAllProductNames() {
        List<WebElement> productNameElements = getAllVisibleElements(CartPageLocators.allCartNames);
        List<String> productNames = new ArrayList<>();
        for (WebElement element : productNameElements) {
            productNames.add(element.getText());
        }
        return productNames;
    }

}
