package com.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.pages.HomePageLocator;
import com.utilities.HelperClass;

import java.io.IOException;
import java.util.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HomePageAction {

    HomePageLocator homePageLocator = null;
    WebDriver driver;
    List<String> list = new ArrayList<>();
    public int validlinkCount;
    public int linkSize;

    public HomePageAction() {
        homePageLocator = new HomePageLocator();
        driver = HelperClass.getDriver();
        PageFactory.initElements(driver, homePageLocator);
    }

    private boolean waitAndClick(WebElement element, int retries, int delayInMillis) {
        for (int i = 0; i < retries; i++) {
            try {
                if (element.isDisplayed() && element.isEnabled()) {
                    element.click();
                    return true;
                }
            } catch (Exception ignored) {}
            try {
                Thread.sleep(delayInMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        System.out.println("Element not clickable after retries: " + element);
        return false;
    }

    private boolean waitUntilDisplayed(WebElement element, int retries, int delayInMillis) {
        for (int i = 0; i < retries; i++) {
            try {
                if (element.isDisplayed()) {
                    return true;
                }
            } catch (Exception ignored) {}
            try {
                Thread.sleep(delayInMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        return false;
    }

    public void block1click() {
        waitAndClick(homePageLocator.blk1Shopnow, 5, 1000);
    }

    public String block1homepageUrl() {
        return driver.getCurrentUrl();
    }

    public void clickMpowBanner() {
        waitAndClick(homePageLocator.mpowBanner, 5, 1000);
    }

    public String getProductTitle() {
        if (waitUntilDisplayed(homePageLocator.productTitle, 5, 1000)) {
            return homePageLocator.productTitle.getText();
        }
        return "";
    }

    public void clickHeadphonesBanner() {
        waitAndClick(homePageLocator.headphonesBanner, 5, 3000);
    }

    public void clickNextButton() {
        waitAndClick(homePageLocator.nextButton, 5, 1000);
    }

    public String getActiveBannerAltText() {
        if (waitUntilDisplayed(homePageLocator.activeBanner, 5, 1000)) {
            return homePageLocator.activeBanner.getAttribute("alt");
        }
        return "";
    }

    public void clickTrendingProduct() {
        waitAndClick(homePageLocator.trendingProduct, 5, 1000);
    }

    public String getTrendingProductParagraphText() {
        return driver.getCurrentUrl();
    }

    public void retrieveLinks() {
        List<WebElement> allLinks = homePageLocator.allLinks;
        for (WebElement link : allLinks) {
            String href = link.getAttribute("href");
            if (href != null && !href.isEmpty()) {
                list.add(href);
            }
        }
        System.out.println("no of links: " + list.size());
    }

    public int ValidatedLinks() {
        for (String url : list) {
            checkLinks(url);
        }
        this.linkSize = list.size();
        return list.size() - this.validlinkCount;
    }

    public void checkLinks(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();
            if (responseCode == 200) {
                System.out.println(url + " - " + responseMessage);
                this.validlinkCount++;
            } else {
                System.out.println(url + " - " + responseMessage + " - is a broken link");
            }
        } catch (IOException e) {
            System.out.println(url + " - is a broken link");
        }
    }
}
