package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D04_searchStepDefs {

    P03_homePage search = new P03_homePage();

    @Given("user enter product {string} in search bar and click search button")
    public void userEnterProductNameInSearchBarAndClickSearchButton(String name)
    {
        search.searchBtn().sendKeys(name);
        search.searchBtn().sendKeys(Keys.ENTER);
    }

    @Then("{string} products are displayed on webpage")
    public void verifY(String name)
    {
        String Url = Hooks.driver.getCurrentUrl();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(Url.contains("https://demo.nopcommerce.com/search?q="));
        int count = search.verifY().size();
        System.out.println(count);
        List<WebElement> verifY = search.verifY();
        for (int i=0; i<verifY.size(); i++)
        {
            String result = verifY.get(i).getText();
            sa.assertTrue(result.contains(name));
        }

    }


    @Given("user enter product <sku> in search bar and click search button")
    public void userEnterProductSkuInSearchBarAndClickSearchButton(String sku) {

        search.searchBtn().sendKeys(sku);
        search.searchBtn().sendKeys(Keys.ENTER);
    }

    @Then("{string} products are displayed on webpages")
    public void verifysku(String sku)
    {
        WebElement product = Hooks.driver.findElement(By.className("product-item"));
        product.click();
        WebElement SKU = Hooks.driver.findElement(By.cssSelector("div[class=\"sku\"] span[class=\"value\"]"));
        Assert.assertEquals(SKU.getText(),sku);
    }
}
