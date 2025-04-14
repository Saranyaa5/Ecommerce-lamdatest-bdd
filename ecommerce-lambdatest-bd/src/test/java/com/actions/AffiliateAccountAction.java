package com.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.pages.AffiliateAccountLocator;
import com.utilities.HelperClass;

public class AffiliateAccountAction {
    
    WebDriver driver;
    AffiliateAccountLocator affiliate;

    public AffiliateAccountAction() {
        this.driver = HelperClass.getDriver();
        this.affiliate = new AffiliateAccountLocator();
        PageFactory.initElements(driver, affiliate);
    }

    //register
    public void clickRegister() {
    	affiliate.registerAffiliate.click();
    }
    
    public void enterPayee() {
    	affiliate.payeeName.sendKeys("jeev");
    }
    
    public void clickCheckbox() {
    	affiliate.checkbox.click();
    }
    
    public void conitnue1() {
    	affiliate.affContinue1.click();
    }
    
    public String editOption() {
    	return affiliate.affiliateButton.getText();
    }
    
    
    //edit
    public void clickAffiliate() {
        affiliate.affiliateButton.click();  
    }

   public void affiliateaccName(String accName) {
	   affiliate.accountName.sendKeys(accName);
   }
   public void affiliateaccNumber(String accNumber) {
	   affiliate.accountNumber.sendKeys(accNumber);
   }
   public void clickContinue() {
	   affiliate.affContinue2.click();
   }
   public String accountText() {
	   return affiliate.affText.getText();
   }
   
   //trackingCode
   public void clickTracking() {
	   affiliate.trackingAffiliate.click();
   }
   public String getTrackingCode() {
	    return affiliate.trackingCode.getAttribute("value");
	}

	public void clickTrackingContinue() {
	    affiliate.affContinue3.click();
	}
   
  
   
}
