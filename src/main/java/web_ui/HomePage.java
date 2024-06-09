package web_ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.actions.WebActions.scrollIntoView;

public class HomePage extends WebPageBase {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    private final By registerBtn = By.className("ico-register");
    private final By addToCartBtn = By.xpath("//button[text()='Add to cart']");

    private final By loginBtn = By.className("ico-login");

    public void clickRegisterBtn() {
        webDriver.findElement(registerBtn).click();
    }

    public void clickAddToCart() {
        WebElement webElement = webDriver.findElement(addToCartBtn);
        scrollIntoView(webDriver, webElement);

        webElement.click();
    }
    public void clickLogin(){
        webDriver.findElement(loginBtn).click();
    }
}
