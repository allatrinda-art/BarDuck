package pages.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static void categoryMenuClick() {
        WebDriverContainer.getDriver().findElement(categoryMenu).click();
    }

    public String waitForAndGetCartQuantity() {
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
        return WebDriverContainer.getDriver().findElement(cartQuantity).getText().trim();
    }

    public static void cartClick() {
        WebDriverContainer.getDriver().findElement(cart).click();
    }

    public static void selectSubCategory() {
        // Создаем объект Actions
        Actions actions = new Actions(WebDriverContainer.getDriver());
        // Наводим курсор на элемент
        actions.moveToElement(WebDriverContainer.getDriver().findElement(categoryMenu))
                .click(WebDriverContainer.getDriver().findElement(menuSubCategory)).perform();
    }

    public static void clickOnChangeButton() {
        WebDriverContainer.getDriver().findElement(changeButton).click();
    }

    public static void selectCurrency() {
        Select dropdown = new Select(WebDriverContainer.getDriver().findElement(currency));
        dropdown.selectByVisibleText("Euros");
    }

    public static void saveCurrency() {
        WebDriverContainer.getDriver().findElement(saveButton).click();
    }

    public static String checkSavedCurrency() {
        return WebDriverContainer.getDriver().findElement(savedCurrency).getText();
    }
}
