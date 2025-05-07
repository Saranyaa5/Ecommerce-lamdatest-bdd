package com.actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.ShoppingCartTableVerificationLocator;
import com.utilities.HelperClass;
public class ShoppingCartTableVerificationAction {
    WebDriver driver = HelperClass.getDriver();
    ShoppingCartTableVerificationLocator TableLocator;
    WebDriverWait wait;
    public ShoppingCartTableVerificationAction() {
        TableLocator = new ShoppingCartTableVerificationLocator();
        PageFactory.initElements(driver, TableLocator);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public String verifyProductIsInTable(String expected) {  
        List<WebElement> productNames = TableLocator.allProductNames;
    
        for (int i = 0; i < productNames.size(); i++) {
            String name = productNames.get(i).getText().trim();
            if (name.equalsIgnoreCase(expected)) {
                return productNames.get(i).getText(); 
            }
        }
        return "";
    }
}
