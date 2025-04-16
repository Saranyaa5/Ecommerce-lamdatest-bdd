package com.actions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.OrderPageLocator;
import com.utilities.HelperClass;

public class OrderPageAction {
	
	public OrderPageLocator 	orderPageLocator=null;
	private final WebDriverWait wait;
	 private final Actions actions;
	 private final JavascriptExecutor jsExecutor;
	public OrderPageAction() {
		orderPageLocator=new OrderPageLocator();
		PageFactory.initElements(HelperClass.getDriver(),orderPageLocator);
		 this.actions = new Actions(HelperClass.getDriver());
	        this.wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(30));
	        this.jsExecutor = (JavascriptExecutor) HelperClass.getDriver();
	}
 
	public void clickOrderHistory(){
		orderPageLocator.myOrders.click();
	}
	
	public String getOrderId() {
		return orderPageLocator.orderid.getText();
	}
	public void clickAccountsButton() {
		 waitAndMoveToElement(orderPageLocator.clickaccount);
	}
	private void waitAndMoveToElement(WebElement element) {
        WebElement el = wait.until(ExpectedConditions.visibilityOf(element));
        actions.moveToElement(el).perform();
    }

}
