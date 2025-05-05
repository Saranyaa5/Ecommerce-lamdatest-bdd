package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPageLocator {

    @FindBy(xpath = "//input[@placeholder='Search' or @name='search']")
    public WebElement searchbox;
    
    @FindBy(xpath = "//button[contains(text(),'Search')]")
    public WebElement searchbutton;
    
    @FindBy(xpath = "//a[starts-with(@id,'mz-product-grid-image')]/div/div[1]/img")
    public WebElement productImage;

    
    @FindBy(xpath = "//*[@id='content']//a[contains(text(),'Checkout')]")
    public WebElement CheckoutFromCart;

    
    @FindBy(xpath = "//*[@id='form-checkout']//label[contains(text(),'Guest')]")
    public WebElement guestUser;
    
    @FindBy(xpath = "//*[@id='form-checkout']//label[contains(text(),'Register')]")
    public WebElement registerUser;
    
    @FindBy(xpath = "//*[@id='checkout-cart']//button[@data-original-title='Remove']")
    public WebElement removeProduct;
    
    @FindBy(xpath = "//label[contains(text(),'First Name') and not(contains(@for,'shipping'))]/following-sibling::div/input")
    public WebElement paymentFname;
    
    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    public WebElement paymentLname;


    @FindBy(xpath = "//label[contains(text(),'E-Mail')]/following-sibling::div//input")
    public WebElement paymentEmail;

    @FindBy(xpath = "//label[contains(text(),'Telephone')]/following-sibling::div//input")
    public WebElement paymentTelephone;

    @FindBy(xpath = "//label[contains(text(),'Address 1')]/following-sibling::div//input")
    public WebElement paymentAddress;

    @FindBy(xpath = "//label[contains(text(),'City')]/following-sibling::div//input")
    public WebElement paymentCity;

    @FindBy(xpath = "//label[contains(text(),'Post Code')]/following-sibling::div//input")
    public WebElement paymentPostcode;
    
    @FindBy(xpath = "//input[contains(@id,'input-payment-password')]")
    public WebElement pass;

    @FindBy(xpath = "//input[contains(@id,'input-payment-confirm')]")
    public WebElement confirmpass;
    
    @FindBy(xpath = "//*[@id='form-checkout']//label[contains(text(),'I have read and agree')]")
    public WebElement paymentCheckBox;

    @FindBy(xpath = "//button[starts-with(@id,'button-save')]")
    public WebElement continuePayment;

    @FindBy(xpath = "//select[starts-with(@id,'input-payment-country')]")
    public WebElement countryDropdown;

    @FindBy(xpath = "//select[contains(@id,'input-payment-zone')]")
    public WebElement regionDropdown;

    @FindBy(xpath = "//*[@id='form-checkout']//label[contains(text(),'Terms') or contains(text(),'terms')]")
    public WebElement termsCheckbox;

    @FindBy(xpath = "//*[@id='form-checkout']//label[contains(text(),'Privacy')]")
    public WebElement PrivacyCheckbox;

    @FindBy(xpath = "//button[starts-with(@id,'button-save')]")
    public WebElement continueButton;

    @FindBy(xpath = "//button[starts-with(@id,'button-confirm')]")
    public WebElement confirmOrder;

    @FindBy(xpath = "//*[@id='content']//p[contains(text(),'Your order has')]")
    public WebElement orderSuccessMessage;

    @FindBy(xpath = "//*[@id='form-checkout']//div[contains(@class,'alert') and contains(text(),'checkbox')]")
    public WebElement checkBoxWarn;

    @FindBy(xpath = "//*[@id='content']//p[contains(text(),'empty') or contains(text(),'Your shopping cart')]")
    public WebElement emptyCartMessage;

    @FindBy(xpath = "//*[@id='payment-address']//div[contains(@class,'radio')][1]")
    public WebElement ExistingAdd;

    @FindBy(xpath = "//*[@id='payment-address']//label[contains(text(),'New') or contains(text(),'new')]")
    public WebElement newAdd;

    @FindBy(xpath = "//*[@id='account-detail']//div[contains(text(),'already registered') or contains(text(),'already exists')]")
    public WebElement duplicateEmail;

}