package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPageLocator {

    @FindBy(xpath = "//input[@placeholder='Search' or @name='search']")
    public WebElement searchbox;
    
    @FindBy(xpath = "//button[contains(text(),'Search')]")
    public WebElement searchbutton;
    
    @FindBy(xpath = "//a[contains(@id,'mz-product-grid-image-47-212469')]//div//div[1]/child::img")
    public WebElement productImage;
    
    @FindBy(xpath = "//div[contains(@class,'row mb-3 align-items-end')]/following-sibling::div[@class='buttons d-flex']//a[2]")
    public WebElement CheckoutFromCart;
    
    @FindBy(xpath = "//div[contains(@class,'sticky-top')]/child::div[contains(@class,'mb-5')]//div[1]//div[3]")
    public WebElement guestUser;
    
    @FindBy(xpath = "//div[contains(@class,'sticky-top')]/child::div[contains(@class,'mb-5')]//div/div[2]/child::label")
    public WebElement registerUser;
    
    @FindBy(xpath = "//*[@id='checkout-cart']/table/tbody/tr/td[3]/div/div/button[2]")
    public WebElement removeProduct;
    
    @FindBy(xpath = "//div[contains(@id,'account-detail')]//div[2]//child::input[@id='input-payment-firstname']")
    public WebElement paymentFname;
    
    @FindBy(css = "#account-detail div:nth-of-type(3)>div input")
    public WebElement paymentLname;
    
    @FindBy(css = "#account-detail div:nth-of-type(4)>div input")
    public WebElement paymentEmail;
    
    @FindBy(css = "#account-detail div:nth-of-type(5)>div input")
    public WebElement paymentTelephone;
    
    @FindBy(xpath = "//div[starts-with(@id,'payment-address')]//div[2]//div//input[contains(@id,'input-payment-address-1')]")
    public WebElement paymentAddress;
    
    @FindBy(css = "#payment-address div:nth-of-type(4)>div>input")
    public WebElement paymentCity;
    
    @FindBy(css= "#payment-address div:nth-of-type(5)>div>input")
    public WebElement paymentPostcode;
    
    @FindBy(xpath = "//input[starts-with(@id,'input-payment-password')]")
    public WebElement pass;
    
    @FindBy(xpath = "//input[starts-with(@id,'input-payment-confirm')]")
    public WebElement confirmpass;
    
    @FindBy(xpath = "//*[@id='form-checkout']/div/div[2]/div/div[5]/child::label")
    public WebElement paymentCheckBox;
    
    @FindBy(xpath = "//button[contains(@id,'button-save')]")
    public WebElement continuePayment;
    
    @FindBy(xpath = "//select[@id='input-payment-country']")
    public WebElement countryDropdown;
    
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    public WebElement regionDropdown;
    
    @FindBy(xpath = "//*[@id='form-checkout']/div/div[2]/div/div[5]/child::label")
    public WebElement termsCheckbox;
    
    @FindBy(xpath = "//*[@id='form-checkout']/div/div[2]/div/div[4]/child::label")
    public WebElement PrivacyCheckbox;
    
    @FindBy(xpath = "//*[starts-with(@id,'button-save')]")
    public WebElement continueButton;
    
    @FindBy(xpath = "//*[@id='button-confirm']")
    public WebElement confirmOrder;
    
    @FindBy(xpath = "//*[@id='content']/p[2]")
    public WebElement orderSuccessMessage;
    
    @FindBy(xpath = "//*[@id='form-checkout']/div[1]")
    public WebElement checkBoxWarn;
    
    @FindBy(xpath = "//*[@id='content']/p")
    public WebElement emptyCartMessage;
    
    @FindBy(xpath = "//*[@id='payment-address']/div[1]/div[1]")
    public WebElement ExistingAdd;
    
    @FindBy(xpath = "//*[@id='payment-address']/div[2]/div/label")
    public WebElement newAdd;
    
    @FindBy(xpath = "//*[@id='account-detail']/div[4]/div/div")
    public WebElement duplicateEmail;
}