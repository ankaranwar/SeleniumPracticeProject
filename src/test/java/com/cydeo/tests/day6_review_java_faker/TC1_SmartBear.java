package com.cydeo.tests.day6_review_java_faker;

import com.cydeo.utilities.SmartBearUtilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC1_SmartBear {

    /*

    TC #1: Smartbear software link verification
                1. Open browser
                2. Go to website:
                http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
                3. Enter username: “Tester”
                4. Enter password: “test”
                5. Click to Login button
                6. Print out count of all the links on landing page
                7. Print out each link text on this page

                Mini-Task:
                • Create a method called loginToSmartBear
                • This method simply logs in to SmartBear when you call it.
                • Accepts WebDriver type as parameter
     */

      /*
    Mini-Task:
            • Create a method called loginToSmartBear
            • This method simply logs in to SmartBear when you call it.
            • Accepts WebDriver type as parameter
     */



    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

      driver = WebDriverFactory.getDriver("Chrome");

      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.manage().window().maximize();

      driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

      SmartBearUtilities.logintToSmartBear(driver);

    }

    @Test
    public void test1(){

        List<WebElement> links = driver.findElements(By.xpath("//body//a"));

        System.out.println("Count of all the links on the page = " + links.size());

        for ( WebElement eachLink : links){
            System.out.println(eachLink);
        }
    }

    @Test
    public void test2(){


    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }






}
