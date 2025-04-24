package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocator {

	@FindBy(css="#entry_217964 a:first-of-type")
	public WebElement blk1Shopnow;
	
	@FindBy(css="#entry_217967 > a")
	public WebElement blk2Shopnow;
	
	@FindBy(css="#entry_216815 > div : first-of-type")
	public WebElement blk2redirPage;
	
	
}
