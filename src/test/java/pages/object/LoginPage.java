package pages.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage{

    private static By emailInput = By.name("email");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.name("login");
    private static By welcomeText = By.cssSelector("#notices>.notice");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("enter correct data and submit")
    public static void login(String email, String password) {
        WebDriverContainer.getDriver().findElement(emailInput).sendKeys(email);
        WebDriverContainer.getDriver().findElement(passwordInput).sendKeys(password);
        WebDriverContainer.getDriver().findElement(loginButton).click();
    }

    @Step("Validate login result message")
    public static void validateMessage(String actualMessage) {
        Assert.assertEquals(WebDriverContainer.getDriver().findElement(welcomeText).getText(), actualMessage);
    }
}
