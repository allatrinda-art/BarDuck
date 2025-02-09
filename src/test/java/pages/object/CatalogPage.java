package pages.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends BasePage{

    private static By purpleDuck = By.cssSelector("img[class='image'][alt='Purple Duck']");
    private static By itemInCatalog = By.cssSelector("a[title='Yellow Duck']");

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public static void selectItemInTheGrid(WebDriver driver) {
        driver.findElement(purpleDuck).click();
    }

    public static void selectItemInSubCategory(WebDriver driver) {
        driver.findElement(itemInCatalog).click();
    }

}
