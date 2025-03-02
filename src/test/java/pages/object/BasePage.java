package pages.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    //protected WebDriver driver;
    protected static WebDriverWait wait;

    // Конструктор, принимающий WebDriver
//    public BasePage(WebDriver driver) {
    public static void updateWait() {
       // this.driver = driver;
        WebDriver driver = WebDriverContainer.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}