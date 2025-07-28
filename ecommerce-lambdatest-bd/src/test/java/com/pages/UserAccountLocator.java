package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserAccountLocator {

    // Login
    @FindBy(xpath = "//span[text()='My account']")
    public WebElement myAccountDropdown;

    @FindBy(xpath = "//a[text()='Login']")
    public WebElement loginLink;

    @FindBy(xpath = "//input[@id='input-email']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@id='input-password']")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginButton;

    // Account Info
    @FindBy(xpath = "//a[text()='Edit your account information']")
    public WebElement editAccountLink;

    @FindBy(id = "input-telephone")
    public WebElement telephoneField;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueBtn;

    @FindBy(xpath = "//div[contains(@class, 'alert-success')]")
    public WebElement successMessage;

    // Change Password
    @FindBy(xpath = "//a[text()='Change your password']")
    public WebElement changePasswordLink;

    @FindBy(id = "input-password")
    public WebElement newPassword;

    @FindBy(id = "input-confirm")
    public WebElement confirmPassword;

    // Wish List
    @FindBy(xpath = "//a[text()='Modify your wish list']")
    public WebElement wishListLink;

    @FindBy(xpath = "//a[@data-original-title='Remove']")
    public WebElement removeWishListItem;

    // Newsletter
    @FindBy(xpath = "//a[text()='Subscribe / unsubscribe to newsletter']")
    public WebElement newsletterLink;

    @FindBy(xpath = "//input[@name='newsletter' and @value='1']")
    public WebElement subscribeYesRadio;

    @FindBy(xpath = "//input[@name='newsletter' and @value='0']")
    public WebElement subscribeNoRadio;

    // Address Book
    @FindBy(xpath = "//a[text()='Modify your address book entries']")
    public WebElement addressBookLink;

    @FindBy(xpath = "//a[text()='New Address']")
    public WebElement newAddressBtn;

    @FindBy(id = "input-firstname")
    public WebElement firstNameField;

    @FindBy(id = "input-lastname")
    public WebElement lastNameField;

    @FindBy(id = "input-address-1")
    public WebElement address1Field;

    @FindBy(id = "input-city")
    public WebElement cityField;

    @FindBy(id = "input-postcode")
    public WebElement postCodeField;

    @FindBy(id = "input-country")
    public WebElement countryDropdown;

    @FindBy(id = "input-zone")
    public WebElement regionDropdown;

    @FindBy(xpath = "//input[@name='default' and @value='1']")
    public WebElement defaultAddressYes;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement addressContinueBtn;
}
