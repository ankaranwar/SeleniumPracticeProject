package com.cydeo.tests.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTitleVerification {

                //    TC #1: Google Title Verification
                //    1. Open Chrome browser
                //    2. Go to https://www.google.com
                //    3. Verify title:
                //    Expected: Google


    public static void main(String[] args) {

        // setting up the webdriver manager
        WebDriverManager.chromedriver().setup();

        // opens an empty chrome browser for us
        WebDriver driver = new ChromeDriver();

        // maximizing the window
        driver.manage().window().maximize();

        driver.get("www.google.com");

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
         } else {
            System.out.println("Title Verification FAILED!");
        }


    }
}
