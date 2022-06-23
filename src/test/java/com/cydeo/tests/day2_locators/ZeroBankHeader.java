package com.cydeo.tests.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBankHeader {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        String actualResult = driver.findElement(By.tagName("h")).getText();
        // returns the header in a string format

        String expectedText = "Log into ZeroBank";

        if(actualResult.equals(expectedText)){
            System.out.println("Header verification PASSED!");
        } else {
            System.out.println("Header verification FAILED!");
        }
    }
}
