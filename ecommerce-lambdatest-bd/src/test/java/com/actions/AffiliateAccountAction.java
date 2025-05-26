package com.actions;

import java.time.Duration;

import org.openqa.selenium.By;
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

    private void refreshLocators() {
        affiliate = new AffiliateAccountLocator();
        PageFactory.initElements(driver, affiliate);
    }

    public void clickaccContinue() {
        try {
            WebElement button = getWait().until(ExpectedConditions.elementToBeClickable(affiliate.accContinue));
            BaseAction.clickElement(button);
        } catch (StaleElementReferenceException e) {
            refreshLocators();
            WebElement button = getWait().until(ExpectedConditions.elementToBeClickable(affiliate.accContinue));
            BaseAction.clickElement(button);
        }
    }

    public void clickRegister() {
        try {
            WebElement registerBtn = getWait().until(ExpectedConditions.elementToBeClickable(affiliate.registerAffiliate));
            BaseAction.scrollToElement(registerBtn);
            BaseAction.clickElement(registerBtn);
        } catch (StaleElementReferenceException e) {
            refreshLocators();
            clickRegister(); // retry
        }
    }

    public void enterPayee() {
        try {
            WebElement input = getWait().until(ExpectedConditions.visibilityOf(affiliate.payeeName));
            BaseAction.sendKeysElement(input, "jeev");
        } catch (StaleElementReferenceException e) {
            refreshLocators();
            WebElement input = getWait().until(ExpectedConditions.visibilityOf(affiliate.payeeName));
            BaseAction.sendKeysElement(input, "jeev");
        }
    }

    public void clickCheckbox() {
        try {
            WebElement checkbox = getWait().until(ExpectedConditions.elementToBeClickable(affiliate.checkbox));
            BaseAction.clickElement(checkbox);
        } catch (StaleElementReferenceException e) {
            refreshLocators();
            WebElement checkbox = getWait().until(ExpectedConditions.elementToBeClickable(affiliate.checkbox));
            BaseAction.clickElement(checkbox);
        }
    }

    public void conitnue1() {
        try {
            WebElement btn = getWait().until(ExpectedConditions.elementToBeClickable(affiliate.affContinue1));
            BaseAction.clickElement(btn);
        } catch (StaleElementReferenceException e) {
            refreshLocators();
            WebElement btn = getWait().until(ExpectedConditions.elementToBeClickable(affiliate.affContinue1));
            BaseAction.clickElement(btn);
        }
    }

    public String successMessage() {
        try {
            WebElement successMsg = getWait().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'alert-success')]")
            ));
            return successMsg.getText();
        } catch (StaleElementReferenceException e) {
            WebElement successMsg = getWait().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class, 'alert-success')]")
            ));
            return successMsg.getText();
        }
    }
}
