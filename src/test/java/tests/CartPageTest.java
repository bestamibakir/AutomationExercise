package tests;

import locators.CommonLocators;
import locators.ProductPageLocators;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import utils.ConfigReader;

public class CartPageTest extends BasePageTest {

    private CartPage cartPage;
    private ProductsPage productsPage;

    @BeforeMethod
    public void initPages(){
        cartPage = new CartPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void cartPageSubscriptionInFooterTest(){
        Assert.assertTrue(homePage.isHomePageLoaded(), "Ana sayfa yüklenemedi");
        homePage.click(CommonLocators.cartButtonLocator);

        Assert.assertTrue(cartPage.isCartPageLoaded(), "Sepet sayfası yüklenemedi");

        homePage.scrollToBottom();
        Assert.assertTrue(homePage.isFooterVisible(), "Subscription yazısı görünmedi");
        homePage.subscribeWithEmail(ConfigReader.get("random.email"));
        Assert.assertTrue(homePage.isSubscriptionSuccessVisible(), "Başarı mesajı görüntülenemedi!"
        );
    }


    @Test
    public void addingProductsAndNavigateToCartPage(){
        Assert.assertTrue(homePage.isHomePageLoaded(), "Ana sayfa yüklenemedi");
        homePage.click(CommonLocators.productsButtonLocator);
        Assert.assertTrue(productsPage.isProductsPageLoaded(), "Ürünler sayfası yüklenemedi");

        int firstProductIndex = 1;
        int secondProductIndex = 2;

        String productPageProductName1 = productsPage.getProductNameByIndex(firstProductIndex);
        int productPageProductPrice1 = productsPage.getProductPriceAsInt(firstProductIndex);

        productsPage.hoverAndClickProductByIndex(firstProductIndex);
        homePage.click(ProductPageLocators.continueButton);

        String productPageProductName2 = productsPage.getProductNameByIndex(secondProductIndex);
        int productPageProductPrice2 = productsPage.getProductPriceAsInt(secondProductIndex);

        productsPage.hoverAndClickProductByIndex(secondProductIndex);
        homePage.click(ProductPageLocators.viewCartButton);


        String cartPageProductName1 = cartPage.getProductNameByIndex(firstProductIndex);
        int cartPageProductPrice1 = cartPage.getProductPriceAsInt(firstProductIndex);
        int cartPageProductQuantity1 = cartPage.getProductQuantityAsInt(firstProductIndex);
        int cartPageProductTotal1 = cartPage.getProductTotalPriceAsInt(firstProductIndex);

        int calculatedTotal1 = cartPageProductPrice1 * cartPageProductQuantity1;

        String cartPageProductName2 = cartPage.getProductNameByIndex(secondProductIndex);
        int cartPageProductPrice2 = cartPage.getProductPriceAsInt(secondProductIndex);
        int cartPageProductQuantity2 = cartPage.getProductQuantityAsInt(secondProductIndex);
        int cartPageProductTotal2 = cartPage.getProductTotalPriceAsInt(secondProductIndex);

        int calculatedTotal2 = cartPageProductPrice2 * cartPageProductQuantity2;

        Assert.assertEquals(productPageProductName1, cartPageProductName1, "Ürün isimleri uyumsuz");
        Assert.assertEquals(productPageProductPrice1, cartPageProductPrice1, "Ürün fiyatları uyumsuz");

        Assert.assertEquals(productPageProductName2, cartPageProductName2, "Ürün isimleri uyumsuz");
        Assert.assertEquals(productPageProductPrice2, cartPageProductPrice2, "Ürün fiyatları uyumsuz");

        Assert.assertEquals(cartPageProductTotal1, calculatedTotal1, "Sepetteki ürünün toplam fiyatı yanlış hesaplanmış!");
        Assert.assertEquals(cartPageProductTotal2, calculatedTotal2, "Sepetteki ürünün toplam fiyatı yanlış hesaplanmış!");

    }

}
