package com.actions;

import java.time.Duration;

import org.openqa.selenium.By;
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
    private static final Duration DEFAULT_WAIT = Duration.ofSeconds(15); // Increased wait time
    private ProductCompareLocator productCompareLocator;
    private WebDriverWait wait;

    public ProductCompareAction() {
        this.productCompareLocator = new ProductCompareLocator();
        PageFactory.initElements(HelperClass.getDriver(), productCompareLocator);
        this.wait = new WebDriverWait(HelperClass.getDriver(), DEFAULT_WAIT);
    }

    // Wait for element to be clickable
    private WebElement waitForElementToBeClickable(WebElement element) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException | NoSuchElementException e) {
            throw new RuntimeException("Element was not clickable within the timeout period", e);
        }
    }

    // Wait for element to be visible
    private WebElement waitForElementToBeVisible(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException | NoSuchElementException e) {
            throw new RuntimeException("Element was not visible within the timeout period", e);
        }
    }

    // Close the toast or any overlay element that might be blocking the clickable element
    public void closeToastIfVisible() {
        try {
            WebElement toast = HelperClass.getDriver().findElement(By.cssSelector(".toast-header"));
            if (toast.isDisplayed()) {
                WebElement closeButton = toast.findElement(By.cssSelector(".close"));
                closeButton.click();
            }
        } catch (NoSuchElementException e) {
            // Toast not found, no action needed
        }
    }

    // Scroll the element into view before clicking it
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) HelperClass.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Click the Product Compare button
    public void clickProductCompare() {
        closeToastIfVisible();  // Ensure no toast is blocking the element
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
        closeToastIfVisible();  // Ensure no toast is blocking the element
        WebElement element = waitForElementToBeClickable(productCompareLocator.product1);
        scrollToElement(element); // Scroll the element into view
        element.click();
    }

    // Click the comparison arrow
    public void clickComparionArrow() {
        closeToastIfVisible();  // Ensure no toast is blocking the element
        WebElement element = waitForElementToBeClickable(productCompareLocator.comparisionArrow);
        scrollToElement(element); // Scroll the element into view
        element.click();
    }

    // Get the product description text
    public String getProductDescription() {
        WebElement element = waitForElementToBeVisible(productCompareLocator.ComparisionProductDesc);
        return element.getText();
    }

    // Get the error message when no products match
    public boolean getNoProductsErrorMessage() {
        WebElement element = waitForElementToBeVisible(productCompareLocator.noProductsmatchError);
        return element.isDisplayed();
    }
}
