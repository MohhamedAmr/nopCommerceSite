package test_runner;

import constants.DataProviderManagement;
import org.testng.Assert;
import org.testng.annotations.Test;
import test_base.WebTestBase;
import web_ui.CartPage;
import web_ui.CheckoutPage;
import web_ui.HomePage;
import web_ui.ProductPage;

public class OrderCreationTest extends WebTestBase {
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Test(dataProvider = "checkoutData", dataProviderClass = DataProviderManagement.class)
    public void createOrder(String city, String adress, String zipCode ,String phoneNum) {
        new RegistrationTest().verifyRegistrationSuccess();
        homePage = new HomePage(webDriver);
        productPage = new ProductPage(webDriver);
        cartPage = new CartPage(webDriver);
        checkoutPage = new CheckoutPage(webDriver);
        homePage.clickAddToCart();
        productPage.selectRam();
        productPage.clickHDD_FirstSelection();
        productPage.clickAddToCart();
        productPage.clickShoppingCart();
        cartPage.acceptTerms();
        cartPage.clickCheckOut();
        checkoutPage.selectCountry();
        checkoutPage.addCity(city);
        checkoutPage.addAdress(adress);
        checkoutPage.addZipCode(zipCode);
        checkoutPage.addPhoneNum(phoneNum);
        checkoutPage.clickFirstContinueBtn();
        checkoutPage.clickSecondContinueBtn();
        checkoutPage.clickThirdContinueBtn();
        checkoutPage.clickFourthContinueBtn();
        checkoutPage.clickConfirmBtn();
        Assert.assertEquals(checkoutPage.getSuccessMsg(),"Your order has been successfully processed!");
    }
}
