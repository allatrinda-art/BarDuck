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
import pages.object.enums.Browser;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    protected void setUp()    {
        Browser browser = Browser.valueOf(System.getProperty("browser", "chrome").toLowerCase());
        driver = switch(browser) {
            case chrome -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--ignore-certificate-errors");
                yield new ChromeDriver();
            }
            case firefox -> new FirefoxDriver();
            case edge -> new EdgeDriver();
            case safari -> new SafariDriver();
        };
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().getScriptTimeout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://litecart.stqa.ru/en/");
    }

    @AfterMethod
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
