package com.cydeo.homework.Day3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeWork1 {

    /*

    TC #3: Back and forth navigation
            1- Open a chrome browser
            2- Go to: https://google.com
            3- Click to Gmail from top right.
            4- Verify title contains:
              Expected: Gmail
            5- Go back to Google by using the .back();
            6- Verify title equals:
              Expected: Google

     */

    public static void main(String[] args) {

        // creating a webdriver instance
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        // going to google.com
        driver.get("https://google.com");

        // maximizing my window
        driver.manage().window().maximize();

        // locating the gmail button and click on it
        driver.findElement(By.className("gb_d")).click();

        String expectedTitle1 = "Gmail";
        String actualTitle1 = driver.getTitle();


        System.out.println(expectedTitle1);
        System.out.println(actualTitle1);

        // verifying the title
        if(expectedTitle1.contains(actualTitle1)){
            System.out.println("Title Verification PASSED!");
        } else {
            System.out.println("Title Verification FAILED!");
        }

        // going back
        driver.navigate().back();

        String expectedTitle2 = "Google";
        String actualTitle2 = driver.getTitle();

        System.out.println(expectedTitle2);
        System.out.println(actualTitle2);

        // verifying the title
        if(expectedTitle2.equals(actualTitle2)){
            System.out.println("Title Verification PASSED!");
        } else {
            System.out.println("Title Verification FAILED!");
        }

        driver.close();






    }
}
