package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.object.CartPage;
import pages.object.CatalogPage;
import pages.object.HomePage;
import pages.object.ItemPage;

public class CartTest extends BaseTest{

    private String cartMessage = "There are no items in your cart.";

    @Test
    public void itemCanBeRemovedInCartTest () {
        ItemPage itemPage = new ItemPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        HomePage.categoryMenuClick(driver);
        CatalogPage.selectItemInTheGrid(driver);
        itemPage.addItemToCart();
        homePage.waitForAndGetCartQuantity();
        HomePage.cartClick(driver);
        CartPage.removeButtonClick(driver);
        String noItemsText = cartPage.removalMessage();
        Assert.assertEquals(noItemsText, cartMessage, "Cart is not empty");
    }
}
