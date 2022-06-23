package com.cydeo.tests.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CybertekLinkVerification {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/forgot_password");

        driver.findElement(By.name("email")).sendKeys("abcd@apple.com");

        driver.findElement(By.id("form_submit")).click();

        if(driver.getCurrentUrl().contains("email_sent")){
            System.out.println("URL verification PASSED!");
        } else {
            System.out.println("URL verification FAILED!");
        }

        if(driver.findElement(By.name("confirmation_message")).getText().equals("Your e-mail's been sent!")){
            System.out.println("Displayed content PASSED!");
        } else {
            System.out.println("Displayed content Failed!");
        }
    }
}
