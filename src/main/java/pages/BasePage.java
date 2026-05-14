package pages;

import base.WaitHelper;
import org.openqa.selenium.*;
import utils.ConfigReader;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WaitHelper helper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.helper = new WaitHelper(driver, Duration.ofSeconds(Integer.parseInt(ConfigReader.get("timeout.default"))));
    }

    public void navigateTo(String url){
        try{
            if (driver != null){
                driver.get(url);
            }
        } catch (Exception e) {
            System.out.println("Url açılırken hata " + e.getMessage());
        }
    }

    public boolean isElementVisible(By by) {
        try {
            helper.visible(by);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isElementExist(By by){
        return isElementExist(by, Integer.parseInt(ConfigReader.get("timeout.default")));
    }

    public boolean isElementExist(By by, int timeInSec){
        try{
            helper.presence(by,timeInSec);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public List<WebElement> getAllVisibleElements(By by) {
        try {
            // Elemanları bekleyip getirir
            return helper.allVisible(by);
        } catch (TimeoutException e) {
            System.out.println("Elementler zamanında görünür olmadı: " + e.getMessage());
            // Hata verirse çökmek yerine boş liste döner
            return new ArrayList<>();
        }
    }

    public boolean waitUntilUrlContains(String text) {
        return helper.urlContains(text);
    }

    public boolean waitUntilUrlContains(String text, int timeInSec) {
        return helper.urlContains(text, timeInSec);
    }

    public boolean click(By by){
        WebElement element = null;

        try{
            // element tıklanabilir olana kadar bekler
            element = helper.clickable(by);
            element.click();
            return true;
        } catch (TimeoutException e) {
            System.out.println("Element zamanında tıklanabilir olmadı " + e.getMessage());
            return false;
        } catch (ElementNotInteractableException | NoSuchElementException e) {
            try {
                // Eğer normal click ad/overlay yüzünden engellenirse JS ile tıklamayı deneriz
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                return true; // JS click başarılı olursa true döneriz
            } catch (Exception jsException) {
                System.out.println("JS ile de tıklanamadı " + jsException.getMessage());
                return false;
            }
        }
    }

    public boolean sendKeys(By by, String text){
        try{
            // element görünür olana kadar bekle
            WebElement element = helper.visible(by);

            if(!element.isEnabled()){
                System.out.println("Element aktif değil " + by);
                return false;
            }

            element.sendKeys(text);
            return true;

        } catch (TimeoutException e) {
            System.out.println("Element görünür değil " + e.getMessage());
            return false;
        } catch (InvalidElementStateException | NoSuchElementException e) {
            System.out.println("Text yazılamadı " + e.getMessage());
            return false;
        }
    }

    public String getText(By by) {
        try {
            WebElement element = helper.visible(by);
            return element.getText();
        } catch (TimeoutException e) {
            System.out.println("Element görünür değil: " + e.getMessage());
            return null;
        }
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}
