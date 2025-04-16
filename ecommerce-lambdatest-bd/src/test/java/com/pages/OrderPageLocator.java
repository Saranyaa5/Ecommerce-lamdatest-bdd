package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPageLocator {
	
	@FindBy(xpath="//a[@class='icon-left both nav-link dropdown-toggle' and @href='https://ecommerce-playground.lambdatest.io/index.php?route=account/account']")
	public WebElement clickaccount;

    @FindBy(xpath="//*[@id=\"content\"]/div[2]/div/div/div[1]/a")
    public WebElement myOrders;
    
    @FindBy(xpath="//*[@id=\"content\"]/div[1]/table/tbody/tr/td[1]")
    public WebElement orderid;
    
	
}
