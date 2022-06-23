package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Amazon_cssSelector {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        WebElement searchBox2 = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));

    }
}
