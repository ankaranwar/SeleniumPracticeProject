package com.cydeo.tests.day6_review_java_faker;

import com.cydeo.utilities.SmartBearUtilities;
import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC2_SmartBear {

    /*
    TC#2: Smartbear software order placing
            1. Open browser
            2. Go to website:
            http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
            3. Enter username: “Tester”
            4. Enter password: “test”
            5. Click on Login button
            6. Click on Order
            7. Select familyAlbum from product, set quantity to 2
            8. Click to “Calculate” button
            9. Fill address Info with JavaFaker
            • Generate: name, street, city, state, zip code
            10.Click on “visa” radio button
            11.Generate card number using JavaFaker
            12.Click on “Process”
            13.Verify success message “New order has been successfully added.”
     */

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver("Chrome");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtilities.logintToSmartBear(driver);
    }

    @Test
    public void test(){

        //            6. Click on Order
        WebElement orderButton = driver.findElement(By.linkText("Order"));
        orderButton.click();



        //            7. Select familyAlbum from product, set quantity to 2
        WebElement familyAlbumDropDown = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));

        Select select = new Select(familyAlbumDropDown);

        select.selectByIndex(1);

        Assert.assertEquals(select.getFirstSelectedOption().getText(),"FamilyAlbum","Wrong option selected in Product");

        WebElement quantityBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));

        quantityBox.sendKeys("2");


        //            8. Click to “Calculate” button
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();


        //            9. Fill address Info with JavaFaker
        //            • Generate: name, street, city, state, zip code

        Faker faker = new Faker();

        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']")).sendKeys(faker.name().fullName());
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']")).sendKeys(faker.address().city());
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']")).sendKeys(faker.address().state());
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']")).sendKeys(faker.address().zipCode());


        //            10.Click on “visa” radio button
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']")).click();



        //            11.Generate card number using JavaFaker
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys(faker.business().creditCardNumber());
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")).sendKeys(faker.business().creditCardExpiry());

        //            12.Click on “Process”
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

        //            13.Verify success message “New order has been successfully added.”
        Assert.assertTrue(driver.findElement(By.xpath("//div/strong")).isDisplayed());

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
}
