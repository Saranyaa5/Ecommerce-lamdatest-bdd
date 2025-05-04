package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogLocator {
	@FindBy(xpath="//div[@id='widget-navbar-217834']//ul/li[2]/following-sibling::li/a/div/span[contains(text(),'Blog')]")
	public WebElement blogbutton;

	@FindBy(xpath="(//a[@class='text-ellipsis-2'][contains(text(),'amet volutpat consequat mauris nunc congue nisi vi')])[1]")
	public WebElement article;

	@FindBy(xpath="(//input[@id='input-name'])[1]")
	public WebElement yourName;

	@FindBy(xpath="(//input[@id='input-email'])[1]")
	public WebElement email;

	@FindBy(xpath="(//textarea[@id='input-comment'])[1]")
	public WebElement comment;

	@FindBy(xpath="//form[@id='form-comment']//div[2]/following-sibling::button")
	public WebElement postComment;

	@FindBy(css="#form-comment .alert-success")
	public WebElement validMessage;

	@FindBy(xpath="//div[@class='invalid-feedback' and contains(text(), 'Warning: Comment Name must be between 3 and 25 characters!')]")
	public WebElement Warning1;

	@FindBy(xpath="//div[@class='invalid-feedback' and contains(text(), 'Warning: Comment Text must be between 25 and 1000 characters!')]")
	public WebElement Warning2;

	@FindBy(xpath="//div[@class='list-group']//a[2]/preceding-sibling::a")
	public WebElement business;

	@FindBy(xpath="//h1[@class='h1']")
	public WebElement businessHeading;

	@FindBy(xpath="//div[h1]/h1")
	public WebElement productName;

	@FindBy(xpath="//img[contains(@src,'inner-banner-1920x200.webp')]")
	public WebElement img;

	@FindBy(xpath="(//div/div[@class='invalid-feedback'])[1]")
	public WebElement errorName;

	@FindBy(xpath="(//div/div[@class='invalid-feedback'])[3]")
	public WebElement errorComment;

}

