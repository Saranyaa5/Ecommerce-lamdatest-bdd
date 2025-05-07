package com.pages;

import java.util.List;

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
    
    @FindBy(xpath="(//div[@class='d-flex align-items-center']/descendant::input[@class='form-control' and @placeholder='Minimum Price'])[2]")
    public WebElement mindragger;
    
    @FindBy(xpath="(//div[@class='d-flex align-items-center']/descendant::input[@class='form-control' and @placeholder='Maximum Price'])[2]")
    public WebElement maxdragger;
    
    @FindBy(xpath="(//div[@class='ui-slider-range ui-corner-all ui-widget-header'])[2]")
    public WebElement dragger;
    
    @FindBy(xpath="(//div[@class='price']/span[@class='price-new'])[1]")
    public WebElement price;
    
    @FindBy(xpath = "//span[@class='ui-slider-handle ui-state-default ui-corner-all'][1]") 
    public WebElement leftSliderHandle;

    @FindBy(xpath = "//span[@class='ui-slider-handle ui-state-default ui-corner-all'][2]") 
    public WebElement rightSliderHandle;
    
    @FindBy(xpath="//div[@id='entry_217832']/descendant::a")
    public WebElement shopbycategory;
    
    @FindBy(xpath="(//li[@class='nav-item']//following-sibling::a[@class='icon-left both nav-link']/div/span)[1]")
    public WebElement components;
    
    @FindBy(xpath="//select[@id='input-limit-212402']")
    public WebElement select;
    
    @FindBy(xpath="//select[@id='input-limit-212402']//option[2]")
    public WebElement option2;
    
    @FindBy(xpath = "//div[@data-grid='product-layout product-grid no-desc col-xl-4 col-lg-4 col-md-4 col-sm-6 col-6']/div[@class='product-layout product-grid no-desc col-xl-4 col-lg-4 col-md-4 col-sm-6 col-6']")
    public List<WebElement> productList;
    
    
    @FindBy(xpath="(//div[@class='carousel-item active']//img)[1]")
    public WebElement firstProduct;	
    
    @FindBy(xpath="//div[@id='entry_212948']/h1")
    public WebElement textQuickView;
    
    @FindBy(xpath="//button[@class='btn btn-cart cart-28']/span")
    public WebElement addToCartButton;
    
    @FindBy(xpath="//*[@id=\"notification-box-top\"]/div[1]")
    public WebElement popupMessage;
    
    @FindBy(xpath="//div[@class='col-md-12']//h1")
    public WebElement textShoppingCart;
    
    @FindBy(xpath="//*[@id=\"notification-box-top\"]/div/div[2]/div[2]/div[2]/a")
    public WebElement checkoutButton;
        
}

