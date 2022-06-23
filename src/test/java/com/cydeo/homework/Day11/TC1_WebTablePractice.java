package com.cydeo.homework.Day11;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC1_WebTablePractice {

    /*
    TC #1: Web table practice
            1. Go to: https://practice.cydeo.com/web-tables
            2. Verify Bob’s name is listed as expected.
            Expected: “Bob Martin”
            3. Verify Bob Martin’s order date is as expected
            Expected: 12/31/2021
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @Test
    public void test1(){
        WebElement bobName = driver.findElement(By.xpath("//table[@id = 'ctl00_MainContent_orderGrid']/tbody/tr[7]/td[2]"));

        String bobNameActual = bobName.getText();
        String bobNameExpected = "Bob Martin";

        Assert.assertEquals(bobNameActual, bobNameExpected, "Actual name doesn't match expected name");

        WebElement bobsOrderDate = driver.findElement(By.xpath("//table[@id = 'ctl00_MainContent_orderGrid']/tbody/tr[7]/td[2]/following-sibling::td[3]"));

        String actualOrderDate = bobsOrderDate.getText();
        String expectedOrderDate = "12/31/2021";

        Assert.assertEquals(actualOrderDate, expectedOrderDate, "Actual name doesn't match expected name");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
}
