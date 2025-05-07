package com.actions;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.HomePageLocator;
import com.utilities.HelperClass;

import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HomePageAction {

    HomePageLocator homePageLocator = null;
    WebDriver driver;
    WebDriverWait wait;
    List<String> list=new ArrayList<>();
    public  int validlinkCount;
    public int linkSize;
    
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
        wait.until(ExpectedConditions.elementToBeClickable(homePageLocator.headphonesBanner))
            .click();
    }
    
    
    public void clickNextButton() {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(homePageLocator.nextButton)).click();
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
    
    public void retrieveLinks(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        List<WebElement> allLinks = homePageLocator.allLinks;
        for (WebElement link : allLinks) {
            String href = link.getAttribute("href");
            if (href != null && !href.isEmpty()) {
                list.add(href);
            }
        }
        System.out.println("no of links:"+list.size());
    }

    
    public int ValidatedLinks() {
        for (String url : list) {
            checkLinks(url);
        }
        this.linkSize=list.size();
        return list.size()-this.validlinkCount;
    }

    public void checkLinks(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();
            if (responseCode==200) {
                System.out.println(url + " - "+responseMessage);
                this.validlinkCount++;
            } else {
                System.out.println(url + " - " + responseMessage + " - is a broken link");
            }

        } catch (IOException e) {
            System.out.println(url + " - is a broken link");
        }
    }
}