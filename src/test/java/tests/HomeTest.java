package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.object.HomePage;

public class HomeTest extends BaseTest{

    private String updatedCurrency = "EUR";

    @Test
    public void currencyCanBeChangedToEurTest () {
        HomePage.clickOnChangeButton();
        HomePage.selectCurrency();
        HomePage.saveCurrency();
        String currency = HomePage.checkSavedCurrency();
        Assert.assertEquals(currency, updatedCurrency, "Currency is not updated");
    }
}
