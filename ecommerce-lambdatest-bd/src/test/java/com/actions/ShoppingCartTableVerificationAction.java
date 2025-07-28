package com.actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.ShoppingCartTableVerificationLocator;
import com.utilities.HelperClass;

public class ShoppingCartTableVerificationAction {

    WebDriver driver = HelperClass.getDriver();
    ShoppingCartTableVerificationLocator tableLocator;
    WebDriverWait wait;

    public ShoppingCartTableVerificationAction() {
        tableLocator = new ShoppingCartTableVerificationLocator();
        PageFactory.initElements(driver, tableLocator);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String verifyProductIsInTable(String expected) {
        try {
            Thread.sleep(1000); // 1-second wait before verification
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        wait.until(ExpectedConditions.visibilityOfAllElements(tableLocator.allProductNames));
        List<WebElement> productNames = tableLocator.allProductNames;

        for (WebElement product : productNames) {
            String name = product.getText().trim();
            if (name.equalsIgnoreCase(expected)) {
                return name;
            }
        }
        return "";
    }
}
