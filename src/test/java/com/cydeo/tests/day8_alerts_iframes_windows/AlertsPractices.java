package com.cydeo.tests.day8_alerts_iframes_windows;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertsPractices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void test1(){

        // Locating the warning alert button in order to click on it
        WebElement jSAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));

        // Click on the button
        jSAlertButton.click();

        // 1 - Create Alert instance and switch to alert
        Alert alert = driver.switchTo().alert();

        BrowserUtils.wait(2);

        // 2 - Use "Alert" instance to accept the javascript alert
        alert.accept();

        // 3 - Locating the result text web element
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        // Assert "resultText" is displayed
        Assert.assertEquals(resultText.isDisplayed(),"Result text is not displayed. Verification failed!");
    }

    @Test
    public void test2(){

        // Locating the warning alert button in order to click on it
        WebElement jSConfirmAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));

        // Click on the button
        jSConfirmAlertButton.click();

        // 1 - Create Alert instance and switch to alert
        Alert alert = driver.switchTo().alert();

        BrowserUtils.wait(2);

        // 2 - Use "Alert" instance to either accept or cancel the javascript alert
        alert.accept();

        // 3 - Locating the result text web element
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        // Assert "resultText" is displayed
        Assert.assertEquals(resultText.isDisplayed(),"Result text is not displayed. Verification failed!");
    }

    @Test
    public void test3(){

        // Locating the warning alert button in order to click on it
        WebElement jSPromptAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));

        // Click on the button
        jSPromptAlertButton.click();

        // 1 - Create Alert instance and switch to alert
        Alert alert = driver.switchTo().alert();

        BrowserUtils.wait(2);

        // 2 - User "Alert" instance to type in the input box
        alert.sendKeys("something is happening");

        // 3 - Use "Alert" instance to either accept or cancel the javascript alert
        alert.accept();

        // 4 - Locating the result text web element
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        // Assert "resultText" is displayed
        Assert.assertEquals(resultText.isDisplayed(),"Result text is not displayed. Verification failed!");




    }


    }

