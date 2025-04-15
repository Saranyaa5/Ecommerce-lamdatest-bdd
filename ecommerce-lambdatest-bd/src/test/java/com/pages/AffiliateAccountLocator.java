package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AffiliateAccountLocator {
	
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
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/a/text()")
	public WebElement registerAffiliate;
	
	@FindBy(xpath="//*[@id=\"input-cheque\"]")
	public WebElement payeeName;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]")
	public WebElement checkbox;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	public WebElement affContinue1;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/a[2]/text()")
	public WebElement trackingAffiliate;
	
	@FindBy(xpath="//*[@id=\"input-code\"]")
	public WebElement trackingCode;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/a")
	public WebElement affContinue3;
	
}
