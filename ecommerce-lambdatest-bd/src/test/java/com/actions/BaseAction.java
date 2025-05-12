package com.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriverException;

import com.utilities.HelperClass;

public class BaseAction {

    public static void clickElement(WebElement element) {
        try {
            element.click(); 
        } catch (WebDriverException e) {
            System.out.println("Native click failed: " + e.getMessage());
            try {
                ((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].click();", element);
                System.out.println("Fallback to JavaScript click succeeded.");
            } catch (Exception jsEx) {
                System.out.println("JavaScript click also failed: " + jsEx.getMessage());
                throw jsEx;
            }
        }
    }

    public static void moveToElement(WebElement element) {
        Actions actions = new Actions(HelperClass.getDriver());
        actions.moveToElement(element).perform();
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) HelperClass.getDriver())
            .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    public static void sendKeysElement(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (WebDriverException e) {
            System.out.println("Native sendKeys failed: " + e.getMessage());
            try {
                ((JavascriptExecutor) HelperClass.getDriver())
                    .executeScript("arguments[0].value='" + text + "';", element);
                System.out.println("Fallback to JavaScript sendKeys (value assignment) succeeded.");
            } catch (Exception jsEx) {
                System.out.println("JavaScript sendKeys also failed: " + jsEx.getMessage());
                throw jsEx;
            }
        }
    }
    
}