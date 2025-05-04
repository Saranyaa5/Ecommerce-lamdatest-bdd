
package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.HelperClass;

public class ForgotPasswordLocator {

    public ForgotPasswordLocator() {
        PageFactory.initElements(HelperClass.getDriver(), this);
    }

   

    @FindBy(xpath = "//input[@type='password']/following-sibling::a")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//label[@for='input-email']/following-sibling::div/input")
    public WebElement emailInput;

    @FindBy(xpath = "//div[@class='float-left']/following-sibling::div/button")
    public WebElement continueButton;

    @FindBy(xpath = "//div[contains(@class, 'alert-success')]")
    public WebElement successAlert;

    @FindBy(xpath = "//div[contains(@class, 'alert-danger')]")
    public WebElement errorAlert;

}
