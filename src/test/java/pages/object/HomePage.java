package pages.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage extends BasePage{

    private static By categoryMenu = By.cssSelector("#site-menu .category-1>a");
    private static final String CART_QUANTITY_CSS = "#cart span.quantity"; // Для JS-ожидания
    private static By cartQuantity = By.cssSelector("#cart span.quantity");
    private static By cart = By.cssSelector(".content>strong");
    private static By menuSubCategory = By.cssSelector("#site-menu .category-2 a");
    private static By changeButton = By.cssSelector(".fancybox-region");
    private static By currency = By.cssSelector("select[name='currency_code']");
    private static By saveButton = By.cssSelector("button[name='save']");
    private static By savedCurrency = By.cssSelector("div.currency span");

    @Step("Click on category menu")
    public static void categoryMenuClick() {
        WebDriverContainer.getDriver().findElement(categoryMenu).click();
    }

    @Step("Check cart quantity is updated")
    public static void waitForAndGetCartQuantity(String itemAmount) {
        // Получаем текущее количество товаров в корзине
        String currentQuantity = WebDriverContainer.getDriver().findElement(cartQuantity).getText().trim();
        // Ждем, пока количество товаров в корзине изменится
        wait.until(d -> {
            String newQuantity = ((JavascriptExecutor) d)
                    .executeScript("return document.querySelector(arguments[0]).textContent", CART_QUANTITY_CSS)
                    .toString().trim();
            // Убедимся, что число больше 0 и не равно предыдущему
            return !newQuantity.equals(currentQuantity) && newQuantity.matches("[1-9][0-9]*");
        });
        // Возвращаем новое количество товаров
        Assert.assertEquals(WebDriverContainer.getDriver().findElement(cartQuantity).getText().trim(), itemAmount,
                "No items in the cart");
    }

    @Step("Click on cart icon")
    public static void cartClick() {
        WebDriverContainer.getDriver().findElement(cart).click();
    }

    @Step("Select subcategory")
    public static void selectSubCategory() {
        // Создаем объект Actions
        Actions actions = new Actions(WebDriverContainer.getDriver());
        // Наводим курсор на элемент
        actions.moveToElement(WebDriverContainer.getDriver().findElement(categoryMenu))
                .click(WebDriverContainer.getDriver().findElement(menuSubCategory)).perform();
    }

    @Step("Click on change button in the header")
    public static void clickOnChangeButton() {
        WebDriverContainer.getDriver().findElement(changeButton).click();
    }

    @Step("Open the list of the currency and select one")
    public static void selectCurrency() {
        Select dropdown = new Select(WebDriverContainer.getDriver().findElement(currency));
        dropdown.selectByVisibleText("Euros");
    }

    @Step("Save currency")
    public static void saveCurrency() {
        WebDriverContainer.getDriver().findElement(saveButton).click();
    }

    @Step("Check saved currency")
    public static void checkSavedCurrency(String updatedCurrency) {
        Assert.assertEquals(WebDriverContainer.getDriver().findElement(savedCurrency).getText(), updatedCurrency,
                "Currency is not updated");
    }
}