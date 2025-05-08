package com.actions;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.ForgotPasswordLocator;
import com.utilities.HelperClass;

public class ForgotPasswordAction {
    private final ForgotPasswordLocator forgotPage;
    private final WebDriverWait wait;
    private final JavascriptExecutor jsExecutor;

    // Constructor initializing the page locator, WebDriverWait, and JavaScript executor
    public ForgotPasswordAction() {
        this.forgotPage = new ForgotPasswordLocator();
        this.wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
        this.jsExecutor = (JavascriptExecutor) HelperClass.getDriver();
    }

    // Clicks on the "Forgotten Password" link
    public void clickForgotPassword() {
        try {
            waitAndClick(forgotPage.forgotPasswordLink);
        } catch (Exception e) {
            System.out.println("Error clicking Forgot Password link: " + e.getMessage());
        }
    }

    // Enters the email address into the input field
    public void enterEmail(String email) {
        try {
            forgotPage.emailInput.sendKeys(email);
        } catch (Exception e) {
            System.out.println("Error entering email: " + e.getMessage());
        }
    }

    // Clicks the Continue button to submit the request
    public void clickContinueButton() {
        try {
            waitAndClickWithRetry(forgotPage.continueButton);
        } catch (Exception e) {
            System.out.println("Error clicking Continue button: " + e.getMessage());
        }
    }

    // Verifies the success alert message after password reset request
    public String verifySuccessMessage() {
        try {
            return waitForAlertText(forgotPage.successAlert);
        } catch (Exception e) {
            System.out.println("Error verifying success message: " + e.getMessage());
            return "";
        }
    }

    // Verifies the error alert message for invalid/empty email input
    public String verifyErrorMessage() {
        try {
            return waitForAlertText(forgotPage.errorAlert);
        } catch (Exception e) {
            System.out.println("Error verifying error message: " + e.getMessage());
            return "";
        }
    }

    // Helper method to scroll and click element with wait
    private void waitAndClick(WebElement element) {
        try {
            scrollToElement(element);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }
    }

    // Helper method to retry clicking in case of stale element
    private void waitAndClickWithRetry(WebElement element) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitAndClick(element);
                return;
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) {
                    System.out.println("Element remained stale after retries: " + e.getMessage());
                    throw e;
                }
            }
        }
    }

    // Helper method to scroll element into view
    private void scrollToElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Helper method to wait for alert text
    private String waitForAlertText(WebElement alertElement) {
        return wait.until(ExpectedConditions.visibilityOf(alertElement)).getText();
    }
}
