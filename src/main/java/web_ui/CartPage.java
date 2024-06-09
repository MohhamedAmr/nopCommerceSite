package web_ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static utils.actions.WebActions.scrollIntoView;

public class CartPage extends WebPageBase {

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }
    private final By CheckOutBtn = By.id("checkout");
    private final By TermsCheckBox = By.id("termsofservice");
    public void acceptTerms(){
        WebElement webElement = webDriver.findElement(TermsCheckBox);
        scrollIntoView(webDriver, webElement);
        webElement.click();
    }
    public void clickCheckOut(){
       webDriver.findElement(CheckOutBtn).click();
    }
}
