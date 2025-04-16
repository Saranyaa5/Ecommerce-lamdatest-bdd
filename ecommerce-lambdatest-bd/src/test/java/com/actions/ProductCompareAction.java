package com.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import com.pages.ProductCompareLocator;
import com.utilities.HelperClass;

public class ProductCompareAction {
	ProductCompareLocator productCompareLocator=null; 
	public ProductCompareAction() {
		productCompareLocator =new ProductCompareLocator ();
		PageFactory.initElements(HelperClass.getDriver(),productCompareLocator);
		
	}
	
	public void clickProductCompare() {
		productCompareLocator.productCompare1.click();
	}
	
	public void comparionButton() {
		productCompareLocator.productCompare2.click();
	}
	
	public boolean getNoProductsToCompareMessage() {
		return productCompareLocator.noProducts.isDisplayed();
	}
	
	public void clickProduct() {
		productCompareLocator.product1.click();
	}
//	public void clickComparionArrow() {
//		productCompareLocator.comparisionArrow.click();
//	}
	
	public void clickComparionArrow() {
	    JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();
	    js.executeScript("arguments[0].click();", productCompareLocator.comparisionArrow);
	}


	public String getProductDescription() {
		return productCompareLocator.ComparisionProductDesc.getText();
	}
	
}
