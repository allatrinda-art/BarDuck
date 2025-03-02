package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.object.LoginPage;
import pages.object.helpers.Credentials;

public class LoginTest extends BaseTest{

    private final String userEmail = Credentials.getProperty("email");
    private final String userPassword = Credentials.getProperty("password");
    private final String userName = Credentials.getProperty("name");
    private final String loginSuccessMessage = "You are now logged in as %s.";
    private final String emptyPassword = "";
    private final String incorrectPassword = "sdgesbwen";
    private final String loginErrorMessage = "Wrong password or the account is disabled, or does not exist";

    @Epic("Authentication")
    @Feature("User can login with credentials")
    @Description("User can login with valid credentials successfully")
    @Test(description = "Login with correct credentials")
    public void successfulLoginTest() {
        LoginPage.login(userEmail, userPassword);
        String formattedMessage = String.format(loginSuccessMessage, userName);
        LoginPage.validateMessage(formattedMessage);
    }

    @Epic("Authentication")
    @Feature("User can login with credentials")
    @Description("User gets error message with incorrect password")
    @Test(description = "Wrong password")
    public void incorrectLoginTest() {
        LoginPage.login(userEmail, incorrectPassword);
        LoginPage.validateMessage(loginErrorMessage);
    }

//    @Story("SignUp functional")
}