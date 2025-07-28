package com.actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.AddToCartLocator;
import com.pages.EstimateShippingLocator;
import com.pages.UserAccountLocator;
import com.utilities.HelperClass;

public class EstimateShippingACtion {
    AddToCartLocator addTocartLocator;
    EstimateShippingLocator estimateShippingLocator;
    UserAccountLocator userAccountLocator;
    WebDriver driver = HelperClass.getDriver();
    WebDriverWait wait;

    public EstimateShippingACtion() {
        userAccountLocator = new UserAccountLocator();
        PageFactory.initElements(driver, userAccountLocator);

        addTocartLocator = new AddToCartLocator();
        PageFactory.initElements(driver, addTocartLocator);

        estimateShippingLocator = new EstimateShippingLocator();
        PageFactory.initElements(driver, estimateShippingLocator);

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void Shoppingcart() {
        wait.until(ExpectedConditions.elementToBeClickable(addTocartLocator.shoppingCartIcon)).click();
    }

    public void EditCartbutton() {
        wait.until(ExpectedConditions.elementToBeClickable(addTocartLocator.editCart)).click();
    }

    public void EstimateShippingButton() {
        try {
            wait.until(ExpectedConditions.visibilityOf(estimateShippingLocator.estimateShipping));
            wait.until(ExpectedConditions.elementToBeClickable(estimateShippingLocator.estimateShipping)).click();
        } catch (Exception e) {
            System.out.println("Estimate Shipping button not found or not clickable: " + e.getMessage());
        }
    }

    public void EnterDetails() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.countrySelect)).click();
            wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.unitedStates)).click();

            wait.until(ExpectedConditions.visibilityOf(userAccountLocator.state));
            wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.state)).click();

            wait.until(ExpectedConditions.visibilityOf(userAccountLocator.aberdeen));
            wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.aberdeen)).click();
        } catch (Exception e) {
            System.out.println("Error entering shipping details: " + e.getMessage());
        }
    }

    public void GetQuotesButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(estimateShippingLocator.getQuotes)).click();
        } catch (Exception e) {
            System.out.println("Error clicking Get Quotes button: " + e.getMessage());
        }
    }

    public void selectsFlatShippingRate() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(estimateShippingLocator.flatShippingRadioButton)).click();
            wait.until(ExpectedConditions.elementToBeClickable(estimateShippingLocator.applyShippingButton)).click();
        } catch (Exception e) {
            System.out.println("Error selecting flat rate shipping: " + e.getMessage());
        }
    }

    public String EstimateShippingSuccessmsg() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(estimateShippingLocator.estimateShippingSuccessMsg)).getText();
        } catch (Exception e) {
            System.out.println("Shipping success message not found: " + e.getMessage());
            return null;
        }
    }
}
