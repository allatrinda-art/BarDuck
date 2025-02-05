package by.AllaTrindaInc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
    public void setUp()    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().getScriptTimeout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void herokuAppTest() {
        driver.get("https://the-internet.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("a")));
        String actualText = driver.findElement(By.cssSelector("a[href='/drag_and_drop']")).getText();
        elements.get(9).click();
        Assert.assertEquals(actualText, "Drag and Drop", "No such text");
    }

    @Test
    public void successfulLoginTest() {
        driver.get("http://litecart.stqa.ru/en/");
        WebElement email = driver.findElement(By.cssSelector("[name='email']"));
        WebElement password = driver.findElement(By.cssSelector("[name='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(), 'Login')]"));

        email.sendKeys("ala@mailinator.com");
        password.sendKeys("321654987");
        loginButton.click();
        WebElement welcomeText = driver.findElement(By.xpath("//*[@class='notice success']")); //welcome page
        Assert.assertEquals(welcomeText.getText(), "You are now logged in as Ala Trynda.");
//        Actions actions = new Actions(driver);
//        actions.scrollToElement(duck).click(duck).perform(); //скроллит до этого элемента
    }

    @Test
    public void userCanAddItemToCartTest () {
        driver.get("http://litecart.stqa.ru/en/");
        WebElement categoryMenu = driver.findElement(By.xpath("//li[@class='category-1']/preceding-sibling::li"));
        categoryMenu.click();
        WebElement purpleDuck = driver.findElement(By.cssSelector("img[class='image'][alt='Purple Duck']"));
        purpleDuck.click();
        WebElement addToCardButton = driver.findElement(By.cssSelector("button[type='submit'][name='add_cart_product']"));
        addToCardButton.click();
        WebElement amountOfItemsInCart = (new WebDriverWait(driver, Duration.ofSeconds(5)))
                .until(new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver input) {
                        return input.findElement(By.cssSelector("span[class='quantity']"));
                    }
                });
        Assert.assertEquals(amountOfItemsInCart.getText(), "1", "No items in the cart");



    }

    @Test
    public void itemCanRemovedInCartTest () {

    }

    @Test
    public void itemDetailsIsDisplayedTest () {

    }

    @Test
    public void currencyCanBeChangedToEurTest () {

    }

    @AfterMethod
    public void tearDown() {
     if (driver != null) {
        driver.quit();
    }
    }
}
