package com.cydeo.tests.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CYDEOVerification {

            //    TC #2: Cybertek verifications
            //    1. Open Chrome browser
            //    2. Go to https://practice.cybertekschool.com
            //    3. Verify URL contains
            //    Expected: cybertekschool
            //     4. Verify title:
            //    Expected: Practice

    public static void main(String[] args) {

        // I set up up my browser driver first
        WebDriverManager.chromedriver().setup();

        // I create an instance of the ChromeDriver using the WebDriver inteface
        WebDriver driver = new ChromeDriver();

        // I go to the page that I want to go to
        driver.get("http://practice.cybertekschool.com");

        // This line will maximize the newly opened browser page
        driver.manage().window().maximize();

        if(driver.getCurrentUrl().contains("cybertekschool")){
            System.out.println("URL verification PASSED!");
        } else {
            System.out.println("URL verification FAILED!");
        }

        if(driver.getTitle().contains("Practice")){
            System.out.println("Title verification PASSED!");
        } else {
            System.out.println("Title verification FAILED!");
        }

    }
}
