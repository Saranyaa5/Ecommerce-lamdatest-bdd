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
	 public CheckOutAction() {
		 this.searchLocator = new SearchLocator();
		checkOutPageLocator =new CheckOutPageLocator();
		PageFactory.initElements(HelperClass.getDriver(),checkOutPageLocator);
		new Actions(HelperClass.getDriver());
	}
	
	public void searchProdut(String string) {
		
		checkOutPageLocator.searchbox.sendKeys(Keys.CONTROL + "a");
		checkOutPageLocator.searchbox.sendKeys(Keys.BACK_SPACE);
		checkOutPageLocator.searchbox.sendKeys(string);
		checkOutPageLocator.searchbutton.click();
	}
	
	
	public void selectSearchProduct() {
		checkOutPageLocator.productImage.click();
    }
	
	public void productCheckOut() {
		checkOutPageLocator.checkoutFromCart.click();
	}
	
	public void selectGuestUser() {
		checkOutPageLocator.guestUser.click();
	}
	public void selectRegUser() {
		checkOutPageLocator.registerUser.click();
	}
	
	
	public void reomveProduct() {
		checkOutPageLocator.removeProduct.click();
	}
	public void fillGuestCheckoutForm(String firstName, String lastName, String email, 
            String telephone, String address, String city, 
            String postcode, String country, String region) {
			
			checkOutPageLocator.paymentFname.sendKeys(firstName);
			checkOutPageLocator.paymentLname.sendKeys(lastName);
			checkOutPageLocator.paymentEmail.sendKeys(email);
			checkOutPageLocator.paymentTelephone.sendKeys(telephone);
			checkOutPageLocator.paymentAddress.sendKeys(address);
			checkOutPageLocator.paymentCity.sendKeys(city);
			checkOutPageLocator.paymentPostcode.sendKeys(postcode);
			
			selectDropdownByVisibleText(checkOutPageLocator.countryDropdown, country);
			wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.elementToBeClickable(checkOutPageLocator.regionDropdown));
		    
			selectDropdownByVisibleText(checkOutPageLocator.regionDropdown,region);
			
			}
	
			
			private void selectDropdownByVisibleText(WebElement dropdown, String value) {
			Select select = new Select(dropdown);
			select.selectByVisibleText(value);
			}
			
			public void acceptGuestTermsCondition() {
			    try {
			       wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
			       
			        WebElement termsCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(
			            By.xpath("//*[@id='form-checkout']/div/div[2]/div/div[5]/label")));
			        
			        ((JavascriptExecutor) HelperClass.getDriver()).executeScript(
			            "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", 
			            termsCheckbox);
			        
			        wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox));
			        ((JavascriptExecutor) HelperClass.getDriver()).executeScript(
			            "arguments[0].click();", termsCheckbox);
			        
			    } catch (Exception e) {
			        System.out.println("Exception while accepting terms: " + e.getMessage());
			        throw e;
			    }
			}
			
			public void clickPrivacyPolicy() {
				checkOutPageLocator.privacyCheckbox.click();
			}
			public void clickContinueCheckout() {
			    try {
			        wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(30));
			        
			        ((JavascriptExecutor) HelperClass.getDriver()).executeScript(
			            "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", 
			            checkOutPageLocator.continueButton);
			        
			        wait.until(ExpectedConditions.elementToBeClickable(checkOutPageLocator.continueButton));
			        
			        ((JavascriptExecutor) HelperClass.getDriver()).executeScript(
			            "arguments[0].click();", 
			            checkOutPageLocator.continueButton);
			            
			    } catch (Exception e) {
			        System.out.println("Exception while clicking continue checkout: " + e.getMessage());
			        throw e;
			    }
			}
			
			
			public void confirmOrder() {
				wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(35));
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
		            String postcode, String country,String region) {
				
			    checkOutPageLocator.paymentFname.sendKeys(firstName);
					checkOutPageLocator.paymentLname.sendKeys(lastName);
					checkOutPageLocator.paymentAddress.sendKeys(address);
					checkOutPageLocator.paymentCity.sendKeys(city);
					checkOutPageLocator.paymentPostcode.sendKeys(postcode);
					
					selectDropdownByVisibleText(checkOutPageLocator.countryDropdown,country);
					
					wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
				    wait.until(ExpectedConditions.elementToBeClickable(checkOutPageLocator.regionDropdown));
					
					selectDropdownByVisibleText(checkOutPageLocator.regionDropdown,region);
					
					}
			
			       public void clickExistingAddButton() {
			    	   checkOutPageLocator.existingAdd.click();
			       }
			       public void clickNewAddressButton() {
			    	   checkOutPageLocator.newAdd.click();
			       }
			   
			       public void fillRegisterCheckoutForm(String firstName, String lastName, String email, 
			               String telephone,String password,String confirmPass, String address, String city, 
			               String postcode, String country,String region) {
			   			
			   			checkOutPageLocator.paymentFname.sendKeys(firstName);
			   			checkOutPageLocator.paymentLname.sendKeys(lastName);
			   			checkOutPageLocator.paymentEmail.sendKeys(email);
			   			checkOutPageLocator.paymentTelephone.sendKeys(telephone);
			   			checkOutPageLocator.pass.sendKeys(password);
			   			checkOutPageLocator.confirmpass.sendKeys(confirmPass);
			   			checkOutPageLocator.paymentAddress.sendKeys(address);
			   			checkOutPageLocator.paymentCity.sendKeys(city);
			   			checkOutPageLocator.paymentPostcode.sendKeys(postcode);
			   			
			   			
			   			selectDropdownByVisibleText(checkOutPageLocator.countryDropdown,country);
			   			
			   			wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
			   		    wait.until(ExpectedConditions.elementToBeClickable(checkOutPageLocator.regionDropdown));
			   			
			   			selectDropdownByVisibleText(checkOutPageLocator.regionDropdown,region);
			   			
			   			}
			       
			       public String getDuplicateEmailError() {
			    	  return checkOutPageLocator.duplicateEmail.getText();
			       }
			       
			       
			
}