package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishlistStepDefs {

    P03_homePage wishlist = new P03_homePage();

    @Given("user clicks on wishlist button of a product")
    public void HTCbtn()
    {
        wishlist.wishlistbtns().get(2).click();
    }

    @Then("verify success message appeared")
    public void success() throws InterruptedException {
        String text = Hooks.driver.findElement(By.cssSelector("p[class=\"content\"]")).getText();
        String actualColor = Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]")).getCssValue("background-color");
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(text.contains("The product has been added to your"));
        sa.assertEquals(actualColor,"rgba(75, 176, 122, 1)");
        sa.assertAll();

    }

    @Given("user adds product to wishlist and opens wishlist tab")
    public void wishlistTab()
    {

        wishlist.wishlistbtns().get(2).click();
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(7));
        boolean check = wait.until(ExpectedConditions.invisibilityOf(wishlist.successBar()));
        Assert.assertTrue(check);
        wishlist.wishlisttab().click();

    }

    @Then("verify product is in the wishlist tab")
    public void verifyproduct()
    {
        int actualQty = Integer.parseInt(wishlist.qty().getAttribute("value"));
        System.out.println(actualQty);
        Assert.assertTrue(actualQty>0);
    }

}
