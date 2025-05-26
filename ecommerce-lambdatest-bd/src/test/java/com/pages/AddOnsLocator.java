package com.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class AddOnsLocator {
	@FindBy(xpath="(//a[@class='icon-left both nav-link dropdown-toggle']/div/span)[2]")
	public WebElement addons;

	@FindBy(xpath="//a[@class='icon-left both dropdown-item']/following::a/div/span[contains(text(), 'Designs')]")
	public WebElement design;

	@FindBy(xpath="(//div//h2[@class='mb-4'])[1]")
	public WebElement alerttext;
	
	@FindBy(xpath="(//div[@class='menu-items d-flex align-items-start']/descendant::a[@class='nav-link icon-left text'])[33]")
	public WebElement cam;
	
	@FindBy(xpath="(//div[@class='caption']/h4/a[@class='text-ellipsis-2'])[1]")
	public WebElement camPageText;
	
}
