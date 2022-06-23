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

public class Homework {

    /*

    TC : Selecting date on dropdown and verifying
            1. Open Chrome browser
            2. Go to https://practice.cydeo.com/dropdown
            3. Select “December 1st, 1923” and verify it is selected.
             Select year using   : visible text
            Select month using    : value attribute Select
            day using : index number
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        year.selectByValue("1996");
        month.selectByVisibleText("November");
        day.selectByIndex(27);

        Assert.assertEquals(year.getFirstSelectedOption().getText(),"1996");
        Assert.assertEquals(month.getFirstSelectedOption().getText(),"November");
        Assert.assertEquals(day.getFirstSelectedOption().getText(),"28");

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }
}
