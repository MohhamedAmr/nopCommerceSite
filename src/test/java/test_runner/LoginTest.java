package test_runner;

import constants.UserConstants;
import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test_base.WebTestBase;
import web_ui.HomePage;
import web_ui.LoginPage;

public class LoginTest extends WebTestBase {
    LoginPage loginPage;
    HomePage homePage;


    public void loginCycle() {
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        homePage.clickLogin();
        loginPage.addEmail(UserConstants.EMAIL);
        loginPage.addPassword(UserConstants.PASSWORD);
        loginPage.clickLogin();


    }
}
