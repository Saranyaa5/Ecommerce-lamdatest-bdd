package com.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.pages.HomePageLocator;
import com.utilities.HelperClass;

public class HomePageAction {

	HomePageLocator homePageLocator=null;
	WebDriver driver;
	
	public HomePageAction(){
		homePageLocator=new HomePageLocator();
		PageFactory.initElements(HelperClass.getDriver(),homePageLocator);
		driver=HelperClass.getDriver();
	}
	
	
	public void block1click() {
		homePageLocator.blk1Shopnow.click();
		
	}
	public String block1homepageUrl() {
		return driver.getCurrentUrl();
		
	}
	
	public String block2text() {
		return homePageLocator.blk2redirPage.getText();
		
	}
	public void block2click() {
		homePageLocator.blk2Shopnow.click();
		
	}
}
