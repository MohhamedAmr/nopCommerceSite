package web_ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static utils.actions.WebActions.scrollIntoView;

public class ProductPage extends WebPageBase {

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    private final By addToCartBtn = By.id("add-to-cart-button-1");
    private final By ramDropdownList = By.id("product_attribute_2");

    private final By HDD_RB_FirstSelection = By.id("product_attribute_3_6");

    private final By ShoppingCartBtn = By.className("ico-cart");
    //cart-label

    public void clickAddToCart() {
        WebElement webElement = webDriver.findElement(addToCartBtn);
        scrollIntoView(webDriver, webElement);
        webElement.click();
    }
    public void selectRam(){
        WebElement firstSelection = webDriver.findElement(ramDropdownList);
        Select option = new Select(firstSelection);
        option.selectByValue("3");
    }
    public void clickHDD_FirstSelection(){
        webDriver.findElement(HDD_RB_FirstSelection).click();
    }
    public void clickShoppingCart(){
        WebElement webElement = webDriver.findElement(ShoppingCartBtn);
        scrollIntoView(webDriver, webElement);
        webElement.click();
    }

}
