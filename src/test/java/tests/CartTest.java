package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.object.CartPage;
import pages.object.CatalogPage;
import pages.object.HomePage;
import pages.object.ItemPage;

public class CartTest extends BaseTest{

    private final String cartMessage = "There are no items in your cart.";
    private final String itemName = "Purple Duck";
    private final String itemAmount = "1";

    @Epic("Cart")
    @Feature("Removal functionality in the cart")
    @Description("Cart is empty when User removes all items")
    @Test(description = "Item is removed in the cart")
    public void itemCanBeRemovedInCartTest () {
        HomePage.categoryMenuClick();
        CatalogPage.selectItemInTheGrid(itemName);
        ItemPage.addItemToCart();
        HomePage.waitForAndGetCartQuantity(itemAmount);
        HomePage.cartClick();
        CartPage.removeButtonClick();
        CartPage.removalMessage(cartMessage);
    }
}