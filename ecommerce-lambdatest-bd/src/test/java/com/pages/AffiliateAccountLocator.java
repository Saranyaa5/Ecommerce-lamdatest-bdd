package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AffiliateAccountLocator {
	@FindBy(xpath="//input[@id='input-email']")
	public WebElement emailId;
	    
	@FindBy(xpath="//input[@id='input-password']")
	public WebElement password;
	    
	@FindBy(xpath="//input[@class='btn btn-primary']")
	public WebElement loginButton;
	    
	@FindBy(xpath="//a[@class='btn btn-primary']")
	public WebElement accContinue;
	
	@FindBy(xpath="//a[@class='d-inline-flex text-decoration-none text-reset flex-column m-3']")
	public WebElement affiliateButton;

	@FindBy(xpath="(//input[@id='input-bank-account-name'])[1]")
	public WebElement accountName;

	@FindBy(xpath="(//input[@id='input-bank-account-number'])[1]")
	public WebElement accountNumber;

	@FindBy(xpath="(//input[@value='Continue'])[1]")
	public WebElement affContinue2;

	@FindBy(xpath="(//div[@class='alert alert-success alert-dismissible'])[1]")
	public WebElement affText;
	
	@FindBy(xpath="//div[@class='card-body text-center text-sm-left']/descendant::a")
	public WebElement registerAffiliate;
	
	@FindBy(xpath="//div[@class='col-sm-10']/descendant::input[@name='cheque']")
	public WebElement payeeName;
	
	@FindBy(xpath="//input[@type='checkbox']")
	public WebElement checkbox;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	public WebElement affContinue1;

	@FindBy(xpath="(//div[@class='alert alert-success alert-dismissible'])[1]")
	public WebElement successMsg;
	
	@FindBy(xpath="(//div[@class='text-danger'])[1]")
	public WebElement errorMsg;
	
	@FindBy(xpath="//div[@class='card-body text-center text-sm-left']//a/following-sibling::a")
	public WebElement trackingAffiliate;
	
	@FindBy(xpath="//div[@class='form-group row']/descendant::div[@class='col-md-10']/textarea[@id='input-code']")
	public WebElement trackingCode;
	
	@FindBy(xpath="//div[@class='buttons clearfix mb-3']/descendant::a")
	public WebElement affContinue3;
	
}