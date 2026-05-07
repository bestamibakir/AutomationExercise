package locators;

import org.openqa.selenium.By;

public class ProductPageLocators {

    public static final By allProductText = By.xpath("//h2[contains(text(), 'All Products')]");
    public static final By productList = By.cssSelector("div.features_items div.col-sm-4 div.single-products");

    public static final By viewProductButton = By.xpath("//div[contains(@class,'choose')]//a[contains(text(),'View')]");
    public static final By firstViewProductButton = By.xpath("(//div[contains(@class,'choose')]//a[contains(text(),'View')])[1]");

    public static final By firstProductName = By.xpath("(//div[@class='productinfo text-center']//p)[1]");
    public static final By firstProductPrice = By.xpath("(//div[@class='productinfo text-center']//h2)[1]");

    public static final By searchInput = By.id("search_product");
    public static final By searchButton = By.id("submit_search");

    public static final By productNames = By.xpath("//div[@class='productinfo text-center']//p");

}
