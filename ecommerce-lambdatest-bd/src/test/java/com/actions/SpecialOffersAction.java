package com.actions;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.BlogLocator;
import com.pages.SearchLocator;
import com.pages.SpecialOffersLocator;
import com.utilities.HelperClass;

public class SpecialOffersAction {
	WebDriver driver;
    SpecialOffersLocator so;
    WebDriverWait wait;

    public SpecialOffersAction() {
        this.driver = HelperClass.getDriver();
        this.so = new SpecialOffersLocator();
        PageFactory.initElements(driver, so);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    
    private void refreshElements() {
		so = new SpecialOffersLocator();
		PageFactory.initElements(driver, so);
	}


    public void clickSpecialOffersButton() {
    	try {
			so.specialoffer.click();
		} catch (StaleElementReferenceException e) {
			refreshElements();
			so.specialoffer.click();
		}
    }

    public String getSpecialOfferText() {
        wait.until(ExpectedConditions.visibilityOf(so.heading));
        return so.heading.getText();
    }
}
