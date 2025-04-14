package com.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.AddToCartLocator;
import com.pages.CheckOutPageLocator;

import com.pages.SearchLocator;
import com.utilities.HelperClass;

public class CheckOutAction {
	CheckOutPageLocator checkOutPageLocator=null;
	SearchLocator searchLocator;
	 AddToCartLocator cartLocator;
	 WebDriverWait wait;
	 private final Actions actions;
	
	public CheckOutAction() {
		 this.searchLocator = new SearchLocator();
		checkOutPageLocator =new CheckOutPageLocator();
		PageFactory.initElements(HelperClass.getDriver(),checkOutPageLocator);
		this.actions = new Actions(HelperClass.getDriver());
	}
	
	public void searchProdut(String string) {
		checkOutPageLocator.searchbox.sendKeys(string);
		checkOutPageLocator.searchbutton.click();
	}
	
	
	public void selectSearchProduct() {
		checkOutPageLocator.productImage.click();
    }
	
	public void productCheckOut() {
		checkOutPageLocator.CheckoutFromCart.click();
	}
	
	public void selectGuestUser() {
		checkOutPageLocator.guestUser.click();
	}
	public void fillGuestCheckoutForm(String firstName, String lastName, String email, 
            String telephone, String address, String city, 
            String postcode, String country, String region) {
			// Fill basic form fields
			checkOutPageLocator.paymentFname.sendKeys(firstName);
			checkOutPageLocator.paymentLname.sendKeys(lastName);
			checkOutPageLocator.paymentEmail.sendKeys(email);
			checkOutPageLocator.paymentTelephone.sendKeys(telephone);
			checkOutPageLocator.paymentAddress.sendKeys(address);
			checkOutPageLocator.paymentCity.sendKeys(city);
			checkOutPageLocator.paymentPostcode.sendKeys(postcode);
			
			// Handle country dropdown
			selectDropdownByVisibleText(checkOutPageLocator.countryDropdown, "India");
			
			// Wait for region dropdown to load (may need AJAX wait)
			try {
			Thread.sleep(1000); // Simple wait - replace with proper wait in real implementation
			} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			}
			
			// Handle region dropdown
			selectDropdownByVisibleText(checkOutPageLocator.regionDropdown,"Assam");
			
			}
			
			private void selectDropdownByVisibleText(WebElement dropdown, String value) {
			Select select = new Select(dropdown);
			select.selectByVisibleText(value);
			}
			
//			public void acceptGuestTermsCondition() {
//				checkOutPageLocator.termsCheckbox.click();
//			}
			public void acceptGuestTermsCondition() {
			    try {
			        WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
			        
			        // First scroll to the element
			        WebElement termsCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(
			            By.xpath("//*[@id='form-checkout']/div/div[2]/div/div[5]/label")));
			        
			        ((JavascriptExecutor) HelperClass.getDriver()).executeScript(
			            "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", 
			            termsCheckbox);
			        
			        // Wait until clickable and click using JavaScript
			        wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox));
			        ((JavascriptExecutor) HelperClass.getDriver()).executeScript(
			            "arguments[0].click();", termsCheckbox);
			        
			    } catch (Exception e) {
			        System.out.println("Exception while accepting terms: " + e.getMessage());
			        throw e;
			    }
			}
			
			public void clickContinueCheckout() {
			    WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(30));
			    wait.until(ExpectedConditions.elementToBeClickable(checkOutPageLocator.continueButton));
			    
			    actions.moveToElement(checkOutPageLocator.continueButton)
			           .click()
			           .perform();
			}
			
			
			public void confirmOrder() {
				WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(30));
			    wait.until(ExpectedConditions.elementToBeClickable(checkOutPageLocator.confirmOrder));
				checkOutPageLocator.confirmOrder.click();
			}
			
			public boolean OrderSuccessMsg(){
				return checkOutPageLocator.orderSuccessMessage.isDisplayed();
			}
			
			public String EmptyCartMessage() {
				return checkOutPageLocator.emptyCartMessage.getText();
			}
			
			public void fillPaymentCheckoutForm(String firstName, String lastName, 
		            String address, String city, 
		            String postcode) {
//					// Fill basic form fields
////					checkOutPageLocator.paymentFname.sendKeys(firstName);
//				scrollToElement(checkOutPageLocator.paymentFname);
//			    checkOutPageLocator.paymentFname.clear();
				
			    checkOutPageLocator.paymentFname.sendKeys(firstName);
					checkOutPageLocator.paymentLname.sendKeys(lastName);
					checkOutPageLocator.paymentAddress.sendKeys(address);
					checkOutPageLocator.paymentCity.sendKeys(city);
					checkOutPageLocator.paymentPostcode.sendKeys(postcode);
					
					// Handle country dropdown
					selectDropdownByVisibleText(checkOutPageLocator.countryDropdown, "India");
					
					// Wait for region dropdown to load (may need AJAX wait)
					try {
					Thread.sleep(1000); // Simple wait - replace with proper wait in real implementation
					} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					}
					
					// Handle region dropdown
					selectDropdownByVisibleText(checkOutPageLocator.regionDropdown,"Assam");
					
					}
			
			       public void clickExistingAddButton() {
			    	   checkOutPageLocator.ExistingAdd.click();
			       }
			       public void clickNewAddressButton() {
			    	   checkOutPageLocator.newAdd.click();
			       }
			       
			       
			       
//			       private void scrollToElement(WebElement element) {
//			    	    ((JavascriptExecutor) HelperClass.getDriver()).executeScript(
//			    	        "arguments[0].scrollIntoView({block: 'center'});", element);
//			    	    try {
//			    	        Thread.sleep(500); // Small pause after scroll
//			    	    } catch (InterruptedException e) {
//			    	        Thread.currentThread().interrupt();
//			    	    }
//			    	}
			       
			
			
}
