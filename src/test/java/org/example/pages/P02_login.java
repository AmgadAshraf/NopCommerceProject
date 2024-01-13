package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_login {

    public WebElement loginPage()
    {
        WebElement loginPage = Hooks.driver.findElement(By.className("ico-login"));
        return loginPage;
    }

    public WebElement validMail()
    {
        WebElement validMail = Hooks.driver.findElement(By.id("Email"));
        return validMail;
    }

    public WebElement validPassword()
    {
        WebElement validPassword = Hooks.driver.findElement(By.id("Password"));
        return validPassword;
    }

    public WebElement loginBtn()
    {
        WebElement loginBtn = Hooks.driver.findElement(By.className("login-button"));
        return loginBtn;
    }

    public WebElement verify()
    {
        WebElement verify = null;
        return verify;
    }

    public WebElement unsuccessful()
    {
        WebElement unsuccessful = Hooks.driver.findElement(By.className("validation-summary-errors"));
        return unsuccessful;
    }



}
