package com.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.utilities.HelperClass;

public class BaseAction {
	public static void clickElement(WebElement element) {
        try {
            ((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
            ((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.out.println("JavaScript click failed: " + e.getMessage());
            throw e;
        }
    }

}
