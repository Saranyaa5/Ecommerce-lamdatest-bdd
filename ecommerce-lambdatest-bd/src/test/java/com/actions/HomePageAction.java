package com.actions;

import org.openqa.selenium.WebDriver;
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void block1click() {
        wait.until(ExpectedConditions.elementToBeClickable(homePageLocator.blk1Shopnow))
            .click();
    }
    
    public String block1homepageUrl() {
        return driver.getCurrentUrl();
    }
    
    public void clickMpowBanner() {
        wait.until(ExpectedConditions.elementToBeClickable(homePageLocator.mpowBanner))
            .click();
    }
    
    public String getProductTitle() {
        return wait.until(ExpectedConditions.visibilityOf(homePageLocator.productTitle))
            .getText();
    }
}