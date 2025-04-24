package com.actions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.ProductCompareLocator;
import com.utilities.HelperClass;

import java.time.Duration;

public class ProductCompareAction {
    private static final Duration DEFAULT_WAIT = Duration.ofSeconds(10);
    private ProductCompareLocator productCompareLocator;
    private WebDriverWait wait;

    public ProductCompareAction() {
        this.productCompareLocator = new ProductCompareLocator();
        PageFactory.initElements(HelperClass.getDriver(), productCompareLocator);
        this.wait = new WebDriverWait(HelperClass.getDriver(), DEFAULT_WAIT);
    }

    public void clickProductCompare() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(productCompareLocator.productCompare1)).click();
        } catch (TimeoutException e) {
            throw new RuntimeException("Product Compare button was not clickable within the timeout period", e);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Product Compare button element not found", e);
        }
    }

    public void comparionButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(productCompareLocator.productCompare2)).click();
        } catch (TimeoutException e) {
            throw new RuntimeException("Comparison button was not clickable within the timeout period", e);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Comparison button element not found", e);
        }
    }

    public boolean getNoProductsToCompareMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(productCompareLocator.noProducts)).isDisplayed();
        } catch (TimeoutException e) {
            throw new RuntimeException("No products message not visible within the timeout period", e);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("No products message element not found", e);
        }
    }

    public void clickProduct() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(productCompareLocator.product1)).click();
        } catch (TimeoutException e) {
            throw new RuntimeException("Product was not clickable within the timeout period", e);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Product element not found", e);
        }
    }

    public void clickComparionArrow() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(productCompareLocator.comparisionArrow)).click();
        } catch (TimeoutException e) {
            throw new RuntimeException("Comparison arrow was not clickable within the timeout period", e);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Comparison arrow element not found", e);
        }
    }

    public String getProductDescription() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(productCompareLocator.ComparisionProductDesc)).getText();
        } catch (TimeoutException e) {
            throw new RuntimeException("Product description not visible within the timeout period", e);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Product description element not found", e);
        }
    }

    public boolean getNoProductsErrorMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(productCompareLocator.noProductsmatchError)).isDisplayed();
        } catch (TimeoutException e) {
            throw new RuntimeException("No products error message not visible within the timeout period", e);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("No products error message element not found", e);
        }
    }
}