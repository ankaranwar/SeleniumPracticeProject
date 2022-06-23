package com.cydeo.homework.Day6;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task1 {

    /*
            TC #1: StaleElementReferenceException handling
                    1. Open Chrome browser
                    2. Go to https://practice.cydeo.com/add_remove_elements/
                    3. Click to “Add Element” button
                    4. Verify “Delete” button is displayed after clicking.
                    5. Click to “Delete” button.
                    6. Verify “Delete” button is NOT displayed after clicking.
                    USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
    }

    @Test
    public void test1(){
        driver.get("https://practice.cydeo.com/add_remove_elements/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        Assert.assertTrue(deleteButton.isDisplayed(),"Delete Button NOT displayed");

        deleteButton.click();

        try{
            Assert.assertTrue(deleteButton.isDisplayed(),"Delete Button IS displayed");
        } catch(StaleElementReferenceException e){
            e.getMessage();
            System.out.println("The delete button is deleted from the page");
        }


    }





}
