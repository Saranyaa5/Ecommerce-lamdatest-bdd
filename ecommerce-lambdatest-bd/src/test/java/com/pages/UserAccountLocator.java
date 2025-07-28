package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserAccountLocator {

    // Edit Info
    @FindBy(xpath = "//a[text()='Edit your account information']")
    public WebElement editInfoLink;

    @FindBy(xpath = "//input[@id='input-firstname']")
    public WebElement getFirstNameField;

    @FindBy(xpath = "//input[@id='input-lastname']")
    public WebElement getLastNameField;

    @FindBy(xpath = "//input[@id='input-email']")
    public WebElement getEmailField;

    @FindBy(xpath = "//input[@id='input-telephone']")
    public WebElement getPhoneField;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement editContinueBtn;

    // Change Password
    @FindBy(xpath = "//a[text()='Change your password']")
    public WebElement changePasswordLink;

    @FindBy(xpath = "//input[@id='input-password']")
    public WebElement newPasswordField;

    @FindBy(xpath = "//input[@id='input-confirm']")
    public WebElement confirmPasswordField;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement changePasswordContinueBtn;

    // Wish List
    @FindBy(xpath = "//a[text()='Modify your wish list']")
    public WebElement wishListLink;

    // Address Book
    @FindBy(xpath = "//a[text()='Modify your address book entries']")
    public WebElement addressBookLink;

    @FindBy(xpath = "//a[text()='New Address']")
    public WebElement newAddressLink;

    @FindBy(xpath = "//input[@id='input-firstname']")
    public WebElement addressFirstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    public WebElement addressLastName;

    @FindBy(xpath = "//input[@id='input-address-1']")
    public WebElement address1;

    @FindBy(xpath = "//input[@id='input-city']")
    public WebElement city;

    @FindBy(xpath = "//input[@id='input-postcode']")
    public WebElement postCode;

    @FindBy(xpath = "//select[@id='input-country']")
    public WebElement countryDropdown;

    @FindBy(xpath = "//select[@id='input-zone']")
    public WebElement stateDropdown;

    @FindBy(xpath = "//input[@name='default' and @value='1']")
    public WebElement defaultAddressYesRadio;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement newAddressContinueBtn;

    // Newsletter
    @FindBy(xpath = "//a[text()='Subscribe / unsubscribe to newsletter']")
    public WebElement newsletterLink;

    @FindBy(xpath = "//input[@name='newsletter' and @value='1']")
    public WebElement subscribeYesRadio;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement newsletterContinueBtn;

    // Common Success Message
    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    public WebElement successAlert;
}
