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
        cartLocator.Category.click();
        wait.until(ExpectedConditions.elementToBeClickable(cartLocator.phonesCategory)).click();
    }

    public void selectProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLocator.IpodNano)).click();
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLocator.addToCartButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", cartLocator.addToCartButton);

        try {
            cartLocator.addToCartButton.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartLocator.addToCartButton);
        }
    }


    public String getSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOf(cartLocator.successMsg))
                   .getText().trim().replaceAll("\\s+", " ").replace(" !", "!");
    }

    public void viewShoppingCart() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast-header")));
        } catch (Exception e) {
            System.out.println("Toast already disappeared or not found: " + e.getMessage());
        }

        wait.until(ExpectedConditions.elementToBeClickable(cartLocator.shoppingCartIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(cartLocator.editCart)).click();
    }

    public void removeiPodNano() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLocator.remove)).click();
    }

    public String getEmptyCartMessage() {
        return wait.until(ExpectedConditions.visibilityOf(cartLocator.noItem)).getText();
    }

    public void setQuantity() {
        WebElement qtyButton = wait.until(ExpectedConditions.elementToBeClickable(cartLocator.quantity));
        for (int i = 0; i < 2; i++) {
            qtyButton.click();
        }
    }

    public String ProductQuantity() {
        return wait.until(ExpectedConditions.visibilityOf(cartLocator.noOfItems)).getText();
    }

    public void selectAppleCinema() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLocator.AppleCinema)).click();
    }

    public String getSizeReq() {
        return wait.until(ExpectedConditions.visibilityOf(cartLocator.SizeReq)).getText();
    }
}
