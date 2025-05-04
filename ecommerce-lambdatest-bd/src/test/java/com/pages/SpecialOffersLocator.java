package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpecialOffersLocator {	 
	 @FindBy(xpath="(//div[@id='widget-navbar-217834']//li[1]/following-sibling::li[1]/a)[1]")
	 public WebElement specialoffer;
	 
	 @FindBy(xpath = "//div/div/h1[@class='h3']")
	 public WebElement heading;
}
