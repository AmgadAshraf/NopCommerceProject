package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDefs {

    P01_register register = new P01_register();

    @Given("user go to registeration page")
    public void step1()
    {
        register.registerBtn().click();
    }

    @When("user select gender type")
    public void step2()
    {
        register.genderBtn().click();
    }

    @And("user enter first name \"automation\" and last name \"tester\"")
    public void step3()
    {
        register.enterName().sendKeys("automation");
        register.lastName().sendKeys("tester");
    }

    @And("user enter date of birth")
    public void step4()
    {

        WebElement dropdown = Hooks.driver.findElement(By.name("DateOfBirthDay"));
        Select select = new Select(dropdown);
        select.selectByIndex(4);

        WebElement Monthdropdown = Hooks.driver.findElement(By.name("DateOfBirthMonth"));
        select = new Select(Monthdropdown);
        select.selectByIndex(11);

        WebElement Yeardropdown = Hooks.driver.findElement(By.name("DateOfBirthYear"));
        select = new Select(Yeardropdown);
        select.selectByValue("1997");
    }

    @And("user enter email \"test@example.com\" field")
    public void step5()
    {
        register.enterEmail().sendKeys("test@example.com");
    }

    @And("user fills Password fields \"P@ssw0rd\" \"P@ssw0rd\"")
    public void step6()
    {
        register.enterPassword().sendKeys("P@ssw0rd");
        register.confirmPassword().sendKeys("P@ssw0rd");
    }

    @And("user clicks on register button")
    public void step7()
    {
        register.clickregister().click();
    }

    @Then("success message is displayed")
    public void step8()
    {
        //register.verifyRegis();
        String actualText = Hooks.driver.findElement(By.className("result")).getText();
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(actualText.contains("Your registration completed"));
        String actualColor = Hooks.driver.findElement(By.className("result")).getCssValue("color");
        sa.assertEquals(actualColor,"rgba(76, 177, 124, 1)");
        sa.assertAll();
    }

}
