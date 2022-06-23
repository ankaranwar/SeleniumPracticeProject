package com.cydeo.tests.day8_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframePractices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/iframe");
    }

    @Test
    public void test1(){

        WebElement iframe = driver.findElement(By.xpath("//mce_0_ifr"));
        driver.switchTo().frame(iframe);

        WebElement yourContentGoesHere = driver.findElement(By.xpath("//p"));

        driver.switchTo().defaultContent();

        WebElement headerText = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(headerText.isDisplayed(),"Header text is not displayed. Verification FAILED!");






    }
}
