package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic_Navigations {

    public static void main(String[] args) throws InterruptedException {

        // 1 - Setting up webdriver Manager
        WebDriverManager.chromedriver().setup();

        // 2 - Create instance of Web Driver
        WebDriver driver = new ChromeDriver();

        // 3 - Make our page full screen
        driver.manage().window().maximize();

        //driver.get("https://www.etsy.com");

        Thread.sleep(3000);

        driver.navigate().to("https://www.etsy.com");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

        driver.getTitle();

        System.out.println(driver.getTitle());
    }
}
