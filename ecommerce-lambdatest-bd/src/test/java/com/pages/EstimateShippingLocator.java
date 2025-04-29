package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EstimateShippingLocator {

	@FindBy(xpath = "//div[@id=\"collapse-shipping\"]/preceding-sibling::h5")
    public WebElement EstimateShipping;

	@FindBy(xpath = "//button[@id='button-quote']")
    public WebElement getquotes;
	
	@FindBy(xpath = "//div[@class='form-check']/label/input")
    public WebElement flatshippingradiobutton;
	
	@FindBy(xpath = "//button[@id='button-shipping']")
    public WebElement applyshippingbutton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    public WebElement EstimateShippingSuccessMsg;
	
	
}
