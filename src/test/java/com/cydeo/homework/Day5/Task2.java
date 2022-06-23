package com.cydeo.homework.Day5;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task2 {

    /*
    TC #4: FindElements Task
            1- Open a chrome browser
            2- Go to: https://practice.cydeo.com/abtest
            3- Locate all the links in the page.
            4- Print out the number of the links on the page.
            5- Print out the texts of the links.
            6- Print out the HREF attribute values of the links
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        driver.get("https://practice.cydeo.com/abtest");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        System.out.println("There are " + allLinks.size() + " on the web page");

        for(WebElement each : allLinks){

            System.out.println(each.getText());
            System.out.println(each.getAttribute("href"));
        }

    }

}
