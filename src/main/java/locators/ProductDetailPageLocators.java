package locators;

import org.openqa.selenium.By;

public class ProductDetailPageLocators {

    public static final By productDetail = By.cssSelector("div.product-details");

    public static final By detailProductName = By.cssSelector("div.product-information h2");
    public static final By detailProductPrice = By.cssSelector("div.product-information span span");
    public static final By detailProductCategory = By.xpath("//div[@class='product-information']//p[contains(text(), 'Category')]");
    public static final By detailProductAvailability = By.xpath("//div[@class='product-information']//p[b[contains(text(), 'Availability')]]");
    public static final By detailProductCondition = By.xpath("//div[@class='product-information']//p[b[contains(text(), 'Condition')]]");
    public static final By detailProductBrand = By.xpath("//div[@class='product-information']//p[b[contains(text(), 'Brand')]]");

}
