package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com");

        String actualURL = driver.getCurrentUrl();

        if(actualURL.contains("cydeo")){
            System.out.println("The URL has passed!");
        } else {
            System.out.println("The URL hasn't passed!");
        }

        String actualTitle = driver.getTitle();

        if(actualTitle.contains("Practice")){
            System.out.println("The tital has passed!");
        } else {
            System.out.println("The tital hasn't passed!");
        }


        driver.quit();

    }


}
