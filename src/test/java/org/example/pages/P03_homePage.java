package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_homePage {
    public WebElement currencyBtn()
    {
        WebElement currencyBtn = Hooks.driver.findElement(By.id("customerCurrency"));
        return currencyBtn;
    }

    public List<WebElement> verify()
    {
        List<WebElement> verify = Hooks.driver.findElements(By.className("actual-price"));
        return verify;
    }

    public WebElement searchBtn()
    {
        WebElement searchBtn = Hooks.driver.findElement(By.id("small-searchterms"));
        return searchBtn;
    }

    public List<WebElement> verifY()
    {
        List<WebElement> verifY = Hooks.driver.findElements(By.className("product-title"));
        return verifY;
    }

    public WebElement sliders(String num)
    {
       // WebElement sliders = Hooks.driver.findElement(By.cssSelector("a[class=\\\"nivo-imageLink\\\"]:nth-child(\"+num+\")"));
        // return sliders;
        return Hooks.driver.findElement(By.cssSelector("a[class=\"nivo-imageLink\"]:nth-child("+num+")"));
    }

    public List<WebElement> hovers()
    {
        List<WebElement> hovers = Hooks.driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/child::li/child::a/following-sibling::ul/preceding-sibling::a"));
        return hovers;
    }

    public List<WebElement> sublist()
    {
        List<WebElement> sublist = Hooks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"] > li:nth-child(\"+(random_int+1)+\") > a[href] + div[class=\"sublist-toggle\"] + ul[class=\"sublist first-level\"] > li"));
        return sublist;
    }

    public WebElement facebook()
    {
        WebElement facebook = Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]"));
        return facebook;
    }

    public WebElement twitter()
    {
        WebElement twitter = Hooks.driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]"));
        return twitter;
    }

    public WebElement rss()
    {
        WebElement rss = Hooks.driver.findElement(By.cssSelector("a[href=\"/news/rss/1\"]"));
        return rss;
    }

    public WebElement youtube()
    {
        WebElement youtube = Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]"));
        return youtube;
    }

    public List<WebElement> wishlistbtns()
    {
        List<WebElement> wishlistbtns = Hooks.driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]"));
        return wishlistbtns;
    }

    public WebElement wishlisttab()
    {
        WebElement wishlisttab = Hooks.driver.findElement(By.cssSelector("a[class=\"ico-wishlist\"]"));
        return wishlisttab;
    }

    public WebElement successBar()
    {
        WebElement successBar = Hooks.driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
        return successBar;
    }

    public WebElement qty()
    {
        WebElement qty = Hooks.driver.findElement(By.cssSelector("input[class=\"qty-input\"]"));
        return qty;
    }
}
