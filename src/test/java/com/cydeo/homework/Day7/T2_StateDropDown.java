package com.cydeo.homework.Day7;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T2_StateDropDown {

    /*
    TC #2: Selecting state from State dropdown and verifying result
    1. Open Chrome browser
    2. Go to http://practice.cybertekschool.com/dropdown
    3. Select Illinois
    4. Select Virginia
    5. Select California
    6. Verify final selected option is California.
    Use all Select options. (visible text, value, index)
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Select select = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        select.selectByValue("IL");
        select.selectByValue("VA");
        select.selectByValue("CA");

        Assert.assertEquals(select.getFirstSelectedOption().getText(),"California", "Actual vs expected are not equal!");
    }





}
