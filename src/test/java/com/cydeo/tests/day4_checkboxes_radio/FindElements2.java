package com.cydeo.tests.day4_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElements2 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        driver.get("https://www.merriam-webster.com/");

        driver.manage().window().maximize();

        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));



        // print out how many links are missing text
        // print out how many links are NOT missing text

        int missingTexts = 0;
        int hasTexts = 0;
        int counter = 0;

        for(WebElement each : listOfLinks ){

            counter++;

            if(each.getText().isEmpty()){
                missingTexts++;
            } else {
                hasTexts++;
            }
        }

        System.out.println("missingTexts = " + missingTexts);
        System.out.println("hasTexts = " + hasTexts);
        System.out.println("counter = " + counter);


    }
}
