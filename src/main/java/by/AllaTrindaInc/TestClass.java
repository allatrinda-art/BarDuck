package by.AllaTrindaInc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestClass {
    WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().getScriptTimeout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void firstTest() {
        driver.get("https://the-internet.herokuapp.com/");
//        WebElement searchInput = driver.findElement(By.id("456"));
//        searchInput.sendKeys("hello");
//        WebElement iAmLuchy = driver.findElement(By.linkText(""));
 //       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
//        WebElement iAmLuchy = wait.until(ExpectedConditions.
//      List<WebElement> elements = driver.findElements(By.tagName("a"));
        // Используем WebDriverWait для ожидания загрузки ссылок
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("a")));
        String actualText = driver.findElement(By.cssSelector("a[href='/drag_and_drop']")).getText();
        elements.get(9).click();
        Assert.assertEquals(actualText, "Drag and Drop", "No such text");
    }

    @AfterMethod
    public void tearDown() {
     if (driver != null) {
        driver.quit();
    }
    }
}
