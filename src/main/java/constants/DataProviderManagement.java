package constants;

import org.testng.annotations.DataProvider;

public class DataProviderManagement {
    @DataProvider(name = "checkoutData")
    public static Object[][] getCheckoutData() {
        return new Object[][]{
                {"New York", "US, St", "10001", "1234567890"},
                {UserConstants.CITY, UserConstants.ADDRESS, UserConstants.ZIP_POSTAL_CODE, UserConstants.PHONE_NUMBER}
        };
    }
}
