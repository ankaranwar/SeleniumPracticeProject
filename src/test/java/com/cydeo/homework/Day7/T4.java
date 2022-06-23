package com.cydeo.homework.Day7;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void test1(){
        WebElement websiteDropdown = driver.findElement(By.xpath("//div[@class='dropdown']/a"));

        websiteDropdown.click();

        WebElement faceBookLink = driver.findElement(By.xpath("//a[.='Facebook']"));

        faceBookLink.click();

        Assert.assertEquals(driver.getTitle(), "Facebook - Log In or Sign Up", "Title verification FAILED!");
    }
}
