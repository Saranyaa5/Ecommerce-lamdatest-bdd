package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MegaMenuLocator {
@FindBy(xpath="(//a[@class='icon-left both nav-link dropdown-toggle']/div/span)[1]")
public WebElement megamenu;

@FindBy(xpath="(//a[contains(text(), 'Apple')])[1]")
public WebElement apple;

@FindBy(xpath="//div[@id='entry_212427']/h1")
public WebElement appleHeading;

}
