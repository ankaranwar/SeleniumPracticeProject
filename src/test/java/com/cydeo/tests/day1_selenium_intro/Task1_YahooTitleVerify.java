package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_YahooTitleVerify {

    public static void main(String[] args) {

        // Step 1
        WebDriverManager.chromedriver().setup();

        // Step 2
        WebDriver driver = new ChromeDriver();

        // Step 3
        driver.manage().window().maximize();

        driver.get("https://www.yahoo.com");

        // Actual title comes from the webpage
        String expectedTitle = "Yahoo";

        // Expected title comes from requirements
        String actualTitle = driver.getTitle();

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Title verification is passed!");
        } else {
            System.out.println("Title verification failed");
        }

        driver.quit();



    }
}
