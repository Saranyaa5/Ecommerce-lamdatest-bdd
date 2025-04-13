package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPageLocator {

	
	
	@FindBy(xpath="//*[@id=\"input-account-guest\"]")
	public WebElement guestUser;
	
	@FindBy(id="input-payment-firstname")
	public WebElement paymentFname;
	
	@FindBy(id="input-payment-lastname")
	public WebElement paymentLname;
	
	@FindBy(id="input-payment-email")
	public WebElement paymentemail;
	
	@FindBy(id="input-payment-telephone")
	public WebElement paymentTelephone;
	
	@FindBy(id="input-payment-company")
	public WebElement paymentcompany;
	
	@FindBy(id="input-payment-address-1")
	public WebElement paymentadd;
	
	@FindBy(id="input-payment-postcode")
	public WebElement paymentpostcode;
	
	@FindBy(id="input-payment-city")
	public WebElement paymentcity;
	
	@FindBy(xpath="//*[@id=\"form-checkout\"]/div/div[2]/div/div[5]/label")
	public WebElement paymentCheckBox;
	
	
	@FindBy(xpath="//button[@id='button-save']")
	public WebElement continuePayment;
	
	 public By shoppingCartIcon = By.cssSelector("div.icon.svg-icon > svg > use[xlink\\:href='#svg6aa26e8645e131bc88c5bc9fbe9d4bbc']");
	    public By checkoutButton = By.xpath("//button[contains(text(), 'Checkout') or contains(., 'Checkout')]");
	    
	    @FindBy(id = "input-payment-country")
	    WebElement countryDropdown;

	    public WebElement getCountryDropdown() {
	        return countryDropdown;
	    }
	    
	   @FindBy(xpath="//button[@id='button-confirm']")
	   public WebElement confirmOrder;
	   
	   @FindBy(xpath="//*[@id=\"content\"]/p[2]")
	   public WebElement sccessPlacedOrderMsg;
	   
	   @FindBy(xpath="//*[@id=\"content\"]/p")
	   public WebElement shoppingCartEmpty;
	
	
	
}
