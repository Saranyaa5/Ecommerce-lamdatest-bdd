
package com.actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.pages.ForgotPasswordLocator;
import com.utilities.HelperClass;

public class ForgotPasswordAction {

    ForgotPasswordLocator forgotPage = new ForgotPasswordLocator();

    
  

    public void clickForgotPassword() {
        forgotPage.forgotPasswordLink.click();
    }

    public void enterEmail(String email) {
        forgotPage.emailInput.clear();
        forgotPage.emailInput.sendKeys(email);
    }

    public void clickContinueButton() {
        forgotPage.continueButton.click();
    }

    public String verifySuccessMessage() {
return forgotPage.successAlert.getText();
    }

    public String verifyErrorMessage() {
       return forgotPage.errorAlert.getText();
    }
}
