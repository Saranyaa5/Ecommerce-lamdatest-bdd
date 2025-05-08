package com.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocator {
	
	
	@FindBy(xpath = "//*[contains(@class,'nav-item')]//a")
	public List<WebElement> allLinks;
	
    @FindBy(css="#entry_217964 a:first-of-type")
    public WebElement blk1Shopnow;
 
    @FindBy(id = "entry_217967")
    public WebElement mpowBanner;
    
    @FindBy(xpath = "//*[@id='entry_216816']/h1")
    public WebElement productTitle;
    
    @FindBy(id="entry_217976")
    public WebElement headphonesBanner;
    
    @FindBy(xpath="//*[@id='entry_216816']/h1")
    public WebElement headPhones;
    
    @FindBy(css = "a.carousel-control-next[href='#mz-carousel-217960']")
    public WebElement nextButton;
    
    @FindBy(css = "div.carousel-item.active img")
    public WebElement activeBanner;
    
    @FindBy(xpath = "//a[.//img[@alt='Laptops']]") 
//    @FindBy(xpath="//*[@id=\"swiper-wrapper-724637ff468e749c\"]/div[2]/a/figure/div[1]/img")
    public WebElement trendingProduct;
    
    @FindBy(xpath="//*[@id='entry_212395']/div/p")
    public WebElement trendingProductParagraph;
    
    
}