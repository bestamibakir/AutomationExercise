package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BasePageTest {

    @Test
    public void subscriptionInFooterTest(){
        Assert.assertTrue(homePage.isHomePageLoaded(), "Ana sayfa yüklenemedi!");
        homePage.subscribeWithEmail("random@mail.com");
        Assert.assertTrue(
                homePage.isSubscriptionSuccessVisible(),
                "Başarı mesajı görüntülenemedi!"
        );
    }
}
