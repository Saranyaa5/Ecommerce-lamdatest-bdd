//
//package com.actions;
//
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//import com.pages.ForgotPasswordLocator;
//import com.utilities.HelperClass;
//
//public class ForgotPasswordAction {
//
//    ForgotPasswordLocator forgotPage = new ForgotPasswordLocator();
//
//    
//  
//
//    public void clickForgotPassword() {
//        forgotPage.forgotPasswordLink.click();
//    }
//
//    public void enterEmail(String email) {
//        forgotPage.emailInput.clear();
//        forgotPage.emailInput.sendKeys(email);
//    }
//
//    public void clickContinueButton() {
//        forgotPage.continueButton.click();
//    }
//
//    public String verifySuccessMessage() {
//return forgotPage.successAlert.getText();
//    }
//
//    public String verifyErrorMessage() {
//       return forgotPage.errorAlert.getText();
//    }
//}
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
            waitAndClearAndSendKeys(forgotPage.emailInput, email);
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
            // Retry once if element becomes stale
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

    // Helper method to clear and enter text into input field
    private void waitAndClearAndSendKeys(WebElement element, String text) {
        try {
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
            el.clear();
            el.sendKeys(text);
        } catch (Exception e) {
            System.out.println("Error in waitAndClearAndSendKeys: " + e.getMessage());
        }
    }

    // Helper method to get the text of alert (success or error)
    private String waitForAlertText(WebElement alertElement) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(alertElement)).getText();
        } catch (TimeoutException e) {
            System.out.println("Alert not visible in time: " + e.getMessage());
            return "";
        }
    }

    // Scrolls to the element using JavaScript
    private void scrollToElement(WebElement element) {
        try {
            jsExecutor.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(200); // Small pause after scroll
        }  catch (Exception e) {
            System.out.println("Error while scrolling to element: " + e.getMessage());
        }
    }
}
