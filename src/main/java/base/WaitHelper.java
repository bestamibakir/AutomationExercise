package base;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    private final WebDriverWait wait;
    private final WebDriver driver;

    public WaitHelper(WebDriver driver, Duration timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
    }

    public WebElement visible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement presence(By locator, int timeInSec){
        // custom bekleme süresi
        WebDriverWait customWait = new WebDriverWait(this.driver, Duration.ofSeconds(timeInSec));
        return customWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement clickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean urlContains(String text) {
        try {
            return wait.until(ExpectedConditions.urlContains(text));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean urlContains(String text, int timeInSec) {
        try {
            WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
            return customWait.until(ExpectedConditions.urlContains(text));
        } catch (TimeoutException e) {
            return false;
        }
    }
}
