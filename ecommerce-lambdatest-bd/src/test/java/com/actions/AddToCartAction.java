package com.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.AddToCartLocator;
import com.utilities.HelperClass;

public class AddToCartAction {

    WebDriver driver = HelperClass.getDriver();
    AddToCartLocator cartLocator;
    WebDriverWait wait;

    public AddToCartAction() {
        cartLocator = new AddToCartLocator();
        PageFactory.initElements(driver, cartLocator);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickOnCategory() {
        try {
            cartLocator.category.click();
            wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(cartLocator.phonesCategory)
            )).click();
        } catch (Exception e) {
            System.out.println("Error clicking category: " + e.getMessage());
        }
    }

    public void selectProduct() {
        try {
            wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(cartLocator.ipodNano)
            )).click();
        } catch (Exception e) {
            System.out.println("Error selecting product: " + e.getMessage());
        }
    }

    public void clickAddToCart() {
        try {
            WebElement button = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(cartLocator.addToCartButton)
            ));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

            try {
                button.click();
            } catch (org.openqa.selenium.ElementClickInterceptedException e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
            }

        } catch (Exception e) {
            System.out.println("Error adding to cart: " + e.getMessage());
        }
    }

    public String getSuccessMessage() {
        try {
            return wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOf(cartLocator.successMsg)
            )).getText().trim().replaceAll("\\s+", " ").replace(" !", "!");
        } catch (Exception e) {
            System.out.println("Error fetching success message: " + e.getMessage());
            return "";
        }
    }

    public void viewShoppingCart() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast-header")));
        } catch (Exception e) {
            System.out.println("Toast already disappeared or not found: " + e.getMessage());
        }

        try {
            wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(cartLocator.shoppingCartIcon)
            )).click();

            wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(cartLocator.editCart)
            )).click();
        } catch (Exception e) {
            System.out.println("Error viewing shopping cart: " + e.getMessage());
        }
    }

    public void removeiPodNano() {
        try {
            wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(cartLocator.remove)
            )).click();
        } catch (Exception e) {
            System.out.println("Error removing item: " + e.getMessage());
        }
    }

    public String getEmptyCartMessage() {
        try {
            return wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOf(cartLocator.noItem)
            )).getText();
        } catch (Exception e) {
            System.out.println("Error fetching empty cart message: " + e.getMessage());
            return "";
        }
    }

    public void setQuantity() {
        try {
            WebElement qtyButton = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(cartLocator.quantity)
            ));
            for (int i = 0; i < 2; i++) {
                qtyButton.click();
            }
        } catch (Exception e) {
            System.out.println("Error setting quantity: " + e.getMessage());
        }
    }

    public String ProductQuantity() {
        try {
            return wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOf(cartLocator.noOfItems)
            )).getText();
        } catch (Exception e) {
            System.out.println("Error fetching product quantity: " + e.getMessage());
            return "";
        }
    }

    public void selectAppleCinema() {
        try {
            wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(cartLocator.appleCinema)
            )).click();
        } catch (Exception e) {
            System.out.println("Error selecting Apple Cinema: " + e.getMessage());
        }
    }

    public String getSizeReq() {
        try {
            return wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOf(cartLocator.sizeReq)
            )).getText();
        } catch (Exception e) {
            System.out.println("Error fetching size required message: " + e.getMessage());
            return "";
        }
    }
}