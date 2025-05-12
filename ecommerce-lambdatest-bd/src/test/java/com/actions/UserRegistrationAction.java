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
    public WebDriver driver;
    private final JavascriptExecutor jsExecutor;

    public UserRegistrationAction() {
        this.registrationLocators = new RegistrationPageLocator();
        PageFactory.initElements(HelperClass.getDriver(), registrationLocators);
        this.actions = new Actions(HelperClass.getDriver());
        driver=HelperClass.getDriver();
        this.wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(30));
        this.jsExecutor = (JavascriptExecutor) HelperClass.getDriver();
    }

    public void clickMyAccounts() {
        waitAndMoveToElement(registrationLocators.myAccount);
    }

//    completed
    public void clickRegister() {
    	 WebElement el = wait.until(ExpectedConditions.
         		elementToBeClickable(registrationLocators.register));
    	 BaseAction.scrollAndClick(el);
    }

    public boolean isRegistrationPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(registrationLocators.registerPageTitle)).isDisplayed();
    }

    public void enterRegistrationDetails(String firstName, String lastName, String email,
                                       String telephone, String password, String confirmPassword) {
        waitAndSendKeys(registrationLocators.firstName, firstName);
        waitAndSendKeys(registrationLocators.lastName, lastName);
        waitAndSendKeys(registrationLocators.registerEmail, email);
        waitAndSendKeys(registrationLocators.telephone, telephone);
        waitAndSendKeys(registrationLocators.password, password);
        waitAndSendKeys(registrationLocators.cofirmpass, confirmPassword);
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

    private void waitAndClick(WebElement element) {
        WebElement el = wait.until(ExpectedConditions.
        		elementToBeClickable(element));
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
        
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       
    }
}