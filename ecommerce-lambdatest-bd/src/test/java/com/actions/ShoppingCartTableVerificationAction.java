package com.actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

        wait.until(ExpectedConditions.visibilityOfAllElements(TableLocator.allProductNames));

        List<WebElement> productNames = TableLocator.allProductNames;
        for (WebElement product : productNames) {
            String name = product.getText().trim();
            if (name.equalsIgnoreCase(expected)) {
                return name;
            }
        }
        return "";
    }
}
