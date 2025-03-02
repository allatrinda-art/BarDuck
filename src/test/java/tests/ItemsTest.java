package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.object.CatalogPage;
import pages.object.HomePage;
import pages.object.ItemPage;

public class ItemsTest extends BaseTest{

    private final String itemName = "Purple Duck";
    private final String itemAmount = "1";
    private final String subCategoryItemName = "Yellow Duck";

    @Epic("Catalog")
    @Feature("Items are delivered to the cart")
    @Description("Item is displayed in the cart after User has added it to the cart")
    @Test(description = "User can add an item to the cart")
    public void userCanAddItemToCartTest () {
        HomePage.categoryMenuClick();
        CatalogPage.selectItemInTheGrid(itemName);
        ItemPage.addItemToCart();
        HomePage.waitForAndGetCartQuantity(itemAmount);
    }

    @Epic("Catalog")
    @Feature("Item info")
    @Description("User can look through all item content")
    @Test(description = "Item details are displayed on item page")
    public void itemDetailsAreDisplayedTest () {
        HomePage.selectSubCategory();
        CatalogPage.selectItemInSubCategory(subCategoryItemName);
        ItemPage.clickOnDetails();
        ItemPage.detailsInfoIsDisplayed();
    }
}