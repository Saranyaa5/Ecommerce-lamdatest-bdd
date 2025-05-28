package com.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.pages.OrderPageLocator;
import com.utilities.HelperClass;

public class OrderPageAction {
    public OrderPageLocator orderPageLocator = null;
    private final WebDriver driver;
    private final Actions actions;
    private final JavascriptExecutor jsExecutor;

    public OrderPageAction() {
        this.driver = HelperClass.getDriver();
        this.orderPageLocator = new OrderPageLocator();
        PageFactory.initElements(driver, orderPageLocator);
        this.actions = new Actions(driver);
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    private boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isElementEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    private void retryOnStaleElement(Runnable action) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                orderPageLocator = new OrderPageLocator();
                PageFactory.initElements(driver, orderPageLocator);
                action.run();
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

    public void continue1() {
        retryOnStaleElement(() -> {
            if (isElementDisplayed(orderPageLocator.accContinue) && 
                isElementEnabled(orderPageLocator.accContinue)) {
                orderPageLocator.accContinue.click();
            }
        });
    }
    
    public void clickLoginUnderMyAccount() {
        if (driver.getCurrentUrl().equals("https://ecommerce-playground.lambdatest.io/index.php?route=checkout/success")) {
            if (isElementDisplayed(orderPageLocator.myAccount)) {
                actions.moveToElement(orderPageLocator.myAccount).perform();
                if (isElementDisplayed(orderPageLocator.loginLink) && 
                    isElementEnabled(orderPageLocator.loginLink)) {
                    orderPageLocator.loginLink.click();
                }
            }
        }
    }

    public void clickOrderHistory() {
        retryOnStaleElement(() -> {
            if (isElementDisplayed(orderPageLocator.myAccount)) {
                actions.moveToElement(orderPageLocator.myAccount).perform();
                if (isElementDisplayed(orderPageLocator.orders) && 
                    isElementEnabled(orderPageLocator.orders)) {
                    orderPageLocator.orders.click();
                }
            }
        });
    }

    public boolean eyeDisplayed() {
        return isElementDisplayed(orderPageLocator.viewOrderButton);
    }

    public void clickViewButton() {
        retryOnStaleElement(() -> {
            if (isElementDisplayed(orderPageLocator.viewOrderButton) && 
                isElementEnabled(orderPageLocator.viewOrderButton)) {
                orderPageLocator.viewOrderButton.click();
            }
        });
    }

    public void clickReorderButton() {
        retryOnStaleElement(() -> {
            if (isElementDisplayed(orderPageLocator.reorderButton) && 
                isElementEnabled(orderPageLocator.reorderButton)) {
                orderPageLocator.reorderButton.click();
            }
        });
    }

    public boolean isReorderMessageDisplayed() {
        return isElementDisplayed(orderPageLocator.reorderSuccessMessage);
    }

    public String getTextOrder() {
        if (isElementDisplayed(orderPageLocator.orderhistory)) {
            return orderPageLocator.orderhistory.getText();
        }
        return "";
    }
    
    public void clickOnOrderHistory() {
        if (isElementDisplayed(orderPageLocator.guestMyOrder) && 
            isElementEnabled(orderPageLocator.guestMyOrder)) {
            orderPageLocator.guestMyOrder.click();
        }
    }

    public boolean isPageScrolledToTop() {
        Long scrollY = (Long) jsExecutor.executeScript("return window.scrollY;");
        return scrollY == 0L;
    }
}