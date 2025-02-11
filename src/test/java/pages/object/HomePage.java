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

    public static void categoryMenuClick(WebDriver driver) {
       driver.findElement(categoryMenu).click();
    }

    public String waitForAndGetCartQuantity() {
        // Получаем текущее количество товаров в корзине
        String currentQuantity = driver.findElement(cartQuantity).getText().trim();
        // Ждем, пока количество товаров в корзине изменится
        wait.until(d -> {
            String newQuantity = ((JavascriptExecutor) d)
                    .executeScript("return document.querySelector(arguments[0]).textContent", CART_QUANTITY_CSS)
                    .toString().trim();
            // Убедимся, что число больше 0 и не равно предыдущему
            return !newQuantity.equals(currentQuantity) && newQuantity.matches("[1-9][0-9]*");
        });
        // Возвращаем новое количество товаров
        return driver.findElement(cartQuantity).getText().trim();
    }

    public static void cartClick(WebDriver driver) {
        driver.findElement(cart).click();
    }

    public static void selectSubCategory(WebDriver driver) {
        // Создаем объект Actions
        Actions actions = new Actions(driver);
        // Наводим курсор на элемент
        actions.moveToElement(driver.findElement(categoryMenu)).click(driver.findElement(menuSubCategory)).perform();
    }

    public static void clickOnChangeButton(WebDriver driver) {
        driver.findElement(changeButton).click();
    }

    public static void selectCurrency(WebDriver driver) {
        Select dropdown = new Select(driver.findElement(currency));
        dropdown.selectByVisibleText("Euros");
    }

    public static void saveCurrency(WebDriver driver) {
        driver.findElement(saveButton).click();
    }

    public static String checkSavedCurrency(WebDriver driver) {
        return driver.findElement(savedCurrency).getText();
    }
}
