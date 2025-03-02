package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.object.HomePage;

public class HomeTest extends BaseTest{

    private String updatedCurrency = "EUR";

    @Epic("Header")
    @Feature("Currency")
    @Description("Currency is updated")
    @Test(description = "Currency can be changed to Eur")
    public void currencyCanBeChangedToEurTest () {
        HomePage.clickOnChangeButton();
        HomePage.selectCurrency();
        HomePage.saveCurrency();
        HomePage.checkSavedCurrency(updatedCurrency);
    }
}