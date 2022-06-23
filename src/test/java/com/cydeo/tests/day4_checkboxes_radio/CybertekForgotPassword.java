package com.cydeo.tests.day4_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CybertekForgotPassword {

    public static void main(String[] args) {

        //TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");

        //2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH locator only (total of 6)

        //a. “Home” link
        WebElement homeLink = driver.findElement(By.xpath("//a[@class = 'nav-link']"));

        //b. “Forgot password” header
        WebElement header = driver.findElement(By.xpath("//div[@id = 'content']/div/h2[1]"));

        //c. “E-mail” text
        WebElement emailText = driver.findElement(By.xpath("//*[@class='large-6 small-12 columns']"));

        //d. E-mail input box
        WebElement inputBox = driver.findElement((By.xpath("//input[@type='text']")));

        //e. “Retrieve password” button
        WebElement button = driver.findElement((By.cssSelector("button#form_submit")));
        WebElement button2 = driver.findElement((By.cssSelector("button.radius")));

        //f. “Powered by Cybertek School” text
        WebElement bottomText = driver.findElement(By.xpath("//div[@id = 'page-footer']/div"));

        //4. Verify all WebElements are displayed.

    }
}
