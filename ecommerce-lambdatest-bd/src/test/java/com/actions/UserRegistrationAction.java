//package com.actions;

//
//import java.time.Duration;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.pages.RegistrationPageLocator;
//import com.utilities.HelperClass;
//
//public class UserRegistrationAction {
//    RegistrationPageLocator registrationLocators = null;
//    Actions actions;
//    
//    public UserRegistrationAction() {
//        registrationLocators = new RegistrationPageLocator();
//        PageFactory.initElements(HelperClass.getDriver(), registrationLocators);
//        actions = new Actions(HelperClass.getDriver());
//    }
//    
//    public void clickMyAccounts() {
//        actions.moveToElement(registrationLocators.MyAccount).perform();
//    }
//    
//    public void clickRegister() {
//        WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(registrationLocators.Register)).click();
//    }
//    
//    public boolean isRegistrationPageDisplayed() {
//        return registrationLocators.RegisterPageTitle.isDisplayed();
//    }
//    
//    public void enterRegistrationDetails(String firstName, String lastName, String email, 
//                                       String telephone, String password, String confirmPassword) {
//        registrationLocators.FirstName.sendKeys(firstName);
//        registrationLocators.LastName.sendKeys(lastName);
//        registrationLocators.RegisterEmail.sendKeys(email);
//        registrationLocators.Telephone.sendKeys(telephone);
//        registrationLocators.password.sendKeys(password);
//        registrationLocators.cofirmpass.sendKeys(confirmPassword);
//    }
//    
//    public void agreeToPrivacyPolicy() {
//        registrationLocators.PolicyCheckBox.click();
//        
//     }
//
//    public void submitRegistration() {
//        registrationLocators.RegiterSubmitButton.click();
//    }
//    
//    public String RegisterationSuccess() {
//    	//System.out.println(registrationLocators.RegistrationSuccessMsg.getText());
//    	return registrationLocators.RegistrationSuccessMsg.getText();
//    }
//    
//    public String existingMailError() {
//    	return registrationLocators.ExistingEmailError.getText();
//    }
//    public String emptyFirstNameError() {
//    	return registrationLocators.EmptyFirstNameError.getText();
//    }
//    public String emptyPasswordError() {
//    	return registrationLocators.EmptyPasswordError.getText();
//    }
//    public String passwordMisMathError() {
//    	return registrationLocators.PasswordMisMathError.getText();
//    }
//    public String uncheckedError() {
//    	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(20));
//	    wait.until(ExpectedConditions.visibilityOf(registrationLocators.UncheckedError));
//    	return registrationLocators.UncheckedError.getText();
//    }
//    
//    
//}

//package com.actions;
//
//import java.time.Duration;
//import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import com.pages.RegistrationPageLocator;
//import com.utilities.HelperClass;
//
//public class UserRegistrationAction {
//    private final RegistrationPageLocator registrationLocators;
//    private final Actions actions;
//    private final WebDriverWait wait;
//    private final JavascriptExecutor jsExecutor;
//
//    public UserRegistrationAction() {
//        this.registrationLocators = new RegistrationPageLocator();
//        PageFactory.initElements(HelperClass.getDriver(), registrationLocators);
//        this.actions = new Actions(HelperClass.getDriver());
//        this.wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
//        this.jsExecutor = (JavascriptExecutor) HelperClass.getDriver();
//    }
//
//    public void clickMyAccounts() {
//        waitAndMoveToElement(registrationLocators.MyAccount);
//    }
//
//    public void clickRegister() {
//        waitAndClick(registrationLocators.Register);
//    }
//
//    public boolean isRegistrationPageDisplayed() {
//        return wait.until(ExpectedConditions.visibilityOf(registrationLocators.RegisterPageTitle))
//                  .isDisplayed();
//    }
//
//    public void enterRegistrationDetails(String firstName, String lastName, String email,
//                                       String telephone, String password, String confirmPassword) {
//        waitAndSendKeys(registrationLocators.FirstName, firstName);
//        waitAndSendKeys(registrationLocators.LastName, lastName);
//        waitAndSendKeys(registrationLocators.RegisterEmail, email);
//        waitAndSendKeys(registrationLocators.Telephone, telephone);
//        waitAndSendKeys(registrationLocators.password, password);
//        waitAndSendKeys(registrationLocators.cofirmpass, confirmPassword);
//    }
//
//    public void agreeToPrivacyPolicy() {
//        waitAndClickWithRetry(registrationLocators.PolicyCheckBox);
//    }
//
//    public void submitRegistration() {
//        waitAndClickWithRetry(registrationLocators.RegiterSubmitButton);
//    }
//
//    public String RegisterationSuccess() {
//        return wait.until(ExpectedConditions.visibilityOf(registrationLocators.RegistrationSuccessMsg))
//                  .getText();
//    }
//
//    public String existingMailError() {
//        return waitForErrorText(registrationLocators.ExistingEmailError);
//    }
//
//    public String emptyFirstNameError() {
//        return waitForErrorText(registrationLocators.EmptyFirstNameError);
//    }
//
//    public String emptyPasswordError() {
//        return waitForErrorText(registrationLocators.EmptyPasswordError);
//    }
//
//    public String passwordMisMathError() {
//        return waitForErrorText(registrationLocators.PasswordMisMathError);
//    }
//
//    public String uncheckedError() {
//        return waitForErrorText(registrationLocators.UncheckedError);
//    }
//
//    // Helper methods with proper waits
//    private void waitAndClick(WebElement element) {
//        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
//    }
//
//    private void waitAndClickWithRetry(WebElement element) {
//        int attempts = 0;
//        while (attempts < 3) {
//            try {
//                scrollToElement(element);
//                waitAndClick(element);
//                return;
//            } catch (StaleElementReferenceException e) {
//                attempts++;
//                if (attempts == 3) throw e;
//            }
//        }
//    }
//
//    private void waitAndSendKeys(WebElement element, String text) {
//        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
//        el.clear();
//        el.sendKeys(text);
//    }
//
//    private void waitAndMoveToElement(WebElement element) {
//        WebElement el = wait.until(ExpectedConditions.visibilityOf(element));
//        actions.moveToElement(el).perform();
//    }
//
//    private String waitForErrorText(WebElement errorElement) {
//        try {
//            return wait.until(ExpectedConditions.visibilityOf(errorElement)).getText();
//        } catch (TimeoutException e) {
//            return "";
//        }
//    }
//
//    private void scrollToElement(WebElement element) {
//        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", element);
//        try {
//            Thread.sleep(300); // Small pause after scroll
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//    }
//}

