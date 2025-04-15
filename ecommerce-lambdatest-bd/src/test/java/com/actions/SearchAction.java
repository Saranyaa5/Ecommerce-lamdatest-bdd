package com.actions;

import com.pages.SearchLocator;
import com.utilities.HelperClass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SearchAction {
    WebDriver driver;
    SearchLocator searchLocator;
    WebDriverWait wait;

    public SearchAction() {
        this.driver = HelperClass.getDriver();
        this.searchLocator = new SearchLocator();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, searchLocator);
    }

    public void enterSearchTerm(String product) {
        wait.until(ExpectedConditions.visibilityOf(searchLocator.searchbox)); // 1. Wait for visibility
        searchLocator.searchbox.sendKeys(Keys.CONTROL + "a");  // 2. Select all text (Ctrl+A)
        searchLocator.searchbox.sendKeys(Keys.BACK_SPACE);     // 3. Delete selected text
        searchLocator.searchbox.sendKeys(product.trim());      // 4. Enter new trimmed text
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchLocator.searchbutton));
        searchLocator.searchbutton.click();
    }

    public boolean areProductsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(searchLocator.productResult));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNoProductMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(searchLocator.noProductMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getNoProductMessageText() {
        return wait.until(ExpectedConditions.visibilityOf(searchLocator.noProductMessage)).getText();
    }
}