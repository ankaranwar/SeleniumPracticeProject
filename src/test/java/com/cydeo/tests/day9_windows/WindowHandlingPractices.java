package com.cydeo.tests.day9_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandlingPractices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("practice.cybertekschool.com/windows");
    }

    @Test
    public void test1(){

        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        Assert.assertEquals(actualTitle, "Practice");

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));

        String titleAfterClick = driver.getTitle();
        System.out.println("titleAfterClick = " + titleAfterClick);

        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        // Set only allows unique values, no duplicates allowed
        Set<String> windowHandle = driver.getWindowHandles();

        for (String each : windowHandle) {
            driver.switchTo().window(each);
            System.out.println("Current title: " + driver.getTitle());
        }

        Assert.assertEquals(driver.getTitle(), "New Window");


        // If I want to switch back to main page
        driver.switchTo().window(mainHandle);







    }

    @Test
    public void test2(){

        driver.get("https://www.amazon.com");
        
    }

}
