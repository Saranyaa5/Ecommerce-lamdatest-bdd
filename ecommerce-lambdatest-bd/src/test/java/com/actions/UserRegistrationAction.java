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
        waitAndMoveToElement(registrationLocators.MyAccount);
    }

    public void clickRegister() {
        waitAndClick(registrationLocators.Register);
    }

    public boolean isRegistrationPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(registrationLocators.RegisterPageTitle)).isDisplayed();
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
//      return HelperClass.getDriver().getTitle();
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
//    	return HelperClass.getDriver().getTitle();
        return waitForElementText(registrationLocators.UncheckedError);
    }

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
            return wait.until(ExpectedConditions.stalenessOf(element)).getText();
        } catch (TimeoutException e) {
            return "";
        }
    }

    private void scrollToElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", element);
        
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       
    }
}
