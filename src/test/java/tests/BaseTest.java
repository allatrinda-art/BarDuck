package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

import org.testng.annotations.Listeners;
import pages.object.WebDriverContainer;
import pages.object.enums.Browser;
import pages.object.listeners.ScreenshotListener;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeMethod
    protected void setUp()    {
//                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//        driver.manage().timeouts().getScriptTimeout();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
        driver = WebDriverContainer.getDriver();
        //WebDriverContainer.getDriver().get("http://litecart.stqa.ru/en/");
        driver.get("http://litecart.stqa.ru/en/");
    }

    @AfterMethod
    protected void tearDown() {
        WebDriverContainer.closeDriver();
    }
}