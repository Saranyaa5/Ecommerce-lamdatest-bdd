package com.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.pages.UserAccountLocator;
import com.utilities.HelperClass;

public class UserAccountAction {

    UserAccountLocator locator = new UserAccountLocator();

    public UserAccountAction() {
        PageFactory.initElements(HelperClass.getDriver(), locator);
    }

    public void EnterCredentialsForMyAccount() {
        locator.myAccountDropdown.click();
        locator.loginLink.click();
        locator.emailField.sendKeys("testuser@example.com");
        locator.passwordField.sendKeys("password123");
        locator.loginButton.click();
    }

    public void EditInformation() {
        locator.editAccountLink.click();
    }

    public void UpdateTelephoneNumber() {
        locator.telephoneField.clear();
        locator.telephoneField.sendKeys("9876543210");
    }

    public void EditContinue() {
        locator.continueBtn.click();
    }

    public String Edited() {
        return locator.successMessage.getText();
    }

    public void changePassword() {
        locator.changePasswordLink.click();
    }

    public void EntersnewPass() {
        locator.newPassword.sendKeys("test1234");
        locator.confirmPassword.sendKeys("test1234");
    }

    public void ClickPassContinue() {
        locator.continueBtn.click();
    }

    public String PasswordChanged() {
        return locator.successMessage.getText();
    }

    public String PasswordEmpty() {
        return locator.newPassword.getAttribute("validationMessage");
    }

    public void ModifyWishlist() {
        locator.wishListLink.click();
    }

    public void RemoveFromWishList() {
        locator.removeWishListItem.click();
    }

    public String ModifiedWishList() {
        return locator.successMessage.getText();
    }

    public void ClickNewsLetter() {
        locator.newsletterLink.click();
    }

    public void selectNewsletterOption(String option) {
        if (option.equalsIgnoreCase("subscribe")) {
            locator.subscribeYesRadio.click();
        } else {
            locator.subscribeNoRadio.click();
        }
    }

    public void clickNewsLetterContinue() {
        locator.continueBtn.click();
    }

    public String NewsLetterUpdated() {
        return locator.successMessage.getText();
    }

    public void ClickModifyAddress() {
        locator.addressBookLink.click();
    }

    public void clickNewAddress() {
        locator.newAddressBtn.click();
    }

    public void enterAddressDetails(String fname, String lname, String address, String city, String postcode) {
        locator.firstNameField.sendKeys(fname);
        locator.lastNameField.sendKeys(lname);
        locator.address1Field.sendKeys(address);
        locator.cityField.sendKeys(city);
        locator.postCodeField.sendKeys(postcode);

        Select country = new Select(locator.countryDropdown);
        country.selectByVisibleText("United States");

        Select region = new Select(locator.regionDropdown);
        region.selectByVisibleText("California");

        locator.defaultAddressYes.click();
    }

    public void ModifyAddressContinue() {
        locator.addressContinueBtn.click();
    }

    public String NewAddressCreated() {
        return locator.successMessage.getText();
    }
}
