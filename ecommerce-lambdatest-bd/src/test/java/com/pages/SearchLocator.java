package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchLocator {
/*
@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div[2]/input")
public WebElement searchbox;

@FindBy(xpath="//button[text()='Search']")
public WebElement searchbutton;

@FindBy(xpath="//*[@id=\"input-limit-212463\"]")
public WebElement showcount;




@FindBy(xpath="(//a[@class='text-ellipsis-2'][text()='MacBook'])[1]")
public WebElement macbook;

@FindBy(xpath="(//a[@class='text-ellipsis-2'][text()='iPhone'])[1]")
public WebElement iphone;

@FindBy(xpath="(//a[@class='text-ellipsis-2'][text()='iMac'])[1]")
public WebElement imac;

@FindBy(xpath="(//a[text()='HTC Touch HD'])[1]")
public WebElement htc;

@FindBy(xpath="(//p[contains(text(),'There is no product that matches the search criter')])[1]")
public WebElement errormessage;


}
*/
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

