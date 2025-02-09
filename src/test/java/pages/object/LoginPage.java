package pages.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private static By emailInput = By.name("email");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.name("login");
    private static By welcomeText = By.cssSelector("#notices>.notice");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static void login(WebDriver driver, String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public static String getMessage(WebDriver driver) {
        return driver.findElement(welcomeText).getText();
    }
}
