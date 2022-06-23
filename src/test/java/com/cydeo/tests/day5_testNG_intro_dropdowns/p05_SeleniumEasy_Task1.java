package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class p05_SeleniumEasy_Task1 {

    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.get("https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/interactions/Actions.html");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement successCheckbox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));

        WebElement successMessage = driver.findElement(By.xpath("//div[@id='txtAge']"));

        if(!successMessage.isDisplayed()){
            System.out.println("Success message is not displayed. Verification PASSED!");
        } else {
            System.out.println("Success message is displayed. Verification FAILED!");
        }

        successCheckbox.click();


        if(successCheckbox.isSelected() && successMessage.isDisplayed()){
            System.out.println("Success message is displayed. Verification PASSED!");
        } else {
            System.out.println("Success message is NOT displayed. Verification FAILED!");
        }






    }
}
