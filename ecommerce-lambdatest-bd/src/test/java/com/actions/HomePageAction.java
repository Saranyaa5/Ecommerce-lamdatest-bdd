package com.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.HomePageLocator;
import com.utilities.HelperClass;

import java.time.Duration;

public class HomePageAction {

    HomePageLocator homePageLocator = null;
    WebDriver driver;
    WebDriverWait wait;
    
    public HomePageAction() {
        homePageLocator = new HomePageLocator();
        driver = HelperClass.getDriver();
        PageFactory.initElements(driver, homePageLocator);
        
    }
    
    public void block1click() {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homePageLocator.blk1Shopnow))
            .click();
    }
    
    public String block1homepageUrl() {
        return driver.getCurrentUrl();
    }
    
    public void clickMpowBanner() {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homePageLocator.mpowBanner))
            .click();
    }
    
    public String getProductTitle() {
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOf(homePageLocator.productTitle))
            .getText();
    }
    
    public void clickHeadphonesBanner() {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(homePageLocator.HeadphonesBanner))
            .click();
    }
    
    public String getHeadPhonesProductTitle() {
   	 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       return wait.until(ExpectedConditions.visibilityOf(homePageLocator.productTitle))
           .getText();
   }
    
    public void clickNextButton() {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(homePageLocator.nextButton)).click();
//    	homePageLocator.nextButton.click();
    }
    
    public String getActiveBannerAltText() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement visibleBanner = wait.until(ExpectedConditions.visibilityOf(homePageLocator.activeBanner));
        return visibleBanner.getAttribute("alt");
    }
    
    
    public void clickTrendingProduct() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(homePageLocator.trendingProduct))
            .click();
    }
    
    public String getTrendingProductParagraphText() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       return driver.getCurrentUrl();
     
    }
}