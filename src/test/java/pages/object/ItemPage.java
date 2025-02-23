package pages.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ItemPage extends BasePage{

    private static By addToCartButton = By.cssSelector("button[type='submit'][name='add_cart_product']");
    private static By detailsTab = By.cssSelector("a[href='#tab-details']");
    private static By detailsInfo = By.cssSelector("li.active a[href='#tab-details']");

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void addItemToCart() {
        WebElement addToCartButtonWait = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButtonWait.click();
    }

    public static void clickOnDetails() {
        WebDriverContainer.getDriver().findElement(detailsTab).click();
    }

    public static boolean detailsInfoIsDisplayed() {
        WebDriverContainer.getDriver().findElement(detailsInfo).isEnabled();
        return true;
    }
}

