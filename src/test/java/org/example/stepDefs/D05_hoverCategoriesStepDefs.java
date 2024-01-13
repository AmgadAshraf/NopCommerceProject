package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class D05_hoverCategoriesStepDefs {

    P03_homePage hover = new P03_homePage();

    @Given("user select a random category or sub-category and hover over it")
    public void step1() throws InterruptedException {

        // 1- select random category
        Thread.sleep(3000);
        List<WebElement> categories = Hooks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"] > li > a[href]"));
        int min = 0;
        int max = categories.size() -1;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        System.out.println(random_int);

        // 2- hover on the selected category
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(categories.get(random_int)).perform();
        Thread.sleep(2000);

        // 3- Reduce implicit wait in case if the selected subCateogry is empty


        // 4- If the subcategories equal zero then click on the category itself, else select random subcategory


    }

    @Then("user verify category or sub-category title is equal to the category or sub-category selected")
    public void step2()
    {
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        List<WebElement> categories = Hooks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"] > li > a[href]"));

        int min = 0;
        int max = categories.size() -1;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        List<WebElement> subCategories  =  Hooks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"] > li:nth-child("+(random_int+1)+") > a[href] + div[class=\"sublist-toggle\"] + ul[class=\"sublist first-level\"] > li"));


if (subCategories.size() == 0) {
            String title = categories.get(random_int).getText();
            categories.get(random_int).click();
            String actualtitle = Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"] h1")).getText();
            SoftAssert sa = new SoftAssert();
            sa.assertTrue(actualtitle.contains(title));
            sa.assertAll();
        }
        else {

            min = 0;
            max = subCategories.size() - 1;

            random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
            String subtitle =subCategories.get(random_int).getText();

            subCategories.get(random_int).click();
            String actualsubtitle = Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"] h1")).getText();
            SoftAssert sa = new SoftAssert();
            sa.assertTrue(actualsubtitle.contains(subtitle));
            sa.assertAll();

        }
        Hooks.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }

}


 /*int numofsub = hover.sublist().size();
        Random random = new Random();
        int rando = random.nextInt(numofsub);
        WebElement randomsubelement = hover.sublist().get(rando);
        Actions actions = new Actions(Hooks.driver);
        actions.moveToElement(randomsubelement).click();*/


        /*Thread.sleep(3000);
        int numofElements = hover.hovers().size();
        Random random = new Random();
        int rand = random.nextInt(numofElements);
        WebElement randomelement = hover.hovers().get(rand);

        Actions action = new Actions(Hooks.driver);
        action.moveToElement(randomelement).perform();
        Thread.sleep(2000);*/