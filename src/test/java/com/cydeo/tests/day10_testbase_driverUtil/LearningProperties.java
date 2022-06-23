package com.cydeo.tests.day10_testbase_driverUtil;

import org.testng.annotations.Test;

public class LearningProperties {

    @Test
    public void test1(){
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));


    }
}
