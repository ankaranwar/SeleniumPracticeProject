package com.cydeo.homework.Day3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeWork2 {

    /*

                TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
            1- Open a chrome browser
            2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
            3- Verify “Reset password” button text is as expected:
            Expected: Reset password



            PS: Inspect and decide which locator you should be using to locate web
            elements.
            PS2: Pay attention to where to get the text of this button from

     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        driver.manage().window().maximize();

        String expectedResult = "Reset password";
        String actualResult = driver.findElement(By.cssSelector("button[class = 'login-btn']")).getText();


        if(expectedResult.equals(actualResult)){
            System.out.println("Button verification PASSED!");
        } else {
            System.out.println("Button verification FAILED!");
        }
    }
}
