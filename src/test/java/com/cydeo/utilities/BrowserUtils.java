package com.cydeo.utilities;

// In this class, we will store utility methods that can be applied to any browser content.

// Anytime you feel like you have a good logic that you can use in the future, create a method of it and store it in this class.

// Then call it in the future to use it.

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    /**
    Accepts a list of Web Elements
    @param  list<WebElement>
    @return List<String>
    Method should be returning a list of Strings
     */

    public static List<String> getElementsText(List<WebElement> list){

        List<String> webElementsAsStrings = new ArrayList<>();

        for(WebElement each : list){
            webElementsAsStrings.add(each.getText());
        }

        return webElementsAsStrings;

    }

    /**
    Accepts units of seconds
    @param seconds
    @return void
    Handles checked exceptions with try / catch
     */

    public static void wait(int seconds){

        try{
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e){
            e.printStackTrace();
        }


    }


}
