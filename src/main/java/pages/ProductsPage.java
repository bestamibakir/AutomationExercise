package pages;

import locators.ProductPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.ConfigReader;

import java.util.List;

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

    public String getProductNameByIndex(int index) {
        return getText(ProductPageLocators.getProductNameByIndex(index));
    }

    public String getProductPriceByIndex(int index) {
        return getText(ProductPageLocators.getProductPriceByIndex(index));
    }

    public int getProductPriceAsInt(int index) {
        String priceText = getProductPriceByIndex(index);

        if (priceText == null || priceText.isEmpty()) {
            return 0;
        }

        return Integer.parseInt(priceText.replaceAll("[^0-9]", ""));
    }

    public void searchProduct(String productName) {
        sendKeys(ProductPageLocators.searchInput, productName);
        click(ProductPageLocators.searchButton);
    }

    public boolean allProductNamesContain(String keyword) {
        List<WebElement> products = getAllVisibleElements(ProductPageLocators.productNames);

        if (products.isEmpty()) {
            return false;
        }

        for (WebElement product : products) {
            if (!product.getText().toLowerCase().contains(keyword.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public void hoverAndClickProductByIndex(int index) {
        WebElement productCard = helper.visible(ProductPageLocators.getProductCardByIndex(index));

        Actions actions = new Actions(driver);
        actions.moveToElement(productCard).perform();

        click(ProductPageLocators.getAddToCartOverlayByIndex(index));
    }
}
