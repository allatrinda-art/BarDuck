package pages.object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CatalogPage extends BasePage{

    private static By itemInTheGrid = By.cssSelector(".name");
    private static By itemList = By.cssSelector(".product");

    @Step("Select item in the grid")
    public static void selectItemInTheGrid(String itemName) {
        List<WebElement> items = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(itemList));
        for (WebElement item : items) {
            WebElement nameElement = WebDriverContainer.getDriver().findElement(itemInTheGrid);
            String productName = nameElement.getText().trim();

            if (productName.equalsIgnoreCase(itemName)) {
                wait.until(ExpectedConditions.elementToBeClickable(item)).click();
                return;
            }
        }
        throw new RuntimeException("Item with '" + itemName + "' name is not found!");
    }

    @Step("Select item in subcategory item grid")
    public static void selectItemInSubCategory(String subCategoryItemName) {
        List<WebElement> subcategoryItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(itemList));
        for (WebElement item : subcategoryItems) {
            WebElement nameElement = WebDriverContainer.getDriver().findElement(itemInTheGrid);
            String productName = nameElement.getText().trim();

            if (productName.equalsIgnoreCase(subCategoryItemName)) {
                wait.until(ExpectedConditions.elementToBeClickable(item)).click();
                return;
            }
        }
        throw new RuntimeException("Item with '" + subCategoryItemName + "' name is not found!");
    }
}