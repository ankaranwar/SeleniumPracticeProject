package com.cydeo.tests.day4_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        // locating the first checkbox
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        // locating the second checkbox
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        // Confirm checkbox 1 is NOT selected by default
        if(!checkbox1.isSelected()){
            System.out.println("Checkbox is not selected. Veri is PASSED!");
        } else {
            System.out.println("Checkbox is selected. Veri is FAILED!");
        }

        // Confirm checkbox 2 is selected by default
        if(!checkbox2.isSelected()){
            System.out.println("Checkbox is not selected. Veri is FAILED!");
        } else {
            System.out.println("Checkbox is selected. Veri is PASSED!");
        }

        // select check1 one and unselect checkbox2
        checkbox1.click();
        checkbox2.click();

        if(checkbox1.isSelected()){
            System.out.println("Checkbox is selected. Veri is PASSED!");
        } else {
            System.out.println("Checkbox is NOT selected. Veri is FAILED!");
        }

        if(!checkbox2.isSelected()){
            System.out.println("Checkbox is not selected. Veri is PASSED!");
        } else {
            System.out.println("Checkbox is selected. Veri is FAILED!");
        }
    }
}
