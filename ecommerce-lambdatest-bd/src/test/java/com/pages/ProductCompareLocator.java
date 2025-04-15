package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCompareLocator {
	

	@FindBy(xpath="//*[@id=\"entry_216844\"]/button")
	public WebElement productCompare2;
	
	@FindBy(xpath="//*[@id=\"entry_212461\"]/a")
	public WebElement productCompare1;
	
	@FindBy(xpath="//*[@id=\"content\"]/p")
	public WebElement noProducts;
	
	@FindBy(xpath = "//*[@id=\"mz-product-grid-image-41-212469\"]/div/div[1]/img")
    public WebElement product1;
	
	@FindBy(xpath="//*[@id=\"entry_217823\"]/a/span")
	public WebElement comparisionArrow;
	
	@FindBy(xpath="//*[@id=\"content\"]/table/tbody[1]/tr[8]/td[2]")
	public WebElement ComparisionProductDesc;
	
	
}
