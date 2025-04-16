package com.actions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.AffiliateAccountLocator;
import com.utilities.HelperClass;

public class AffiliateAccountAction {

	WebDriver driver;
	AffiliateAccountLocator affiliate;

	public AffiliateAccountAction() {
		this.driver = HelperClass.getDriver();
		this.affiliate = new AffiliateAccountLocator();
		PageFactory.initElements(driver, affiliate);
	}

	// Helper wait method
	private WebDriverWait getWait() {
		return new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void clickaccContinue() throws InterruptedException {
		Thread.sleep(3000);
	affiliate.accContinue.click();
	}	
	// Register
//	public void clickRegister() {
//		getWait().until(ExpectedConditions.elementToBeClickable(affiliate.registerAffiliate)).click();
//	}
	public void clickRegister() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    // Scroll to the element
	    js.executeScript("arguments[0].scrollIntoView(true);", affiliate.registerAffiliate);

	    // Optionally wait for the element to be clickable
	    getWait().until(ExpectedConditions.elementToBeClickable(affiliate.registerAffiliate));

	    // Click using JavaScript
	    js.executeScript("arguments[0].click();", affiliate.registerAffiliate);
	}

	public void enterPayee() {
		getWait().until(ExpectedConditions.visibilityOf(affiliate.payeeName)).sendKeys("jeev");
	}

	public void clickCheckbox() {
		getWait().until(ExpectedConditions.elementToBeClickable(affiliate.checkbox)).click();
	}

	public void conitnue1() {
		getWait().until(ExpectedConditions.elementToBeClickable(affiliate.affContinue1)).click();
	}

	public String editOption() {
		return getWait().until(ExpectedConditions.visibilityOf(affiliate.affiliateButton)).getText();
	}

	// Edit
	public void clickAffiliate() {
		getWait().until(ExpectedConditions.elementToBeClickable(affiliate.affiliateButton)).click();
	}

	public void affiliateaccName(String accName) {
		getWait().until(ExpectedConditions.visibilityOf(affiliate.accountName)).clear();
		affiliate.accountName.sendKeys(accName);
	}

	public void affiliateaccNumber(String accNumber) {
		getWait().until(ExpectedConditions.visibilityOf(affiliate.accountNumber)).clear();
		affiliate.accountNumber.sendKeys(accNumber);
	}

	public void clickContinue() {
		getWait().until(ExpectedConditions.elementToBeClickable(affiliate.affContinue2)).click();
	}

	public String accountText() {
		return getWait().until(ExpectedConditions.visibilityOf(affiliate.affText)).getText();
	}

	// Tracking Code
	public void clickTracking() {
		getWait().until(ExpectedConditions.elementToBeClickable(affiliate.trackingAffiliate)).click();
	}

	public String getTrackingCode() {
		return getWait().until(ExpectedConditions.visibilityOf(affiliate.trackingCode)).getAttribute("value");
	}

	public void clickTrackingContinue() {
		getWait().until(ExpectedConditions.elementToBeClickable(affiliate.affContinue3)).click();
	}
}
