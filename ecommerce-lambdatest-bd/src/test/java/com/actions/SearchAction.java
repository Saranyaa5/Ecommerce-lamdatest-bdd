package com.actions;

import com.pages.SearchLocator;
import com.utilities.HelperClass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
/*

public class SearchAction {

    WebDriver driver;
    SearchLocator searchLocator;

    public SearchAction() {
        this.driver = HelperClass.getDriver();
        this.searchLocator = new SearchLocator();
        PageFactory.initElements(driver, searchLocator);
    }

    public void searchProduct(String product) {
        searchLocator.searchbox.clear();
        searchLocator.searchbox.sendKeys(product);
        searchLocator.searchbutton.click();
    }

    public String getSearchResultText(String expected) {
        try {
            if (expected.equalsIgnoreCase("MacBook") && searchLocator.macbook.isDisplayed()) {
                return searchLocator.macbook.getText();
            } else if (expected.equalsIgnoreCase("iPhone") && searchLocator.iphone.isDisplayed()) {
                return searchLocator.iphone.getText();
            } else if (expected.equalsIgnoreCase("iMac") && searchLocator.imac.isDisplayed()) {
                return searchLocator.imac.getText();
            } else if (expected.equalsIgnoreCase("HTC Touch HD") && searchLocator.htc.isDisplayed()) {
                return searchLocator.htc.getText();
            } else if (expected.contains("There is no product that matches the search criteria.") && searchLocator.errormessage.isDisplayed()) {
                return searchLocator.errormessage.getText();
            }
        } catch (Exception e) {
            return "No element found";
        }
        return "No element matched";
    }
}
*/
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
        wait.until(ExpectedConditions.visibilityOf(searchLocator.searchbox));
        searchLocator.searchbox.sendKeys(Keys.CONTROL + "a");  
        searchLocator.searchbox.sendKeys(Keys.BACK_SPACE);   
        searchLocator.searchbox.sendKeys(product.trim());
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
    
    public void enterMinimumValue(String min) {
        wait.until(ExpectedConditions.visibilityOf(searchLocator.mindragger)).clear();
        searchLocator.mindragger.sendKeys(min);
    }

    public void enterMaximumValue(String max) {
        wait.until(ExpectedConditions.visibilityOf(searchLocator.maxdragger)).clear();
        searchLocator.maxdragger.sendKeys(max);
    }

    public boolean isPriceWithinRange(int min, int max) {
        try {
            wait.until(ExpectedConditions.visibilityOf(searchLocator.price));
            String priceText = searchLocator.price.getText().replaceAll("[^0-9]", "");
            int priceValue = Integer.parseInt(priceText);
            return priceValue >= min && priceValue <= max;
        } catch (Exception e) {
            return false;
        }
    }

}

