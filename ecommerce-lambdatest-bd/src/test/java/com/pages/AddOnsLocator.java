package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddOnsLocator {
@FindBy(xpath="//*[@id=\"widget-navbar-217834\"]/ul/li[5]/a/div/span")
public WebElement addons;

@FindBy(xpath="//*[@id=\"widget-navbar-217834\"]/ul/li[5]/ul/li[2]/a/div/span")
public WebElement design;

@FindBy(xpath="//div[@id=\"entry_214955\"]/h2")
public WebElement alerttext;

@FindBy(xpath="//*[@id=\"entry_215056\"]/div/div/nav/a[1]")
public WebElement camera;

@FindBy(xpath="//h1[@class='h4']")
public WebElement cameraText;
}
