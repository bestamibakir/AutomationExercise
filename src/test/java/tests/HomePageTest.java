package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class HomePageTest extends BasePageTest {

    @Test
    public void subscriptionInFooterTest(){
        Assert.assertTrue(homePage.isHomePageLoaded(), "Ana sayfa yüklenemedi!");
        Assert.assertTrue(homePage.isFooterVisible(), "Subscription yazısı görünmedi");
        homePage.subscribeWithEmail(ConfigReader.get("random.email"));
        Assert.assertTrue(
                homePage.isSubscriptionSuccessVisible(),
                "Başarı mesajı görüntülenemedi!"
        );
    }
}
