package com.cydeo.tests.day7_webtables;

import com.cydeo.utilities.SmartBearUtilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTableSmartBear {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.logintToSmartBear(driver);
    }

    @Test
    public void test1(){
        WebElement susanMclaren = driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));

        String expectedDate = "01/05/2021";
        String actualDate = susanMclaren.getText();

        Assert.assertEquals(actualDate, expectedDate, "Actual date is not equal to expected date");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }


}
