package com.cydeo.homework.Day5;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task4 {

    /*

    TC #2: Radiobutton handling
            1. Open Chrome browser
            2. Go to https://practice.cydeo.com/radio_buttons
            3. Click to “Hockey” radio button
            4. Verify “Hockey” radio button is selected after clicking.
            USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
    }

    @Test
    public void test1(){
        driver.get("https://practice.cydeo.com/radio_buttons");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement hockeyButton = driver.findElement(By.xpath("//input[@id='hockey']"));

        hockeyButton.click();

        Assert.assertTrue(hockeyButton.isSelected());

        driver.close();

    }
}
