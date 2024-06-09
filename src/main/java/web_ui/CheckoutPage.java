package web_ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.wait.ExplicitDriverWait;

import static utils.actions.WebActions.scrollIntoView;

public class CheckoutPage extends WebPageBase {
    public CheckoutPage(WebDriver webDriver) {
        super(webDriver);
    }

    private final By CountryDDL = By.id("BillingNewAddress_CountryId");
    private final By CityTB = By.id("BillingNewAddress_City");
    private final By AdressTB = By.id("BillingNewAddress_Address1");
    private final By ZipCodeTB = By.id("BillingNewAddress_ZipPostalCode");
    private final By PhoneTB = By.id("BillingNewAddress_PhoneNumber");
    private final By ContinueFirstBtn = By.xpath("//button[text()='Continue']");
    private final By ContinueSecondBtn = By.xpath("//button[contains(@class, 'shipping-method-next-step-button') and text()='Continue']");
    private final By ContinueThirdBtn = By.xpath("//button[contains(@class, 'payment-method-next-step-button') and text()='Continue']");
    private final By ContinueFourthBtn = By.xpath("//button[contains(@class, 'payment-info-next-step-button') and text()='Continue']");

    private final By OrderSuccessMsg = By.xpath("//strong[text()='Your order has been successfully processed!']");

    private final By ConfirmBtn = By.xpath("//button[text()='Confirm']");

    public void selectCountry() {
        new ExplicitDriverWait(webDriver).waitUntilElementAppear(10, CountryDDL);
        WebElement country = webDriver.findElement(CountryDDL);
        Select egypt = new Select(country);
        egypt.selectByValue("123");
    }

    public void addCity(String city) {
        webDriver.findElement(CityTB).sendKeys(city);
    }

    public void addAdress(String address1) {
        WebElement adress = webDriver.findElement(AdressTB);
        scrollIntoView(webDriver, adress);
        adress.sendKeys(address1);
    }

    public void addZipCode(String zipCode) {
        webDriver.findElement(ZipCodeTB).sendKeys(zipCode);
    }

    public void addPhoneNum(String phoneNum) {
        webDriver.findElement(PhoneTB).sendKeys(phoneNum);
    }

    public void clickFirstContinueBtn() {

        webDriver.findElement(ContinueFirstBtn).click();
    }

    public void clickConfirmBtn() {
        new ExplicitDriverWait(webDriver).waitUntilElementAppear(10, ConfirmBtn);

        WebElement confirm = webDriver.findElement(ConfirmBtn);
        scrollIntoView(webDriver, confirm);
        confirm.click();
    }

    public void clickSecondContinueBtn() {
        new ExplicitDriverWait(webDriver).waitUntilElementAppear(10,ContinueSecondBtn);
        webDriver.findElement(ContinueSecondBtn).click();
    }

    public void clickThirdContinueBtn() {
        new ExplicitDriverWait(webDriver).waitUntilElementAppear(10,ContinueThirdBtn);

        webDriver.findElement(ContinueThirdBtn).click();
    }

    public void clickFourthContinueBtn() {
        new ExplicitDriverWait(webDriver).waitUntilElementAppear(10,ContinueFourthBtn);

        webDriver.findElement(ContinueFourthBtn).click();
    }

    public String getSuccessMsg() {
        return webDriver.findElement(OrderSuccessMsg).getText();
    }
}
