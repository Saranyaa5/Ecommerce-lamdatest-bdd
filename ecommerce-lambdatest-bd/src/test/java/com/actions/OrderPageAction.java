package com.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
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
            try {
                if (orderPageLocator.accContinue.isDisplayed() && 
                    orderPageLocator.accContinue.isEnabled()) {
                    orderPageLocator.accContinue.click();
                }
            } catch (Exception e) {
                System.out.println("Element not found or not interactable");
            }
        });
    }
    
    public void clickLoginUnderMyAccount() {
        if (driver.getCurrentUrl().equals("https://ecommerce-playground.lambdatest.io/index.php?route=checkout/success")) {
            try {
                if (orderPageLocator.myAccount.isDisplayed()) {
                    actions.moveToElement(orderPageLocator.myAccount).perform();
                    if (orderPageLocator.loginLink.isDisplayed() && 
                        orderPageLocator.loginLink.isEnabled()) {
                        orderPageLocator.loginLink.click();
                    }
                }
            } catch (Exception e) {
                System.out.println("Element not found or not interactable");
            }
        }
    }

    public void clickOrderHistory() {
        retryOnStaleElement(() -> {
            try {
                if (orderPageLocator.myAccount.isDisplayed()) {
                    actions.moveToElement(orderPageLocator.myAccount).perform();
                    if (orderPageLocator.orders.isDisplayed() && 
                        orderPageLocator.orders.isEnabled()) {
                        orderPageLocator.orders.click();
                    }
                }
            } catch (Exception e) {
                System.out.println("Element not found or not interactable");
            }
        });
    }

    public boolean eyeDisplayed() {
        try {
            return orderPageLocator.viewOrderButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickViewButton() {
        retryOnStaleElement(() -> {
            try {
                if (orderPageLocator.viewOrderButton.isDisplayed() && 
                    orderPageLocator.viewOrderButton.isEnabled()) {
                    orderPageLocator.viewOrderButton.click();
                }
            } catch (Exception e) {
                System.out.println("Element not found or not interactable");
            }
        });
    }

    public void clickReorderButton() {
        retryOnStaleElement(() -> {
            try {
                if (orderPageLocator.reorderButton.isDisplayed() && 
                    orderPageLocator.reorderButton.isEnabled()) {
                    orderPageLocator.reorderButton.click();
                }
            } catch (Exception e) {
                System.out.println("Element not found or not interactable");
            }
        });
    }

    public boolean isReorderMessageDisplayed() {
        try {
            return orderPageLocator.reorderSuccessMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getTextOrder() {
        try {
            if (orderPageLocator.orderhistory.isDisplayed()) {
                return orderPageLocator.orderhistory.getText();
            }
        } catch (Exception e) {
            System.out.println("Element not found");
        }
        return "";
    }
    
    public void clickOnOrderHistory() {
        try {
            if (orderPageLocator.guestMyOrder.isDisplayed() && 
                orderPageLocator.guestMyOrder.isEnabled()) {
                orderPageLocator.guestMyOrder.click();
            }
        } catch (Exception e) {
            System.out.println("Element not found or not interactable");
        }
    }

    public boolean isPageScrolledToTop() {
        Long scrollY = (Long) jsExecutor.executeScript("return window.scrollY;");
        return scrollY == 0L;
    }
}