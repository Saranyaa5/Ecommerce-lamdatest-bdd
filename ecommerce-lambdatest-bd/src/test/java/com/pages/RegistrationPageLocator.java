package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPageLocator {
	@FindBy(xpath="//a[contains(@class,'nav-link')andcontains(.,'My account')]")
	public WebElement MyAccount; 
	
	@FindBy(xpath="//a[contains(@href,'route=account/register')]")
	public WebElement Register;
}
