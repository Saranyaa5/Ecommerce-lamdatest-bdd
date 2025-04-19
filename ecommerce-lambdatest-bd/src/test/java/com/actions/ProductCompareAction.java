package com.actions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
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

    public void clickProductCompare() {
        WebElement element = waitForElementToBeClickable(productCompareLocator.productCompare1);
        element.click();
    }

    public void comparionButton() {
        WebElement element = waitForElementToBeClickable(productCompareLocator.productCompare2);
        element.click();
    }

    public boolean getNoProductsToCompareMessage() {
        WebElement element = waitForElementToBeVisible(productCompareLocator.noProducts);
        return element.isDisplayed();
    }

    public void clickProduct() {
        WebElement element = waitForElementToBeClickable(productCompareLocator.product1);
        element.click();
    }

    public void clickComparionArrow() {
        WebElement element = waitForElementToBeClickable(productCompareLocator.comparisionArrow);
        element.click();
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
