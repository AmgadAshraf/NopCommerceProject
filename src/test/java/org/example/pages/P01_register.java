package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_register {

    public WebElement registerBtn()
    {

        WebElement registerBtn = Hooks.driver.findElement(By.className("ico-register"));
        return registerBtn;
    }

    public WebElement genderBtn()
    {

        WebElement genderBtn = Hooks.driver.findElement(By.className("male"));
        return genderBtn;
    }

    public WebElement enterName()
    {
        WebElement enterName = Hooks.driver.findElement(By.name("FirstName"));
        return enterName;
    }
    public WebElement lastName()
    {
        WebElement lastName = Hooks.driver.findElement(By.name("LastName"));
        return lastName;
    }

    public WebElement dateOfBirth()
    {
        WebElement dropdown = Hooks.driver.findElement(By.name("DateOfBirthDay"));
        return dropdown;
    }
    public WebElement enterEmail()
    {
        WebElement enterEmail = Hooks.driver.findElement(By.name("Email"));
        return enterEmail;
    }

    public WebElement enterPassword()
    {
        WebElement enterPassword = Hooks.driver.findElement(By.name("Password"));
        return enterPassword;
    }
    public WebElement confirmPassword()
    {
        WebElement confirmPassword = Hooks.driver.findElement(By.name("ConfirmPassword"));
        return confirmPassword;
    }

    public WebElement clickregister()
    {
        WebElement clickregister = Hooks.driver.findElement(By.name("register-button"));
        return clickregister;
    }

    public WebElement verifyRegis()
    {
        WebElement verifyRegis = Hooks.driver.findElement(By.className("result"));
        return verifyRegis;
    }

}
