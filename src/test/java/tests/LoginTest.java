package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.object.LoginPage;
import pages.object.helpers.Credentials;

public class LoginTest extends BaseTest{

    private String userEmail = Credentials.getProperty("email");
    private String userPassword = Credentials.getProperty("password");
    private String userName = Credentials.getProperty("name");
    private String loginSuccessMessage = "You are now logged in as %s.";

    @Test
    public void successfulLoginTest() {
        LoginPage.login(driver, userEmail, userPassword);
        String actualMessage = LoginPage.getMessage(driver);
        Assert.assertEquals(actualMessage, String.format(loginSuccessMessage, userName));
    }
}
