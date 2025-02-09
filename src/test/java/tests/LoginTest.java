package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.object.LoginPage;

public class LoginTest extends BaseTest{

    private String userEmail = "ala@mailinator.com";
    private String userPassword = "321654987";
    private String loginSuccessMessage = "You are now logged in as %s.";
    private String userName = "Ala Trynda";

    @Test
    public void successfulLoginTest() {
        LoginPage.login(driver, userEmail, userPassword);
        String actualMessage = LoginPage.getMessage(driver);
        Assert.assertEquals(actualMessage, String.format(loginSuccessMessage, userName));
    }
}
