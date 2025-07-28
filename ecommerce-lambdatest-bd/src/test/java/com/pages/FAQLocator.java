package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FAQLocator {

	@FindBy(xpath = "(//div[contains(@class, 'collapse')]/preceding-sibling::h5)[1]")
	public WebElement changeshippingaddress;

	@FindBy(xpath = "(//div[@itemprop='text']/p)[1]")
	public WebElement changeshippingaddressmsg;



	
}