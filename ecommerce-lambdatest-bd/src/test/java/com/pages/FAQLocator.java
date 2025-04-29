package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FAQLocator {

	@FindBy(xpath = "(//div[@class='collapse']/preceding-sibling::h5)[1]")
    public WebElement changeshippingaddress;
//
//	@FindBy(xpath = "(//h5[@class='card-header border-bottom-0 align-items-center d-flex collapsed'])[3]")
//    public WebElement activateaccount;
//	
//	@FindBy(xpath = "(//h5[@class='card-header border-bottom-0 align-items-center d-flex collapsed'])[4]")
//    public WebElement points;
//	
//	@FindBy(xpath = "(//h5[@class='card-header border-bottom-0 align-items-center d-flex collapsed'])[5]")
//    public WebElement checkoutlimit;
//	
//	@FindBy(xpath = "(//h5[@class='card-header border-bottom-0 align-items-center d-flex collapsed'])[6]")
//    public WebElement paymentimmediate;
//	
//	
	
	@FindBy(xpath = "(//div[@class='card-body pt-0']/p)[1]")
    public WebElement changeshippingaddressmsg;

//	@FindBy(xpath = "(//div[@class='card-body pt-0']/p)[3]")
//    public WebElement activateaccountmsg;
//	
//	@FindBy(xpath = "(//div[@class='card-body pt-0']/p)[4]")
//    public WebElement pointsmsg;
//	
//	@FindBy(xpath = "(//div[@class='card-body pt-0']/p)[5]")
//    public WebElement checkoutlimitmsg;
//	
//	@FindBy(xpath = "(//div[@class='card-body pt-0']/p)[6]")
//    public WebElement paymentimmediatemsg;
	
}