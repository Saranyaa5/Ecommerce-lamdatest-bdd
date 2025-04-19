package com.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

	private WebDriverWait getWait() {
		return new WebDriverWait(driver, Duration.ofSeconds(40));
	}

	public void clickaccContinue() throws InterruptedException {
		Thread.sleep(3000);
		try {
			getWait().until(ExpectedConditions.elementToBeClickable(affiliate.accContinue)).click();
		} catch (StaleElementReferenceException e) {
			// Refresh element
			affiliate = new AffiliateAccountLocator();
			PageFactory.initElements(driver, affiliate);
			getWait().until(ExpectedConditions.elementToBeClickable(affiliate.accContinue)).click();
		}
	}

	public void clickRegister() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement registerBtn = getWait().until(ExpectedConditions.elementToBeClickable(affiliate.registerAffiliate));
			js.executeScript("arguments[0].scrollIntoView(true);", registerBtn);
			js.executeScript("arguments[0].click();", registerBtn);
		} catch (StaleElementReferenceException e) {
			affiliate = new AffiliateAccountLocator();
			PageFactory.initElements(driver, affiliate);
			clickRegister(); // retry
		}
	}

	public void enterPayee() {
		try {
			getWait().until(ExpectedConditions.visibilityOf(affiliate.payeeName)).sendKeys("jeev");
		} catch (StaleElementReferenceException e) {
			affiliate = new AffiliateAccountLocator();
			PageFactory.initElements(driver, affiliate);
			getWait().until(ExpectedConditions.visibilityOf(affiliate.payeeName)).sendKeys("jeev");
		}
	}

	public void clickCheckbox() {
		try {
			getWait().until(ExpectedConditions.elementToBeClickable(affiliate.checkbox)).click();
		} catch (StaleElementReferenceException e) {
			affiliate = new AffiliateAccountLocator();
			PageFactory.initElements(driver, affiliate);
			getWait().until(ExpectedConditions.elementToBeClickable(affiliate.checkbox)).click();
		}
	}

	public void conitnue1() {
		try {
			getWait().until(ExpectedConditions.elementToBeClickable(affiliate.affContinue1)).click();
		} catch (StaleElementReferenceException e) {
			affiliate = new AffiliateAccountLocator();
			PageFactory.initElements(driver, affiliate);
			getWait().until(ExpectedConditions.elementToBeClickable(affiliate.affContinue1)).click();
		}
	}

	public String successMessage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class, 'alert-success')]")
			));
			return successMsg.getText();
		} catch (StaleElementReferenceException e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class, 'alert-success')]")
			));
			return successMsg.getText();
		}
	}
}
