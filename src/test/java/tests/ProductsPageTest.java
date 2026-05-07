package tests;

import locators.CommonLocators;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.ProductsPage;

public class ProductsPageTest extends BasePageTest{

    @Test
    public void checkProductsPageTest(){
        HomePage homePage = new HomePage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);

        Assert.assertTrue(homePage.isHomePageLoaded());
        homePage.click(CommonLocators.productsButtonLocator);

        Assert.assertTrue(productsPage.isProductsPageLoaded());
        Assert.assertTrue(productsPage.checkProductListIsDisplayed());

        String expectedName = productsPage.getFirstProductName();
        String expectedPrice = productsPage.getFirstProductPrice();

        productsPage.clickFirstViewProductButton();

        String actualName = productDetailPage.getProductName();
        String actualPrice = productDetailPage.getProductPrice();

        Assert.assertEquals(actualName, expectedName);
        Assert.assertEquals(actualPrice, expectedPrice);
    }



}
