package com.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.pages.AddToCartLocator;
import com.pages.CheckOutPageLocator;
import com.pages.SearchLocator;
import com.utilities.HelperClass;

public class CheckOutAction {
    CheckOutPageLocator checkOutPageLocator = null;
    SearchLocator searchLocator;
    AddToCartLocator cartLocator;
    
    public CheckOutAction() {
        this.searchLocator = new SearchLocator();
        checkOutPageLocator = new CheckOutPageLocator();
        PageFactory.initElements(HelperClass.getDriver(), checkOutPageLocator);
        new Actions(HelperClass.getDriver());
    }
    
    public void searchProdut(String string) {
        checkOutPageLocator.searchbox.sendKeys(Keys.CONTROL + "a");
        checkOutPageLocator.searchbox.sendKeys(Keys.BACK_SPACE);
        checkOutPageLocator.searchbox.sendKeys(string);
        checkOutPageLocator.searchbutton.click();
    }
    
    public void selectSearchProduct() {
        if(checkOutPageLocator.productImage.isDisplayed()) {
            checkOutPageLocator.productImage.click();
        }
    }
    
    public void productCheckOut() {
        if(checkOutPageLocator.checkoutFromCart.isEnabled()) {
            checkOutPageLocator.checkoutFromCart.click();
        }
    }
    
    public void selectGuestUser() {
        if(checkOutPageLocator.guestUser.isDisplayed()) {
            checkOutPageLocator.guestUser.click();
        }
    }
    
    public void selectRegUser() {
        if(checkOutPageLocator.registerUser.isDisplayed()) {
            checkOutPageLocator.registerUser.click();
        }
    }
    
    public void reomveProduct() {
        if(checkOutPageLocator.removeProduct.isEnabled()) {
            checkOutPageLocator.removeProduct.click();
        }
    }
    
    public void fillGuestCheckoutForm(String firstName, String lastName, String email, 
            String telephone, String address, String city, 
            String postcode, String country, String region) {
        
        if(checkOutPageLocator.paymentFname.isDisplayed()) {
            checkOutPageLocator.paymentFname.sendKeys(firstName);
        }
        if(checkOutPageLocator.paymentLname.isDisplayed()) {
            checkOutPageLocator.paymentLname.sendKeys(lastName);
        }
        if(checkOutPageLocator.paymentEmail.isDisplayed()) {
            checkOutPageLocator.paymentEmail.sendKeys(email);
        }
        if(checkOutPageLocator.paymentTelephone.isDisplayed()) {
            checkOutPageLocator.paymentTelephone.sendKeys(telephone);
        }
        if(checkOutPageLocator.paymentAddress.isDisplayed()) {
            checkOutPageLocator.paymentAddress.sendKeys(address);
        }
        if(checkOutPageLocator.paymentCity.isDisplayed()) {
            checkOutPageLocator.paymentCity.sendKeys(city);
        }
        if(checkOutPageLocator.paymentPostcode.isDisplayed()) {
            checkOutPageLocator.paymentPostcode.sendKeys(postcode);
        }
        
        if(checkOutPageLocator.countryDropdown.isDisplayed()) {
            selectDropdownByVisibleText(checkOutPageLocator.countryDropdown, country);
        }
        
        if(checkOutPageLocator.regionDropdown.isDisplayed()) {
            selectDropdownByVisibleText(checkOutPageLocator.regionDropdown, region);
        }
    }
    
    private void selectDropdownByVisibleText(WebElement dropdown, String value) {
        if(dropdown.isDisplayed()) {
            Select select = new Select(dropdown);
            select.selectByVisibleText(value);
        }
    }
    
