package pages.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ItemPage extends BasePage{

    private static By addToCartButton = By.cssSelector("button[type='submit'][name='add_cart_product']");
    private static By detailsTab = By.cssSelector("a[href='#tab-details']");
    private static By detailsInfo = By.cssSelector("li.active a[href='#tab-details']");

    @Step("Add item to cart")
    public static void addItemToCart() {
        WebDriver driver = WebDriverContainer.getDriver();
        updateWait();
        WebElement addToCartButtonWait = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButtonWait.click();
    }

    @Step("Click on details tab")
    public static void clickOnDetails() {
        WebDriverContainer.getDriver().findElement(detailsTab).click();
    }

    @Step("Check details info is displayed")
    public static void detailsInfoIsDisplayed() {
        Assert.assertTrue(WebDriverContainer.getDriver().findElement(detailsInfo).isEnabled());
    }
}