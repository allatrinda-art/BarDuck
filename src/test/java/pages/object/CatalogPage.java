package pages.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CatalogPage extends BasePage{

    private static By itemInTheGrid = By.cssSelector(".name");
    private static By itemList = By.cssSelector(".product");

    @Step("Select item in the grid")
    public static void selectItemInTheGrid(String itemName) {
        WebDriver driver = WebDriverContainer.getDriver();
        List<WebElement> items = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(itemList));

        for (int i = 0; i < 3; i++) { // 3 попытки, если элемент не найден
            try {
                for (WebElement item : items) {
                    WebElement nameElement = item.findElement(itemInTheGrid);
                    String productName = nameElement.getText().trim();
                    if (productName.equalsIgnoreCase(itemName)) {
                        wait.until(ExpectedConditions.elementToBeClickable(nameElement)).click();
                        return;
                    }
                }
                break; // Выход из цикла, если нашли товар
            } catch (StaleElementReferenceException e) {
                items = driver.findElements(itemList);
            }
        }
        throw new RuntimeException("Item '" + itemName + "' not found!");
    }

    @Step("Select item in subcategory item grid")
    public static void selectItemInSubCategory(String subCategoryItemName) {
        WebDriver driver = WebDriverContainer.getDriver();

        // Увеличенное время ожидания загрузки элементов (если нужно)
        List<WebElement> subcategoryItems = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(itemList));

        for (int attempt = 0; attempt < 3; attempt++) { // Три попытки в случае ошибки
            try {
                for (WebElement item : subcategoryItems) {
                    WebElement nameElement = item.findElement(itemInTheGrid);

                    if (nameElement.getText().trim().equalsIgnoreCase(subCategoryItemName)) {
                        wait.until(ExpectedConditions.elementToBeClickable(nameElement)).click();
                        return;
                    }
                }
                break; // Если нашли товар, выход из цикла
            } catch (StaleElementReferenceException e) {
                subcategoryItems = driver.findElements(itemList); // Обновляем список
            } catch (Exception e) {
            }
        }
        throw new RuntimeException("Item '" + subCategoryItemName + "' not found!");
    }
}