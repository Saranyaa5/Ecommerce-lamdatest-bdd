package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchLocator {
	@FindBy(xpath = "//input[@placeholder='Search' or @name='search']")
    public WebElement searchbox;
    
    @FindBy(xpath = "//button[contains(text(),'Search')]")
    public WebElement searchbutton;
  
    @FindBy(xpath = "//div[contains(@class,'product-layout') or contains(@class,'product-thumb')]")
    public WebElement productResult;
    
    @FindBy(xpath = "//p[contains(text(),'no product that matches') or contains(text(),'no results')]")
    public WebElement noProductMessage;
   
    @FindBy(xpath = "//a[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'macbook')]")
    public WebElement macbookProduct;
    
    @FindBy(xpath = "//a[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'iphone')]")
    public WebElement iphoneProduct;
    
    @FindBy(xpath = "//a[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'imac')]")
    public WebElement imacProduct;
    
    @FindBy(xpath = "//select[@id='input-limit']")
    public WebElement showCountDropdown;
}

