package com.cydeo.homework.Day7;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_SimpleDropDown {

    /*

    TC #1: Verifying “Simple dropdown” and “State selection”
        dropdown default values
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/dropdown
        3. Verify “Simple dropdown” default selected value is correct
        Expected: “Please select an option”
        4. Verify “State selection” default selected value is correct
        Expected: “Select a State”
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
    }

    @Test
    public void test1(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/dropdown");

        Select select = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        String actualDefaultForSimple = select.getFirstSelectedOption().getText();
        String expectedDefaultForSimple = "Please select an option";

        Assert.assertEquals(actualDefaultForSimple,expectedDefaultForSimple,"default value isn't correct");

        Select select2 = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        String actualDefaultForState= select2.getFirstSelectedOption().getText();
        String expectedDefaultForState = "Select a State";

        Assert.assertEquals(actualDefaultForState,expectedDefaultForState,"default value isn't correct");

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }
}
