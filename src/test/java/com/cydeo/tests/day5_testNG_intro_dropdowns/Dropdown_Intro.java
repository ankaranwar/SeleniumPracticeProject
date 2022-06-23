package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Dropdown_Intro {

    WebDriver driver;

    @Test
    public void dropdown_test_1(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
        
        Select simpleDropdown = new Select(driver.findElement(By.id("dropdown")));
        
        String actualSelectedOption = simpleDropdown.getFirstSelectedOption().getText();

        String expectedSelectedOption = "Please select an option";

        Assert.assertEquals(actualSelectedOption,expectedSelectedOption);



    }
}
