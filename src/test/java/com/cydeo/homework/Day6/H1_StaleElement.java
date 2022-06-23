package com.cydeo.homework.Day6;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class H1_StaleElement {

    /*
            1. Open a chrome browser
            2. Go to: https://practice.cydeo.com/abtest
            3. Locate “CYDEO” link, verify it is displayed.
            4. Refresh the page.
            5. Verify it is displayed, again.
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {

        driver = WebDriverFactory.getDriver("Chrome");
    }

    @Test
    public void test1() {
        driver.get("https://practice.cydeo.com/add_remove_elements/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement cydeoLink = driver.findElement(By.linkText("CYDEO"));

        Assert.assertTrue(cydeoLink.isDisplayed(), "CYDEO LINK IS NOT DISPLAYED");

        driver.navigate().refresh();

        cydeoLink = driver.findElement(By.linkText("CYDEO"));

        Assert.assertTrue(cydeoLink.isDisplayed(), "CYDEO LINK IS NOT DISPLAYED");


    }
}