package com.actions;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pages.RegistrationPageLocator;
import com.utilities.HelperClass;

public class UserRegistrationAction {
    private final RegistrationPageLocator registrationLocators;
    private final Actions actions;
    private final WebDriverWait wait;
    private final JavascriptExecutor jsExecutor;

    public UserRegistrationAction() {
        this.registrationLocators = new RegistrationPageLocator();
        PageFactory.initElements(HelperClass.getDriver(), registrationLocators);
        this.actions = new Actions(HelperClass.getDriver());
        this.wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(30));
        this.jsExecutor = (JavascriptExecutor) HelperClass.getDriver();
    }

    public void clickMyAccounts() {
        waitAndMoveToElement(registrationLocators.MyAccount);
    }

    public void clickRegister() {
        waitAndClick(registrationLocators.Register);
    }

    public boolean isRegistrationPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(registrationLocators.RegisterPageTitle))
                  .isDisplayed();
    }

    public void enterRegistrationDetails(String firstName, String lastName, String email,
                                       String telephone, String password, String confirmPassword) {
        waitAndSendKeys(registrationLocators.FirstName, firstName);
        waitAndSendKeys(registrationLocators.LastName, lastName);
        waitAndSendKeys(registrationLocators.RegisterEmail, email);
        waitAndSendKeys(registrationLocators.Telephone, telephone);
        waitAndSendKeys(registrationLocators.password, password);
        waitAndSendKeys(registrationLocators.cofirmpass, confirmPassword);
    }

    public void agreeToPrivacyPolicy() {
        waitAndClickWithRetry(registrationLocators.PolicyCheckBox);
    }

    public void submitRegistration() {
        waitAndClickWithRetry(registrationLocators.RegiterSubmitButton);
    }

    public String RegisterationSuccess() {
        return waitForElementText(registrationLocators.RegistrationSuccessMsg);
    }

    public String existingMailError() {
        return waitForElementText(registrationLocators.ExistingEmailError);
    }

    public String emptyFirstNameError() {
        return waitForElementText(registrationLocators.EmptyFirstNameError);
    }

    public String emptyPasswordError() {
        return waitForElementText(registrationLocators.EmptyPasswordError);
    }

    public String passwordMisMathError() {
        return waitForElementText(registrationLocators.PasswordMisMathError);
    }

    public String uncheckedError() {
        return waitForElementText(registrationLocators.UncheckedError);
    }

    // Helper methods with proper waits
    private void waitAndClick(WebElement element) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
        el.click();
    }

    private void waitAndClickWithRetry(WebElement element) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                scrollToElement(element);
                waitAndClick(element);
                return;
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
    }

    private void waitAndSendKeys(WebElement element, String text) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(element));
        el.clear();
        el.sendKeys(text);
    }

    private void waitAndMoveToElement(WebElement element) {
        WebElement el = wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(el).perform();
    }

    private String waitForElementText(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).getText();
        } catch (TimeoutException e) {
            return "";
        }
    }

    private void scrollToElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", element);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
