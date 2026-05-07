package locators;

import org.openqa.selenium.By;

public class ProductDetailPageLocators {

    public static final By productDetail = By.cssSelector("div.product-details");

    public static final By detailProductName = By.cssSelector("div.product-information h2");
    public static final By detailProductPrice = By.cssSelector("div.product-information span span");
}
