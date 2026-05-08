package tests;

import locators.CartPageLocators;
import locators.CommonLocators;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import utils.ConfigReader;

public class CartPageTest extends BasePageTest {

    private CartPage cartPage;

    @BeforeMethod
    public void initPages(){
        cartPage = new CartPage(driver);
    }

    @Test
    public void cartPageSubscriptionInFooterTest(){
        Assert.assertTrue(homePage.isHomePageLoaded(), "Ana sayfa yüklenemedi");
        homePage.click(CommonLocators.cartButtonLocator);

        Assert.assertTrue(cartPage.isCartPageLoaded(), "Sepet sayfası yüklenemedi");
        homePage.subscribeWithEmail(ConfigReader.get("random.email"));

        Assert.assertTrue(homePage.isSubscriptionSuccessVisible(), "Başarı mesajı görüntülenemedi!"
        );
    }

}
