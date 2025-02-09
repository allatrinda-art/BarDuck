package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.object.CatalogPage;
import pages.object.HomePage;
import pages.object.ItemPage;

public class ItemsTest extends BaseTest{

    @Test
    public void userCanAddItemToCartTest () {
        ItemPage itemPage = new ItemPage(driver);
        HomePage homePage = new HomePage(driver);

        HomePage.categoryMenuClick(driver);
        CatalogPage.selectItemInTheGrid(driver);
        itemPage.addItemToCart();
        String getCartAmount = homePage.waitForAndGetCartQuantity();
        Assert.assertEquals(getCartAmount, "1", "No items in the cart");
    }

    @Test
    public void itemDetailsIsDisplayedTest () {
        HomePage.selectSubCategory(driver);
        CatalogPage.selectItemInSubCategory(driver);
        ItemPage.clickOnDetails(driver);
        Assert.assertTrue(ItemPage.detailsInfoIsDisplayed(driver));
    }
}
