package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String str){

        String str2 = str.toUpperCase();

        switch (str2) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "SAFARI":
                WebDriverManager.safaridriver().setup();
                return new SafariDriver();
            case "EDGE":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case "EXPLORER":
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            default:
                System.out.println("Browser not supported!");
        }
        return null;
    }
}
