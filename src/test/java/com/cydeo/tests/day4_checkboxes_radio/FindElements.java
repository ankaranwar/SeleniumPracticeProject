package com.cydeo.tests.day4_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElements {

    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        List<WebElement> list = driver.findElements(By.xpath("//body//a"));

        for(WebElement each : list){
            System.out.println(each.getText());
        }
    }

}
