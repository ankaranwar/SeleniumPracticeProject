package com.cydeo.homework.Day4;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeWork2 {

    /*
                TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
                1- Open a chrome browser
                2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
                3- Enter incorrect username into login box:
                4- Click to `Reset password` button
                5- Verify “error” label is as expected
                Expected: Login or E-mail not found

     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@class='login-inp']")).sendKeys("!@#!@#!@$");
        driver.findElement(By.xpath("//button[@class='login-btn']")).click();

        String actualLabel = driver.findElement(By.className("errortext")).getText();
        String expectedLabel = "Login or E-mail not found";

        if(expectedLabel.equals(actualLabel)){
            System.out.println("Label verification PASSED!");
        } else {
            System.out.println("Label verification FAILED!");
        }




    }




}
