package com.actions;

import java.time.Duration;



import org.openqa.selenium.*;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.pages.RegistrationPageLocator;
import com.utilities.HelperClass;

public class UserRegistrationAction {
    private final RegistrationPageLocator registrationLocators;

    private final WebDriverWait wait;
    public WebDriver driver;
 

    public UserRegistrationAction() {
        this.registrationLocators = new RegistrationPageLocator();
        PageFactory.initElements(HelperClass.getDriver(), registrationLocators);
        driver=HelperClass.getDriver();
        this.wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(30));
        
    }

    public void clickMyAccounts() {
    	wait.until(ExpectedConditions.visibilityOf(registrationLocators.myAccount));
    	BaseAction.moveToElement(registrationLocators.myAccount);
    }

    public void clickRegister() {
    	 wait.until(ExpectedConditions.
         		elementToBeClickable(registrationLocators.register));
    	 BaseAction.clickElement(registrationLocators.register);
    }

    public boolean isRegistrationPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(registrationLocators.registerPageTitle)).isDisplayed();
    }

    public void enterRegistrationDetails(String firstName, String lastName, String email,
                                       String telephone, String password, String confirmPassword) {
    	wait.until(ExpectedConditions.elementToBeClickable(registrationLocators.firstName));
    	 BaseAction.sendKeysElement(registrationLocators.firstName,firstName);
    	 wait.until(ExpectedConditions.elementToBeClickable(registrationLocators.lastName));
    	 BaseAction.sendKeysElement(registrationLocators. lastName, lastName);
    	 wait.until(ExpectedConditions.elementToBeClickable(registrationLocators.registerEmail));
    	 BaseAction.sendKeysElement(registrationLocators.registerEmail, email);
    	 wait.until(ExpectedConditions.elementToBeClickable(registrationLocators.telephone));
    	 BaseAction.sendKeysElement(registrationLocators.telephone, telephone);
    	 wait.until(ExpectedConditions.elementToBeClickable(registrationLocators.password));
    	 BaseAction.sendKeysElement(registrationLocators.password,password);
    	 wait.until(ExpectedConditions.elementToBeClickable(registrationLocators.cofirmpass));
    	 BaseAction.sendKeysElement(registrationLocators.cofirmpass,confirmPassword);
        
    }

    public void agreeToPrivacyPolicy() {
        waitAndClickWithRetry(registrationLocators.policyCheckBox);
    }

    public void submitRegistration() {
        waitAndClickWithRetry(registrationLocators.regiterSubmitButton);
    }

    public String RegisterationSuccess() {
        return waitForElementText(registrationLocators.registrationSuccessMsg);
    }

    public String existingMailError() {
        return waitForElementText(registrationLocators.existingEmailError);
    }

    public String emptyFirstNameError() {
        return waitForElementText(registrationLocators.emptyFirstNameError);
    }

    public String emptyPasswordError() {
        return waitForElementText(registrationLocators.emptyPasswordError);
    }

    public String passwordMisMathError() {
        return waitForElementText(registrationLocators.passwordMisMathError);
    }

    public String uncheckedError() {
        return waitForElementText(registrationLocators.uncheckedError);
    }


    private void waitAndClickWithRetry(WebElement element) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                BaseAction.scrollToElement(element);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                BaseAction.clickElement(element);
                return;
            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
    }

    


    private String waitForElementText(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).getText();
        } catch (TimeoutException e) {
            return "";
        }
    }

}