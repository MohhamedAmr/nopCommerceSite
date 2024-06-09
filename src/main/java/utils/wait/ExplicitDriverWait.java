package utils.wait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web_ui.WebPageBase;

import java.time.Duration;

public class ExplicitDriverWait extends WebPageBase {


    public ExplicitDriverWait(WebDriver webDriver) {
        super(webDriver);
    }

    public void waitUntilElementAppear(long timeInSeconds, By elementId) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementId));

    }
    public void waitUntilElementDisappears(By elementLocator, long timeoutInSeconds , long pollingEverySecond) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeoutInSeconds );
        wait.pollingEvery(Duration.ofSeconds(pollingEverySecond)).until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));

    }
}
