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

    public boolean isProductCategoryVisible() {
        return isElementVisible(ProductDetailPageLocators.detailProductCategory);
    }

    public boolean isProductConditionVisible() {
        return isElementVisible(ProductDetailPageLocators.detailProductCondition);
    }

    public boolean isProductBrandVisible() {
        return isElementVisible(ProductDetailPageLocators.detailProductBrand);
    }

    public boolean isProductAvailabilityVisible() {
        return isElementVisible(ProductDetailPageLocators.detailProductAvailability);
    }
}
