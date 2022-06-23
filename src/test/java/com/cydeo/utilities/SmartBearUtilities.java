package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {

    public static void logintToSmartBear(WebDriver driver){
        WebElement userNameInput = driver.findElement(By.id("ctl00_MainContent_username"));
        userNameInput.sendKeys("Tester");

        WebElement passWordInput = driver.findElement(By.id("ctl00_MainContent_password"));
        passWordInput.sendKeys("test");

        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();
    }

    public static void verifyOrder(WebDriver driver, String str){

        // created a locator that only returns the names of the customer from all of the rows
        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        // iterating thru the list and verifying if the given name argument exists in the list
        for( WebElement each : namesList){

            if(each.getText().equals(str)){
                // this is done so that I can pass my test
                Assert.assertTrue(true);
                return;
            }
        }

        Assert.fail("Name does not exist in the list!");
    }

    public static void printNamesAndCities(WebDriver driver) {

        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        List<WebElement> citiesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[7]"));

        for (int i = 0; i < namesList.size(); i++) {

            System.out.println("Name: " + (i + 1) + namesList.get(i).getText() + ", City: " + citiesList.get(i).getText());
        }

    }


}
