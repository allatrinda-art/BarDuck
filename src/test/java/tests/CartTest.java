package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.object.CartPage;
import pages.object.CatalogPage;
import pages.object.HomePage;
import pages.object.ItemPage;

import static pages.object.WebDriverContainer.getDriver;

public class CartTest extends BaseTest{

    private String cartMessage = "There are no items in your cart.";

    @Test
    public void itemCanBeRemovedInCartTest () {
        ItemPage itemPage = new ItemPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        CartPage cartPage = new CartPage(getDriver());

        HomePage.categoryMenuClick();
        CatalogPage.selectItemInTheGrid();
        itemPage.addItemToCart();
        homePage.waitForAndGetCartQuantity();
        HomePage.cartClick();
        CartPage.removeButtonClick();
        String noItemsText = cartPage.removalMessage();
        Assert.assertEquals(noItemsText, cartMessage, "Cart is not empty");
    }
}
