package com.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartTableVerificationLocator {
	
    @FindBy(xpath = "//*[@id='content']/form/div/table/tbody/tr/td[2]")
    public List<WebElement> allProductNames;
    
}
