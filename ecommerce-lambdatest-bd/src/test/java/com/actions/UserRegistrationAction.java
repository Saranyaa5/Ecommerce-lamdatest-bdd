package com.actions;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.RegistrationPageLocator;
import com.utilities.HelperClass;

public class UserRegistrationAction {
    RegistrationPageLocator registrationLocators = null;
    Actions actions;
    
    public UserRegistrationAction() {
        registrationLocators = new RegistrationPageLocator();
        PageFactory.initElements(HelperClass.getDriver(), registrationLocators);
        actions = new Actions(HelperClass.getDriver());
    }
    
    public void clickMyAccounts() {
        actions.moveToElement(registrationLocators.MyAccount).perform();
    }
    
    public void clickRegister() {
        WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(registrationLocators.Register)).click();
    }
    
    public boolean isRegistrationPageDisplayed() {
        return registrationLocators.RegisterPageTitle.isDisplayed();
    }
    
    public void enterRegistrationDetails(String firstName, String lastName, String email, 
                                       String telephone, String password, String confirmPassword) throws InterruptedException {
    	Thread.sleep(2000);
        registrationLocators.FirstName.sendKeys(firstName);
        registrationLocators.LastName.sendKeys(lastName);
        registrationLocators.RegisterEmail.sendKeys(email);
        registrationLocators.Telephone.sendKeys(telephone);
        registrationLocators.password.sendKeys(password);
        registrationLocators.cofirmpass.sendKeys(confirmPassword);
    }
    
    public void agreeToPrivacyPolicy() {
        registrationLocators.PolicyCheckBox.click();
        
     }

    public void submitRegistration() {
        registrationLocators.RegiterSubmitButton.click();
    }
    
    public String RegisterationSuccess() {
    	//System.out.println(registrationLocators.RegistrationSuccessMsg.getText());
    	return registrationLocators.RegistrationSuccessMsg.getText();
    }
    
    public String existingMailError() {
    	return registrationLocators.ExistingEmailError.getText();
    }
    public String emptyFirstNameError() {
    	return registrationLocators.EmptyFirstNameError.getText();
    }
    public String emptyPasswordError() {
    	return registrationLocators.EmptyPasswordError.getText();
    }
    public String passwordMisMathError() {
    	return registrationLocators.PasswordMisMathError.getText();
    }
    public String uncheckedError() {
    	WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOf(registrationLocators.UncheckedError));
    	return registrationLocators.UncheckedError.getText();
    }
    
    
}