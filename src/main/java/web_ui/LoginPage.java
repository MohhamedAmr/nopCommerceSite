package web_ui;

import constants.UserConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends WebPageBase{
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    private final By emailTB = By.id("Email");
    private final By passwordTb = By.id("Password");
    private final By continueBtn = By.xpath("//button[text()='Log in']");

    public void addEmail(String email){
        webDriver.findElement(emailTB).sendKeys(email);

    }
    public void addPassword(String password){
        webDriver.findElement(passwordTb).sendKeys(password);
    }
    public void clickLogin(){
        webDriver.findElement(continueBtn).click();
    }
}
