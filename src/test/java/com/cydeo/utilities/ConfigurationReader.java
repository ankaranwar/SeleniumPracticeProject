package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //#1 -> We created the properties object
    private static Properties properties = new Properties();

    static {

        // anything here will be run once before anything else

        // there is no method here, so we must use try catch block to handle the chekced exception

        try {
            //#2 -> We get the path and pass it into FileInputStream to open the file
            FileInputStream file = new FileInputStream("configuration.properties");
            //#3 -> We load the opened file into properties object
            properties.load(file);
            //#5 -> We close the file
            file.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    //#4 -> We read from the file
    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }





}
