package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D06_homeSlidersStepDefs {
    P03_homePage home = new P03_homePage();

    @Given("click on first slider")
    public void step1 ()
    {
        home.sliders("1").click();
    }

    @Then("verify first product detail is opened")
    public void first_product_details_opened()
    {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        boolean check =  wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/nokia-lumia-1020"));
        Assert.assertTrue(check);
    }

    @Given("click on second slider")
    public void step2()
    {
        home.sliders("2").click();
    }

    @Then("verify second product detail is opened")
    public void second_product_details_opened()
    {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        boolean check =  wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/iphone-6"));
        Assert.assertTrue(check);
    }
}
