package test_base;

import com.beust.jcommander.Parameter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.*;
import constants.SiteConstants;

import java.util.concurrent.TimeUnit;

public class WebTestBase {
    public static WebDriver webDriver;

    @BeforeMethod
    @Parameter(names = "browserName")
    public void startDriver(@Optional("chrome") String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        }

        webDriver.manage().window().maximize();
        webDriver.navigate().to(SiteConstants.baseUrl);
        Reporter.log("We used Google Chrome Ver 80 for this test");
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void endDriver() {
        webDriver.manage().deleteAllCookies();
        webDriver.quit();



    }
}





