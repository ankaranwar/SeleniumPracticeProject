package com.cydeo.tests.day10_testbase_driverUtil;

import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class DriverUtilsPractice {

    @Test
    public void simple_google_search_test(){
        Driver.getDriver().get("https//google.com");
    }
}
