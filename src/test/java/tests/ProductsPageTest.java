package tests;

import locators.CommonLocators;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductDetailPage;
import pages.ProductsPage;

public class ProductsPageTest extends BasePageTest{

    private ProductsPage productsPage;
    private ProductDetailPage productDetailPage;

    @BeforeMethod
    public void initPages() {
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
    }

    @Test
    public void checkProductsPageTest() {
        navigateToProductsPage();

        String expectedName = productsPage.getFirstProductName();
        String expectedPrice = productsPage.getFirstProductPrice();

        productsPage.clickFirstViewProductButton();

        String actualName = productDetailPage.getProductName();
        String actualPrice = productDetailPage.getProductPrice();

        Assert.assertEquals(actualName, expectedName);
        Assert.assertEquals(actualPrice, expectedPrice);
    }

    @Test
    public void searchProductTest() {
        navigateToProductsPage();

        Assert.assertTrue(productDetailPage.isProductDetailPageLoaded(), "Ürün etay sayfası yüklenemedi");

        productsPage.searchProduct("men");

        Assert.assertTrue(productsPage.checkProductListIsDisplayed(), "Ana sayfa yüklenemedi");
        Assert.assertTrue(productsPage.allProductNamesContain("men"),
                "Bazı ürün isimleri 'men' içermiyor!");
    }

    protected void navigateToProductsPage() {
        Assert.assertTrue(homePage.isHomePageLoaded(), "Ana sayfa yüklenemedi");
        homePage.click(CommonLocators.productsButtonLocator);
        Assert.assertTrue(productsPage.isProductsPageLoaded(), "Ürünler sayfası yüklenemedi");
        Assert.assertTrue(productsPage.checkProductListIsDisplayed(), "Ürünler listelenemedi");
    }

}
