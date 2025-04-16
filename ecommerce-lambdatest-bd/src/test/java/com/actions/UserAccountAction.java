package com.actions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.LoginPageLocator;
import com.pages.UserAccountLocator;
import com.utilities.HelperClass;


public class UserAccountAction {

    WebDriver driver = HelperClass.getDriver();
    UserAccountLocator userAccountLocator;
    LoginPageLocator loginPageLocator;
    WebDriverWait wait;
   
    public UserAccountAction() {
        userAccountLocator = new UserAccountLocator();
        PageFactory.initElements(driver, userAccountLocator);
        loginPageLocator = new LoginPageLocator();
        PageFactory.initElements(HelperClass.getDriver(), loginPageLocator);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void EditInformation() {
    	 WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
         wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.EditInfo)).click();
    }
    public void changePassword() {
        WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.ChangePass)).click();
    }

    public void ModifyWishlist() {
    	 WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
         wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.ModifyWishlist)).click();
    }
    public void ClickNewsLetter() {
    	 WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
         wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.clickNewsLetter)).click();
    }
    public void UpdateTelephoneNumber() {
        userAccountLocator.Telephone.clear();
        userAccountLocator.Telephone.sendKeys("8825428889");
    }

    public void EditContinue() {
        WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.EditContinue)).click();
    }

    public String Edited() {
        return userAccountLocator.Edited.getText();
    }



    public String PasswordChanged() {
        return userAccountLocator.PassChanged.getText();
    }

    public void EntersnewPass() {
    	 userAccountLocator.Password.sendKeys("KIOT"); 
         userAccountLocator.ConfirmPassword.sendKeys("KIOT"); 
    }
 


    public void ClickPassContinue() {
        WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.PassContinue)).click();
    }


    

    public void RemoveFromWishList() {
        WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
        List<WebElement> removeButtons = HelperClass.getDriver().findElements(By.cssSelector("a.btn.btn-light.btn-sm.text-danger"));

        if (!removeButtons.isEmpty()) {
            WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(removeButtons.get(0)));
            removeButton.click();
            System.out.println("Product removed from wishlist.");
        } else {
            System.out.println("No product in Wishlist to remove.");
        }
    }


    public String ModifiedWishList() {
        return userAccountLocator.ModifiedWishList.getText();
    }

   

    public void selectNewsletterOption(String action) {
        wait.until(ExpectedConditions.visibilityOf(userAccountLocator.subscribeRadio));
        if (action.equalsIgnoreCase("subscribe")) {
            userAccountLocator.subscribeRadio.click();
        } else if (action.equalsIgnoreCase("unsubscribe")) {
            userAccountLocator.unsubscribeRadio.click();
        }
    }

    public void clickNewsLetterContinue() {
        WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.NewsLettercontinue)).click();
    }

    public String NewsLetterUpdated() {
        return userAccountLocator.newsLetterUpdated.getText();
    }

	public void EnterCredentialsForMyAccount() {
	

		loginPageLocator.emailId.sendKeys("2k21eee40@kiot.ac.in");
		loginPageLocator.password.sendKeys("KIOT"); 
		
	}

	public String PasswordEmpty() {
		 return userAccountLocator.PasswordEmpty.getText();
	}

	public void ClickModifyAddress() {
		WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.ModifyAddress)).click();
		
	}

	public void clickNewAddress() {

		 WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
	        wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.newAddress)).click();
	}

	public void ModifyAddressContinue() {

		 WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
	        wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.modifyAddressContinue)).click();
	}

	public String NewAddressCreated() {
		 
	       return wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.newAddressCreated)).getText();
	     
	}

	public void enterAddressDetails(String firstName, String lastName, String address, String city, String postcode) {
userAccountLocator.getFirstNameField.sendKeys( firstName);
  userAccountLocator.getLastNameField.sendKeys( lastName);
    userAccountLocator.getAddressField.sendKeys(address);
    userAccountLocator.getCityField.sendKeys(city);
    userAccountLocator.getPostcodeField.sendKeys(postcode);
    userAccountLocator.countrySelect.click();
    userAccountLocator.unitedstates.click();
    wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.state)).click();
    wait.until(ExpectedConditions.elementToBeClickable(userAccountLocator.Abeerdan)).click();

}

}