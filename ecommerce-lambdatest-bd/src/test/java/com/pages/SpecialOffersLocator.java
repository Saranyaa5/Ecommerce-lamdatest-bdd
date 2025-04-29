package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpecialOffersLocator {	 
	 @FindBy(xpath="//*[@id=\"widget-navbar-217834\"]/ul/li[2]/a")
	 public WebElement specialoffer;
	 
	 @FindBy(xpath = "//div/div/h1[@class='h3']")
	    public WebElement heading;
}
