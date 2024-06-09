package utils.wait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import web_ui.WebPageBase;

import java.time.Duration;

public class FluentDriverWait extends WebPageBase {
    public FluentDriverWait(WebDriver webDriver) {
        super(webDriver);
    }

    public static void fluentDisplayingWait(long timeOutSeconds, long pollingEverySeconds , By elementId) {
        new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(timeOutSeconds))
                .pollingEvery(Duration.ofSeconds(pollingEverySeconds))
                .ignoring(NoSuchElementException.class)
                .withMessage("time out is gone")
                .until(driver -> {
                    WebElement element = driver.findElement(elementId);
                    if (element.isDisplayed()) {
                        return element;
                    }
                    return null;
                });
    }
    public static void fluentDisappearingWait(long timeOutSeconds, long pollingEverySeconds , By elementId) {
        new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(timeOutSeconds))
                .pollingEvery(Duration.ofSeconds(pollingEverySeconds))
                .ignoring(NoSuchElementException.class)
                .withMessage("time out is gone")
                .until(ExpectedConditions.invisibilityOfElementLocated(elementId));
    }

}
