package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import java.awt.*;

public class D02_loginStepDefs {

    P02_login login = new P02_login();

    @Given("user go to login page")
    public void step1()
    {
        login.loginPage().click();
    }

    @When("user login with \"valid\" \"test@example.com\" and \"P@ssw0rd\"")
    public void step2()
    {
        login.validMail().sendKeys("test@example.com");
        login.validPassword().sendKeys("P@ssw0rd");
    }

    @And("user press on login button")
    public void step3()
    {
        login.loginBtn().click();
    }

    @Then("user login to the system successfully")
    public void step4()
    {
        login.verify();
        String actualUrl = Hooks.driver.getCurrentUrl();
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(actualUrl,"https://demo.nopcommerce.com/");
        boolean MyaccBtn = Hooks.driver.findElement(By.className("ico-account")).isDisplayed();
        sa.assertTrue(MyaccBtn);
        sa.assertAll();
    }

    @When("user login with \"invalid\" \"tesst@example.com\" and \"P@sssw0rd\"")
    public void step5()
    {
        login.validMail().sendKeys("tesst@example.com");
        login.validPassword().sendKeys("P@sssw0rd");
    }

    @Then("user could not login to the system")
    public void step6()
    {
        login.unsuccessful();
        String errorMsg = Hooks.driver.findElement(By.className("validation-summary-errors")).getText();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(errorMsg.contains("Login was unsuccessful."));
        String actualColorRgba = Hooks.driver.findElement(By.className("message-error")).getCssValue("color");
        String actualColorHex = Color.fromString(actualColorRgba).asHex();
        soft.assertEquals(actualColorHex,"#e4434b");
        soft.assertAll();

    }
}
