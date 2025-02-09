package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.object.HomePage;

public class HomeTest extends BaseTest{

    private String updatedCurrency = "EUR";

    @Test
    public void currencyCanBeChangedToEurTest () {
        HomePage.clickOnChangeButton(driver);
        HomePage.selectCurrency(driver);
        HomePage.saveCurrency(driver);
        String currency = HomePage.checkSavedCurrency(driver);
        Assert.assertEquals(currency, updatedCurrency, "Currency is not updated");
    }
}
