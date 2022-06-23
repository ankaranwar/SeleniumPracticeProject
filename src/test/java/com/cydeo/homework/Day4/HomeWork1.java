package com.cydeo.homework.Day4;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeWork1 {

    /*
            TC #3: Practice Cydeo/ForgotPassword URL verification

            1. Open Chrome browser
            2. Go to http://practice.cydeo.com/forgot_password
            3. Enter any email into input box
            4. Click on Retrieve password
            5. Verify URL contains:
            Expected: “email_sent”
            6. Verify textbox displayed the content as expected.
            Expected: “Your e-mail’s been sent!”

            Hint: You need to use getText method for this practice.
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cydeo.com/forgot_password ");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("ankaranwar@apple.ca");

        driver.findElement(By.cssSelector("button#form_submit")).click();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "email_sent";

        if(actualURL.contains(expectedURL)){
            System.out.println("URL Verification PASSED!");
        } else {
            System.out.println("URL Verification FAILED!");
        }

        String actualResult = driver.findElement(By.cssSelector("h4[name='confirmation_message']")).getText();
        String expectedResult = "Your e-mail's been sent!";


        System.out.println(actualResult);
        System.out.println(expectedResult);

        if(actualResult.equals(expectedResult)){
            System.out.println("Textbox Verification PASSED!");
        } else {
            System.out.println("Textbox Verification FAIELD!");
        }

        driver.close();

        System.out.println("Good job Ankar!");

    }
}