    public void acceptGuestTermsCondition() {
        try {
            WebElement termsCheckbox = HelperClass.getDriver().findElement(
                By.xpath("//*[@id='form-checkout']/div/div[2]/div/div[5]/label"));
            
            if(termsCheckbox.isDisplayed()) {
                ((JavascriptExecutor) HelperClass.getDriver()).executeScript(
                    "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", 
                    termsCheckbox);
                
                if(termsCheckbox.isEnabled()) {
                    ((JavascriptExecutor) HelperClass.getDriver()).executeScript(
                        "arguments[0].click();", termsCheckbox);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception while accepting terms: " + e.getMessage());
            throw e;
        }
    }
    
    public void clickPrivacyPolicy() {
        if(checkOutPageLocator.privacyCheckbox.isDisplayed()) {
            checkOutPageLocator.privacyCheckbox.click();
        }
    }
    
    public void clickContinueCheckout() {
        try {
            if(checkOutPageLocator.continueButton.isDisplayed()) {
                ((JavascriptExecutor) HelperClass.getDriver()).executeScript(
                    "arguments[0].scrollIntoView({block: 'center', behavior: 'smooth'});", 
                    checkOutPageLocator.continueButton);
                
                if(checkOutPageLocator.continueButton.isEnabled()) {
                    ((JavascriptExecutor) HelperClass.getDriver()).executeScript(
                        "arguments[0].click();", 
                        checkOutPageLocator.continueButton);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception while clicking continue checkout: " + e.getMessage());
            throw e;
        }
    }
    
    public void confirmOrder() {
        if(checkOutPageLocator.confirmOrder.isEnabled()) {
            checkOutPageLocator.confirmOrder.click();
        }
    }
    
    public boolean OrderSuccessMsg() {
        return checkOutPageLocator.orderSuccessMessage.isDisplayed();
    }
    
    public String EmptyCartMessage() {
        if(checkOutPageLocator.emptyCartMessage.isDisplayed()) {
            return checkOutPageLocator.emptyCartMessage.getText();
        }
        return "";
    }
    
    public void fillPaymentCheckoutForm(String firstName, String lastName, 
            String address, String city, 
            String postcode, String country, String region) {
        
        if(checkOutPageLocator.paymentFname.isDisplayed()) {
            checkOutPageLocator.paymentFname.sendKeys(firstName);
        }
        if(checkOutPageLocator.paymentLname.isDisplayed()) {
            checkOutPageLocator.paymentLname.sendKeys(lastName);
        }
        if(checkOutPageLocator.paymentAddress.isDisplayed()) {
            checkOutPageLocator.paymentAddress.sendKeys(address);
        }
        if(checkOutPageLocator.paymentCity.isDisplayed()) {
            checkOutPageLocator.paymentCity.sendKeys(city);
        }
        if(checkOutPageLocator.paymentPostcode.isDisplayed()) {
            checkOutPageLocator.paymentPostcode.sendKeys(postcode);
        }
        
        if(checkOutPageLocator.countryDropdown.isDisplayed()) {
            selectDropdownByVisibleText(checkOutPageLocator.countryDropdown, country);
        }
        
        if(checkOutPageLocator.regionDropdown.isDisplayed()) {
            selectDropdownByVisibleText(checkOutPageLocator.regionDropdown, region);
        }
    }
    
    public void clickExistingAddButton() {
        if(checkOutPageLocator.existingAdd.isEnabled()) {
            checkOutPageLocator.existingAdd.click();
        }
    }
    
    public void clickNewAddressButton() {
        if(checkOutPageLocator.newAdd.isEnabled()) {
            checkOutPageLocator.newAdd.click();
        }
    }
    
    public void fillRegisterCheckoutForm(String firstName, String lastName, String email, 
            String telephone, String password, String confirmPass, String address, String city, 
            String postcode, String country, String region) {
        
        if(checkOutPageLocator.paymentFname.isDisplayed()) {
            checkOutPageLocator.paymentFname.sendKeys(firstName);
        }
        if(checkOutPageLocator.paymentLname.isDisplayed()) {
            checkOutPageLocator.paymentLname.sendKeys(lastName);
        }
        if(checkOutPageLocator.paymentEmail.isDisplayed()) {
            checkOutPageLocator.paymentEmail.sendKeys(email);
        }
        if(checkOutPageLocator.paymentTelephone.isDisplayed()) {
            checkOutPageLocator.paymentTelephone.sendKeys(telephone);
        }
        if(checkOutPageLocator.pass.isDisplayed()) {
            checkOutPageLocator.pass.sendKeys(password);
        }
        if(checkOutPageLocator.confirmpass.isDisplayed()) {
            checkOutPageLocator.confirmpass.sendKeys(confirmPass);
        }
        if(checkOutPageLocator.paymentAddress.isDisplayed()) {
            checkOutPageLocator.paymentAddress.sendKeys(address);
        }
        if(checkOutPageLocator.paymentCity.isDisplayed()) {
            checkOutPageLocator.paymentCity.sendKeys(city);
        }
        if(checkOutPageLocator.paymentPostcode.isDisplayed()) {
            checkOutPageLocator.paymentPostcode.sendKeys(postcode);
        }
        
        if(checkOutPageLocator.countryDropdown.isDisplayed()) {
            selectDropdownByVisibleText(checkOutPageLocator.countryDropdown, country);
        }
        
        if(checkOutPageLocator.regionDropdown.isDisplayed()) {
            selectDropdownByVisibleText(checkOutPageLocator.regionDropdown, region);
        }
    }
    
    public String getDuplicateEmailError() {
        if(checkOutPageLocator.duplicateEmail.isDisplayed()) {
            return checkOutPageLocator.duplicateEmail.getText();
        }
        return "";
    }
}