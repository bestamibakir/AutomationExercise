package pages;

import locators.ProductPageLocators;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductsPageLoaded() {
        return isElementExist(ProductPageLocators.allProductText) ||
                waitUntilUrlContains(ConfigReader.get("products.url"), Integer.parseInt(ConfigReader.get("timeout.default")));
    }

    public boolean checkProductListIsDisplayed() {
        return isElementExist(ProductPageLocators.productList);
    }

    public boolean clickFirstViewProductButton() {
        return click(ProductPageLocators.firstViewProductButton);
    }

    public String getFirstProductName() {
        return getText(ProductPageLocators.firstProductName);
    }

    public String getFirstProductPrice() {
        return getText(ProductPageLocators.firstProductPrice);
    }
}
