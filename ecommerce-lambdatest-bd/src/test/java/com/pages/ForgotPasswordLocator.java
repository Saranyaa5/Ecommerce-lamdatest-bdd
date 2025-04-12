package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.HelperClass;

public class ForgotPasswordLocator {

    public ForgotPasswordLocator() {
        PageFactory.initElements(HelperClass.getDriver(), this);
    }

   

    @FindBy(linkText = "Forgotten Password")
    public WebElement forgotPasswordLink;

    @FindBy(id = "input-email")
    public WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/button")
    public WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"account-login\"]/div[1]")
    public WebElement successAlert;

    @FindBy(xpath = "//*[@id=\"account-forgotten\"]/div[1]")
    public WebElement errorAlert;
}
