package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPageLocator {

	 @FindBy(xpath = "//input[@placeholder='Search' or @name='search']")
	    public WebElement searchbox;
	    
	    // Search Button
	    @FindBy(xpath = "//button[contains(text(),'Search')]")
	    public WebElement searchbutton;
	    
	@FindBy(xpath="//*[@id=\"mz-product-grid-image-47-212469\"]/div/div[1]/img")
	public WebElement productImage;
	
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/a[2]")
	public WebElement CheckoutFromCart;
	
	@FindBy(xpath="//*[@id=\"form-checkout\"]/div/div[1]/div/div[1]/div/div[3]")
	public WebElement guestUser;
	
	@FindBy(xpath="//*[@id=\"form-checkout\"]/div/div[1]/div/div[1]/div/div[2]/label")
	public WebElement registerUser;
	
	@FindBy(xpath="//*[@id=\"checkout-cart\"]/table/tbody/tr/td[3]/div/div/button[2]")
	public WebElement removeProduct;
	
	@FindBy(xpath = "//input[@id='input-payment-firstname']")
    public WebElement paymentFname;
    
    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    public WebElement paymentLname;
    
    @FindBy(xpath = "//input[@id='input-payment-email']")
    public WebElement paymentEmail;
    
    @FindBy(xpath = "//input[@id='input-payment-telephone']")
    public WebElement paymentTelephone;
    
    // Address Information Section
    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    public WebElement paymentAddress;
    
    @FindBy(xpath = "//input[@id='input-payment-city']")
    public WebElement paymentCity;
    
    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    public WebElement paymentPostcode;
    
    @FindBy(xpath="//input[@id='input-payment-password']")
    public WebElement pass;
    
    @FindBy(xpath="//input[@id='input-payment-confirm']")
    public WebElement confirmpass;
	
	@FindBy(xpath="//*[@id=\"form-checkout\"]/div/div[2]/div/div[5]/label")
	public WebElement paymentCheckBox;
	
	
	@FindBy(xpath="//button[@id='button-save']")
	public WebElement continuePayment;
	// Dropdown Elements
    @FindBy(xpath = "//select[@id='input-payment-country']")
    public WebElement countryDropdown;
    
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    public WebElement regionDropdown;
    
    @FindBy(xpath = "//*[@id=\"form-checkout\"]/div/div[2]/div/div[5]/label")
    public WebElement termsCheckbox;
    
    @FindBy(xpath="//*[@id=\"form-checkout\"]/div/div[2]/div/div[4]/label")
    public WebElement PrivacyCheckbox;
    
    @FindBy(xpath="//*[@id='button-save']")
    public WebElement continueButton;
    
    @FindBy(xpath="//*[@id=\"button-confirm\"]")
    public WebElement confirmOrder;
    
    @FindBy(xpath="//*[@id=\"content\"]/p[2]")
    public WebElement orderSuccessMessage;
    
    @FindBy(xpath="//*[@id=\"form-checkout\"]/div[1]")
    public WebElement checkBoxWarn;
    
    @FindBy(xpath="//*[@id=\"content\"]/p")
    public WebElement emptyCartMessage;
    
    @FindBy(xpath="//*[@id=\"payment-address\"]/div[1]/div[1]")
    public WebElement ExistingAdd;
    
    @FindBy(xpath="//*[@id=\"payment-address\"]/div[2]/div/label")
    public WebElement newAdd;
    
    @FindBy(xpath="//*[@id=\"account-detail\"]/div[4]/div/div")
    public WebElement duplicateEmail;
  //*[@id="payment-address"]/div[2]/div
	
  //*[@id="payment-address"]/div[2]/div/label
}
