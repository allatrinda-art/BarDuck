import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.BaseTest;

public class TestClass extends BaseTest {

    @Test
    public void herokuAppTest() {
        driver.get("https://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("a")));
        String actualText = driver.findElement(By.cssSelector("a[href='/drag_and_drop']")).getText();
        elements.get(9).click();
        Assert.assertEquals(actualText, "Drag and Drop", "No such text");
    }
}
