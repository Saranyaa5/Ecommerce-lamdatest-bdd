package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPageLocator {
	
	@FindBy(xpath="//*[@id=\"content\"]/div/a")
	public WebElement accContinue;
	
	@FindBy(xpath="//a[@class='icon-left both nav-link dropdown-toggle' and @href='https://ecommerce-playground.lambdatest.io/index.php?route=account/account']")
	public WebElement myAccount;
    

    @FindBy(xpath="//*[@id=\"content\"]/div[2]/div/div/div[1]/a")
    public WebElement myOrders;
    
    @FindBy(xpath = "//a[contains(@href, 'order/info') and contains(@class, 'btn-info')]")
    public WebElement viewOrderButton;
    
    @FindBy(xpath = "//a[contains(@href, 'order/info') and contains(@class, 'btn-info')]")
    private WebElement viewButton;

    @FindBy(xpath = "//a[contains(@href,'reorder')]")
	public WebElement reorderButton;

    @FindBy(css = ".alert-success")  // Assuming the success message has this class
	public WebElement reorderSuccessMessage;
    
    @FindBy(xpath="//*[@id=\"content\"]/div[1]/table/tbody/tr/td[1]")
    public WebElement orderid;
    
    @FindBy(xpath="//*[@id=\"widget-navbar-217834\"]/ul/li[6]/ul/li[2]/a/div/span")
    public WebElement orders;
    
    @FindBy(xpath="//*[@id=\"content\"]/div[1]/table/tbody/tr/td[7]/a")
    public WebElement eye;
    
    @FindBy(xpath = "//div[@class='table-responsive']//table//tbody")
    public WebElement orderHistoryTable;
    
    @FindBy(xpath="//h1[@class='page-title h3 mb-3']")
    public WebElement orderhistory;

}