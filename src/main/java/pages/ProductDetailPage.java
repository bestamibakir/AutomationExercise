package pages;

import locators.ProductDetailPageLocators;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class ProductDetailPage extends BasePage {
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductDetailPageLoaded() {
        return isElementExist(ProductDetailPageLocators.productDetail, Integer.parseInt(ConfigReader.get("timeout.default"))) ||
                waitUntilUrlContains(ConfigReader.get("product.detail.url"), Integer.parseInt(ConfigReader.get("timeout.default")));
    }

    public String getProductName() {
        return getText(ProductDetailPageLocators.detailProductName);
    }

    public String getProductPrice() {
        return getText(ProductDetailPageLocators.detailProductPrice);
    }
}
