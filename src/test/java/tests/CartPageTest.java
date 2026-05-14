package tests;

import locators.CommonLocators;
import locators.ProductPageLocators;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import utils.ConfigReader;

import java.util.ArrayList;
import java.util.List;

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

        // ProductPage'de sepete eklenecek olan
        // ürünlerin isimlerini ve fiyatlarını
        // boş listelere yazarak
        // CartPage'de karşılaştırmasını yapabiliyoruz.
        List<String> expectedProductNames = new ArrayList<>();
        List<Integer> expectedProductPrices = new ArrayList<>();

        int firstProductIndex = 1;
        expectedProductNames.add(productsPage.getProductNameByIndex(firstProductIndex));
        expectedProductPrices.add(productsPage.getProductPriceAsInt(firstProductIndex));
        productsPage.hoverAndClickProductByIndex(firstProductIndex);
        homePage.click(ProductPageLocators.continueButton);

        int secondProductIndex = 2;
        expectedProductNames.add(productsPage.getProductNameByIndex(secondProductIndex));
        expectedProductPrices.add(productsPage.getProductPriceAsInt(secondProductIndex));
        productsPage.hoverAndClickProductByIndex(secondProductIndex);
        homePage.click(ProductPageLocators.viewCartButton);


        // CartPage'de sepetteki tüm ürünlerin
        // isimlerini, fiyatlarını, miktarlarını ve toplam fiyatlarını
        // listeye ekleyerek for döngüsü kullanarak
        // dinamik bir karşılaştırma yapabileceğiz.
        List<String> actualProductNames = cartPage.getAllProductNames();
        List<Integer> actualProductPrices = cartPage.getAllProductPricesAsInt();
        List<Integer> actualProductQuantities = cartPage.getAllProductQuantitiesAsInt();
        List<Integer> actualProductTotals = cartPage.getAllProductTotalPricesAsInt();

//        aşağıdaki for döngüsü
//        -> Assert.assertEquals(actualProductNames, expectedProductNames, "Sepetteki ürün isimleri eklenenlerle uyuşmuyor!");
//        işlemi yerine de kullanılabilir ama
//        java(testng ya da junit) Assertte bizim yerimize liste boyut kontrolü yapar,
//        eğer listeler aynı boyuttaysa
//        karşılaştırılan listelerin aynı indexlerindeki elemanlar
//        otomatik olarak karşılaştırılır.
//
//        for (int i = 0; i < expectedList.size(); i++) {
//            Assert.assertEquals(actualList.get(i), expectedList.get(i));
//        }

        // ProductPage'den gelen ürünlerle
        // CartPage'deki ürünlerin isim ve fiyat karşılaştırması
        Assert.assertEquals(actualProductNames, expectedProductNames, "Sepetteki ürün isimleri eklenenlerle uyuşmuyor!");
        Assert.assertEquals(actualProductPrices, expectedProductPrices, "Sepetteki ürün fiyatları eklenenlerle uyuşmuyor!");

        // sepetteki ürün bilgilerinin kontrolü
        for (int i = 0; i < actualProductPrices.size(); i++) {
            int price = actualProductPrices.get(i);
            int quantity = actualProductQuantities.get(i);
            int actualTotal = actualProductTotals.get(i);

            int expectedTotal = price * quantity;
            Assert.assertEquals(actualTotal, expectedTotal, (i + 1) + ". ürünün toplam fiyatı formüle uymuyor!");
        }

    }

}
