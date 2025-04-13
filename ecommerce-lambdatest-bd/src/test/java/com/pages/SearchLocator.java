package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchLocator {
    // Search Box
    @FindBy(xpath = "//input[@placeholder='Search' or @name='search']")
    public WebElement searchbox;
    
    // Search Button
    @FindBy(xpath = "//button[contains(text(),'Search')]")
    public WebElement searchbutton;
    
    // Product Results
    @FindBy(xpath = "//div[contains(@class,'product-layout') or contains(@class,'product-thumb')]")
    public WebElement productResult;
    
    // No Products Message
    @FindBy(xpath = "//p[contains(text(),'no product that matches') or contains(text(),'no results')]")
    public WebElement noProductMessage;
    
    // Specific Product Locators (for verification)
    @FindBy(xpath = "//a[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'macbook')]")
    public WebElement macbookProduct;
    
    @FindBy(xpath = "//a[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'iphone')]")
    public WebElement iphoneProduct;
    
    @FindBy(xpath = "//a[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'imac')]")
    public WebElement imacProduct;
    
    // Show Count Dropdown (if needed)
    @FindBy(xpath = "//select[@id='input-limit']")
    public WebElement showCountDropdown;
}