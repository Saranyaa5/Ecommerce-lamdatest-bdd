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

    public ForgotPasswordAction() {
        this.forgotPage = new ForgotPasswordLocator();
        this.wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
        this.jsExecutor = (JavascriptExecutor) HelperClass.getDriver();
    }

    public void clickForgotPassword() {
        waitAndClick(forgotPage.forgotPasswordLink);
    }

    public void enterEmail(String email) {
        waitAndClearAndSendKeys(forgotPage.emailInput, email);
    }

    public void clickContinueButton() {
        waitAndClickWithRetry(forgotPage.continueButton);
    }

    public String verifySuccessMessage() {
        return waitForAlertText(forgotPage.successAlert);
    }

    public String verifyErrorMessage() {
        return waitForAlertText(forgotPage.errorAlert);
    }

    // Helper methods with proper waits
    private void waitAndClick(WebElement element) {
        try {
            scrollToElement(element);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (StaleElementReferenceException e) {
            // Retry once if element becomes stale
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }
    }

    private void waitAndClickWithRetry(WebElement element) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                waitAndClick(element);
                return;
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
    }

    private void waitAndClearAndSendKeys(WebElement element, String text) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
        el.clear();
        el.sendKeys(text);
    }

    private String waitForAlertText(WebElement alertElement) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(alertElement)).getText();
        } catch (TimeoutException e) {
            return "";
        }
    }

    private void scrollToElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", element);
        try {
            Thread.sleep(200); // Small pause after scroll
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
