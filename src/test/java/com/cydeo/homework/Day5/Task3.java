package com.cydeo.homework.Day5;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task3 {

    /*
    Practice: Checkboxes
            1. Go to http://practice.cydeo.com/checkboxes
            2. Confirm checkbox #1 is NOT selected by default
            3. Confirm checkbox #2 is SELECTED by default.
            4. Click checkbox #1 to select it.
            5. Click checkbox #2 to deselect it.
            6. Confirm checkbox #1 is SELECTED.
            7. Confirm checkbox #2 is NOT selected.
     */


    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
    }

    @Test
    public void test1(){
        driver.get("http://practice.cydeo.com/checkboxes");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[@id='box1']"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[@id='box2']"));

        Assert.assertTrue(!checkbox1.isSelected(), "checkbox 1 IS selected");
        Assert.assertTrue(checkbox2.isSelected(), "checkbox 2 isn't selected");

        checkbox1.click();
        checkbox2.click();

        Assert.assertTrue(checkbox1.isSelected(), "checkbox 1 IS NOT selected");
        Assert.assertTrue(!checkbox2.isSelected(), "checkbox 2 IS selected");

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }
}
