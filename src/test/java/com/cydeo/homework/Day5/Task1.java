package com.cydeo.homework.Day5;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task1 {

    /*

    TC #1: Tesla “Solar Panel” header verification
            1. Open a Chrome browser
            2. Go to: https://www.tesla.com
            3. Locate Solar Panels header
            4. Verify if it is displayed on the page

     */

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
    }

    @Test
    public void test1() {
        driver.get("https://www.tesla.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement solarHeader = driver.findElement(By.xpath("//a[@title = 'Solar Panels']/span"));

        Assert.assertTrue(solarHeader.isDisplayed());

    }
}
