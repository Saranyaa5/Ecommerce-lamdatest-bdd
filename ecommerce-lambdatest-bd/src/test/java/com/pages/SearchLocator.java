package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchLocator {
@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div[2]/input")
public WebElement searchbox;

@FindBy(xpath="//button[text()='Search']")
public WebElement searchbutton;

@FindBy(xpath="//*[@id=\"input-limit-212463\"]")
public WebElement showcount;




@FindBy(xpath="(//a[@class='text-ellipsis-2'][text()='MacBook'])[1]")
public WebElement macbook;

@FindBy(xpath="(//a[@class='text-ellipsis-2'][text()='iPhone'])[1]")
public WebElement iphone;

@FindBy(xpath="(//a[@class='text-ellipsis-2'][text()='iMac'])[1]")
public WebElement imac;

@FindBy(xpath="(//a[text()='HTC Touch HD'])[1]")
public WebElement htc;

@FindBy(xpath="(//p[contains(text(),'There is no product that matches the search criter')])[1]")
public WebElement errormessage;


}
