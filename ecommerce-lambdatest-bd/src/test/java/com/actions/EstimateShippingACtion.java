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
        addTocartLocator.shoppingCartIcon.click();
    }

    public void EditCartbutton() {
        addTocartLocator.editCart.click();
    }

    public void EstimateShippingButton() {
        estimateShippingLocator.estimateShipping.click();
    }

    public void EnterDetails() {
        // Click country dropdown and select United States
        wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.countrySelect)).click();
        wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.unitedStates)).click();

        // Wait until state dropdown is visible and clickable
        wait.until(ExpectedConditions.visibilityOf(userAccountLocator.state));
        wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.state)).click();

        // Wait until Abeerdan is visible and clickable
        wait.until(ExpectedConditions.visibilityOf(userAccountLocator.aberdeen));
        wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.aberdeen)).click();
    }

    public void GetQuotesButton() {
        estimateShippingLocator.getQuotes.click();
    }

    public void selectsFlatShippingRate() {
        estimateShippingLocator.flatShippingRadioButton.click();
        estimateShippingLocator.applyShippingButton.click();
    }

    public String EstimateShippingSuccessmsg() {
        return estimateShippingLocator.estimateShippingSuccessMsg.getText();
    }
}
