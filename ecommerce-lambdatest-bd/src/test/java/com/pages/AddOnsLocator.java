package com.pages;

import org.openqa.selenium.WebElement;
import java.util.*;

import org.openqa.selenium.support.FindBy;

public class AddOnsLocator {
	@FindBy(xpath="(//a[@class='icon-left both nav-link dropdown-toggle']/div/span)[2]")
	public WebElement addons;

	@FindBy(xpath="//a[@class='icon-left both dropdown-item']/following::a/div/span[contains(text(), 'Designs')]")
	public WebElement design;

	@FindBy(xpath="(//div//h2[@class='mb-4'])[1]")
	public WebElement alerttext;
	
	@FindBy(xpath="(//div[@class='menu-items d-flex align-items-start']/following::a[@title='Cameras'])[1]")
	public WebElement camera;

	@FindBy(xpath="//h1[@class='h4']")
	public WebElement cameraText;
	
	@FindBy(xpath="//div[contains(@id,'entry_214956')]/div/div")
	public List<WebElement> alterdiv;
	
	@FindBy(xpath="//div[contains(@id,'entry_214960')]/div/button")
	public WebElement alterReomveBtn;

	@FindBy(xpath="(//div[@class='menu-items d-flex align-items-start']/descendant::a[@class='nav-link icon-left text'])[33]")
	public WebElement cam;
	
	@FindBy(xpath="(//div[@class='caption']/h4/a[@class='text-ellipsis-2'])[1]")
	public WebElement camPageText;
	
}
