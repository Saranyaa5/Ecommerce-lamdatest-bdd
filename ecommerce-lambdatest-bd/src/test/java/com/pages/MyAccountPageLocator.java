package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPageLocator {
	
@FindBy(xpath="//h2[text()='My Account']")
public WebElement titleMyAccount;

}
