package com.actions;

import java.time.Duration;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.OrderPageLocator;
import com.utilities.HelperClass;

public class OrderPageAction {

    public OrderPageLocator orderPageLocator = null;
    private final WebDriver driver;
    WebDriverWait wait;
    private final Actions actions;
    private final JavascriptExecutor jsExecutor;

    public OrderPageAction() {
        this.driver = HelperClass.getDriver();
        this.orderPageLocator = new OrderPageLocator();
        PageFactory.initElements(driver, orderPageLocator);
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    public void continue1() {
        int attempts = 0;
        while (attempts < 2) {
            try {
                orderPageLocator = new OrderPageLocator(); 
                PageFactory.initElements(driver, orderPageLocator);

                WebElement continueBtn = wait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.elementToBeClickable(orderPageLocator.accContinue)
                ));
                continueBtn.click();

                wait.until(ExpectedConditions.visibilityOf(orderPageLocator.myAccount));
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
                System.out.println("Retrying due to stale element...");
                if (attempts == 2) {
                    throw e;
                }
            }
        }
    }
    
    public void clickLoginUnderMyAccount() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://ecommerce-playground.lambdatest.io/index.php?route=checkout/success"));
        actions.moveToElement(orderPageLocator.myAccount).perform();
        wait.until(ExpectedConditions.visibilityOf(orderPageLocator.loginLink));
        orderPageLocator.loginLink.click();
    }



    public void clickOrderHistory() {
        WebElement myAccountElement = wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.visibilityOf(orderPageLocator.myAccount)
        ));
        actions.moveToElement(myAccountElement).perform();
        WebElement myOrderElement = wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(orderPageLocator.orders)
        ));
        myOrderElement.click();
        wait.until(ExpectedConditions.visibilityOf(orderPageLocator.orderhistory));
    }

    public boolean eyeDisplayed() {
        WebElement eyeIcon = wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.visibilityOf(orderPageLocator.viewOrderButton)
        ));
        return eyeIcon.isDisplayed();
    }

    public void clickViewButton() {
        WebElement viewBtn = wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(orderPageLocator.viewOrderButton)
        ));
        viewBtn.click();
        wait.until(ExpectedConditions.visibilityOf(orderPageLocator.reorderButton));
    }

    public void clickReorderButton() {
        WebElement reorderBtn = wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(orderPageLocator.reorderButton)
        ));
        reorderBtn.click();

        wait.until(ExpectedConditions.visibilityOf(orderPageLocator.reorderSuccessMessage));
    }

    public boolean isReorderMessageDisplayed() {
        WebElement message = wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.visibilityOf(orderPageLocator.reorderSuccessMessage)
        ));
        return message.isDisplayed();
    }

    public String getTextOrder() {
        WebElement heading = wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.visibilityOf(orderPageLocator.orderhistory)
        ));
        return heading.getText();
    }
    
    public void clickOnOrderHistory() {
    	orderPageLocator.guestMyOrder.click();
    }

    public boolean isPageScrolledToTop() {
        Long scrollY = (Long) jsExecutor.executeScript("return window.scrollY;");
        return scrollY == 0L;
    }
}
