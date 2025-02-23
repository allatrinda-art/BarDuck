package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.object.CatalogPage;
import pages.object.HomePage;
import pages.object.ItemPage;

import static pages.object.WebDriverContainer.getDriver;

public class ItemsTest extends BaseTest{

    @Test
    public void userCanAddItemToCartTest () {
        ItemPage itemPage = new ItemPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        HomePage.categoryMenuClick();
        CatalogPage.selectItemInTheGrid();
        itemPage.addItemToCart();
        String getCartAmount = homePage.waitForAndGetCartQuantity();
        Assert.assertEquals(getCartAmount, "1", "No items in the cart");
    }

    @Test
    public void itemDetailsIsDisplayedTest () {
        HomePage.selectSubCategory();
        CatalogPage.selectItemInSubCategory();
        ItemPage.clickOnDetails();
        Assert.assertTrue(ItemPage.detailsInfoIsDisplayed());
    }
}
