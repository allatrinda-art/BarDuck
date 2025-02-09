package pages.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage{

    private static By removeButton = By.cssSelector("button[name='remove_cart_item']");
    private static By noItemsText = By.cssSelector("#checkout-cart-wrapper em");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public static void removeButtonClick(WebDriver driver) {
        driver.findElement(removeButton).click();
    }

    public String removalMessage() {
        return driver.findElement(noItemsText).getText();
    }
}
