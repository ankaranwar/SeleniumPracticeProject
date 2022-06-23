package com.cydeo.tests.day10_testbase_driverUtil;

import com.cydeo.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_file() throws IOException {

        //Create Properties class object to be able to read properties file
        Properties properties = new Properties();

        // Opening the file in JVM memory using FileInputStream
        // We need to pass the path of the file we want to open in JVM
        FileInputStream file = new FileInputStream("configuration.properties");

        // Loading the file into properties objects
        properties.load(file);

        // We will read from the file
        properties.getProperty("browser");

        // We will close the file
        file.close();

    }

    @Test
    public void using_properties_utility_method(){
        ConfigurationReader.getProperty("browser");
    }
}
