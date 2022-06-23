package com.cydeo.tests.day7_webtables;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownPractice12 {

    WebDriver driver;


    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("practice.cybertekschool.com/dropdowns");
    }

    /*
    Open Browser
    Go to website: practice.cybertekschool.com/dropdowns
    Verify default values is always showing the current month
     */

    @Test
    public void test1(){


        Select select1 = new Select(driver.findElement(By.xpath("//select[@id='month']")));

        String actualValue = select1.getFirstSelectedOption().getText().toUpperCase();

        String expectedValue = LocalDateTime.now().getMonth().name();

        Assert.assertEquals(actualValue, expectedValue, "Default month doesn't match current month");

    }

    /*
    Do both verifications in the same test
    Verify list of months are correct as expected
    Expected: Options should contain all 12 months of the year
     */

    @Test
    public void test2(){

        Select select1 = new Select(driver.findElement(By.xpath("//select[@id='month']")));

        // This line gets all of the options from the dropdown and store the value in a list
        List<WebElement> actualMonthOptions = select1.getOptions();

        List<String> actualMonthTexts = new ArrayList<>();

        // This loop converts the list of web elements to a list of web element texts
        for (WebElement each : actualMonthOptions) {
            actualMonthTexts.add(each.getText());
        }

        List<String> expectedMonthOptions = Arrays.asList(
                "January", "February", "March", "April", "May", "June", "July", "August","September","October", "November", "December");

        Assert.assertEquals(actualMonthTexts,expectedMonthOptions);

    }


    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }
}
