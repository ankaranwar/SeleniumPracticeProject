package com.cydeo.homework.Day6;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class H2_Etsy {

    /*


     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
    }

    @Test
    public void test1() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // 1. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id = 'global-enhancements-search-query']"));



        // 2. Search for “wooden spoon”
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);



        // 3. Click on filters
        WebElement allFiltersButton = driver.findElement(By.xpath("//button[@id='search-filter-button']"));
        allFiltersButton.click();



        // 4. Select free shipping, on sale
        WebElement freeDeliveryCheckbox = driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']"));
        freeDeliveryCheckbox.click();

        Thread.sleep(1000);

        WebElement onSaleCheckbox = driver.findElement(By.xpath("//label[@for='special-offers-on-sale']"));
        onSaleCheckbox.click();



        // 5. Select under $25 Click on apply filters
        WebElement under25 = driver.findElement(By.xpath("//label[@for='price-input-1']"));
        under25.click();


        WebElement applyButton = driver.findElement(By.xpath("//button[@aria-label = 'Apply']"));
        applyButton.click();



        //  6. Print count of results
        WebElement countOfResult = driver.findElement(By.xpath("//span[contains(text(),'results,')]"));

        System.out.println(countOfResult.getText());





    }

}
