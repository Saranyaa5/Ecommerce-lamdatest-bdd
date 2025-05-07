package com.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.ProductCompareLocator;
import com.utilities.HelperClass;

public class ProductCompareAction {
    private static final Duration DEFAULT_WAIT = Duration.ofSeconds(15); 
    private ProductCompareLocator productCompareLocator;
    private WebDriverWait wait;

    public ProductCompareAction() {
        this.productCompareLocator = new ProductCompareLocator();
        PageFactory.initElements(HelperClass.getDriver(), productCompareLocator);
        this.wait = new WebDriverWait(HelperClass.getDriver(), DEFAULT_WAIT);
    }

    private WebElement waitForElementToBeClickable(WebElement element) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException | NoSuchElementException e) {
            throw new RuntimeException("Element was not clickable within the timeout period", e);
        }
    }

    private WebElement waitForElementToBeVisible(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException | NoSuchElementException e) {
            throw new RuntimeException("Element was not visible within the timeout period", e);
        }
    }

    public void closeToastIfVisible() {
        try {
            WebElement toast = HelperClass.getDriver().findElement(By.cssSelector(".toast-header"));
            if (toast.isDisplayed()) {
                WebElement closeButton = toast.findElement(By.cssSelector(".close"));
                closeButton.click();
            }
        } catch (NoSuchElementException e) {
            
        }
    }

    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickProductCompare() {
        closeToastIfVisible();  
        WebElement element = waitForElementToBeClickable(productCompareLocator.productCompare1);
        scrollToElement(element); // Scroll the element into view
        element.click();
    }

    // Click the comparison button
    public void comparionButton() {
        closeToastIfVisible();  // Ensure no toast is blocking the element
        WebElement element = waitForElementToBeClickable(productCompareLocator.productCompare2);
        scrollToElement(element); // Scroll the element into view
        element.click();
    }

    // Get the "No Products to Compare" message
    public boolean getNoProductsToCompareMessage() {
        WebElement element = waitForElementToBeVisible(productCompareLocator.noProducts);
        return element.isDisplayed();
    }

    // Click a product for comparison
    public void clickProduct() {
        closeToastIfVisible();  
        WebElement element = waitForElementToBeClickable(productCompareLocator.product1);
        scrollToElement(element); 
        element.click();
    }

//    public void clickComparionArrow() {
//        closeToastIfVisible();  
//        WebElement element = waitForElementToBeClickable(productCompareLocator.comparisionArrow);
//        scrollToElement(element); 
//        element.click();
//    }
    
    public void clickComparionArrow() {
        closeToastIfVisible();  
        
        WebElement element = waitForElementToBeClickable(productCompareLocator.comparisionArrow);
        scrollToElement(element); 
        
        try {
            
            ((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].click();", element);
        } catch (ElementClickInterceptedException e) {
            System.out.println("Standard click intercepted, using JavaScriptExecutor: " + e.getMessage());
            
        }
    }


    public String getProductDescription() {
        WebElement element = waitForElementToBeVisible(productCompareLocator.ComparisionProductDesc);
        return element.getText();
    }

    public boolean getNoProductsErrorMessage() {
        WebElement element = waitForElementToBeVisible(productCompareLocator.noProductsmatchError);
        return element.isDisplayed();
    }
}
