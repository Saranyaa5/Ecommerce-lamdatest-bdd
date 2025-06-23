package com.actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utilities.HelperClass;

public class Verify_product_url_action {

    WebDriver driver = HelperClass.getDriver();
    WebDriverWait wait;

    public Verify_product_url_action() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // This method waits until the URL contains the expected keyword, then returns the current URL
    public String getProductUrl(String expectedKeywordInUrl) {
        wait.until(ExpectedConditions.urlContains(expectedKeywordInUrl));
        return driver.getCurrentUrl();
    }
}
