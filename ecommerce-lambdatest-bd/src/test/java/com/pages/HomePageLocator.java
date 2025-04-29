package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocator {
    @FindBy(css="#entry_217964 a:first-of-type")
    public WebElement blk1Shopnow;
 
    @FindBy(id = "entry_217967")
    public WebElement mpowBanner;
    
    @FindBy(xpath = "//*[@id='entry_216816']/h1")
    public WebElement productTitle;
    
    @FindBy(id="entry_217976")
    public WebElement HeadphonesBanner;
    
    @FindBy(xpath="//*[@id='entry_216816']/h1")
    public WebElement headPhones;
    
    @FindBy(css = "a.carousel-control-next[href='#mz-carousel-217960']")
    public WebElement nextButton;
    
    @FindBy(css = "div.carousel-item.active img")
    public WebElement activeBanner;
    
    
}