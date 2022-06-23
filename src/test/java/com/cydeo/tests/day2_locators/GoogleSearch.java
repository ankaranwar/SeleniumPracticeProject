package com.cydeo.tests.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        driver.manage().window().maximize();

        // i need to locate the search box on google and put 'apple' in it

        driver.findElement(By.name("q")).sendKeys("apple" + Keys.ENTER);

        if(driver.getTitle().equals("apple - Google Search")){
            System.out.println("Search title verification PASSED!");
        } else {
            System.out.println("Search title verification FAILED!");
        }
    }
}
