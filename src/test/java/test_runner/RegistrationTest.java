package test_runner;

import constants.UserConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test_base.WebTestBase;
import web_ui.HomePage;
import web_ui.RegisterPage;

public class RegistrationTest extends WebTestBase {
    HomePage homePage;
    RegisterPage registerPage;



    public void verifyRegistrationSuccess() {
        homePage = new HomePage(webDriver);
        registerPage = new RegisterPage(webDriver);
        homePage.clickRegisterBtn();
        registerPage.selectMaleBtn();
        registerPage.sentFirstName(UserConstants.FIRST_NAME);
        registerPage.sentLastName(UserConstants.LAST_NAME);
        registerPage.selectDayOption();
        registerPage.selectMonthOption();
        registerPage.selectYearOption();
        registerPage.sentEmail();
        registerPage.scrollToPasswordField(webDriver);
        registerPage.sentCompanyName();
        registerPage.sentPassword(UserConstants.PASSWORD);
        registerPage.sentConfirmationPassword(UserConstants.PASSWORD);
        registerPage.clickRegisterBtn();
        Assert.assertTrue(registerPage.getRegistrationMsg().equalsIgnoreCase("your registration completed"));
        registerPage.clickContinueBtn();
    }
}
