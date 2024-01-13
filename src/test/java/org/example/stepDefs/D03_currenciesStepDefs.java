package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D03_currenciesStepDefs {

    P03_homePage currencies = new P03_homePage();

    @Given("user select euro as currency")
    public void step1()
    {
        currencies.currencyBtn();
        WebElement dropdown = Hooks.driver.findElement(By.id("customerCurrency"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Euro");
    }

    @Then("verify all products price is in euros")
    public void step2()
    {

        List<WebElement> verify = currencies.verify();

        for (int i=0; i<verify.size(); i++)
        {
            String result = verify.get(i).getText();
            Assert.assertTrue(result.contains("€"));
        }
    }


}
