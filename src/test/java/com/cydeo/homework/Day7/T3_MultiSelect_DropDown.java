package com.cydeo.homework.Day7;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T3_MultiSelect_DropDown {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("Chrome");
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Select select = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        select.selectByValue("java");
        select.selectByValue("js");
        select.selectByValue("c#");
        select.selectByValue("python");
        select.selectByValue("ruby");
        select.selectByValue("c");

        List<WebElement> allSelectedValues = select.getAllSelectedOptions();
        List<WebElement> allOptions = select.getOptions();

        System.out.println(allSelectedValues);

        select.deselectAll();

        for(WebElement eachOption : allOptions){
            Assert.assertTrue(!eachOption.isSelected());
        }

    }
}
