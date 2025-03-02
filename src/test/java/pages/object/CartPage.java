package pages.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CartPage extends BasePage{

    private static By removeButton = By.cssSelector("button[name='remove_cart_item']");
    private static By noItemsText = By.cssSelector("#checkout-cart-wrapper em");

    @Step("Click on remove button")
    public static void removeButtonClick() {
        WebDriverContainer.getDriver().findElement(removeButton).click();
    }

    @Step("Check the removal message")
    public static void removalMessage(String cartMessage) {
        Assert.assertEquals(WebDriverContainer.getDriver().findElement(noItemsText).getText(), cartMessage,
                "Cart is not empty");
    }
}