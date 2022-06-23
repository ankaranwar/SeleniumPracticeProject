package com.cydeo.tests.day8_alerts_iframes_windows;

import com.cydeo.utilities.SmartBearUtilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTablePractices {

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
    public void verifyOrder(){
        SmartBearUtilities.verifyOrder(driver,"Ankar Anwar");
    }

    @Test
    public void printNamesAndCities(){
        SmartBearUtilities.printNamesAndCities(driver);
    }
}
