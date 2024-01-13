package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver = null;
    @Before
    public static void openBrowser()
    {
      WebDriverManager.chromedriver().setup();

      driver = new ChromeDriver();

      driver.manage().window().fullscreen();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.navigate().to("https://demo.nopcommerce.com/");

    }

    @After
    public static void quitDriver() throws InterruptedException {
      Thread.sleep(3000);
      driver.quit();


    }

}
