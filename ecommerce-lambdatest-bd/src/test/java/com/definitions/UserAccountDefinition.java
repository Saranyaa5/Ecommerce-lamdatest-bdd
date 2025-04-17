package com.definitions;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.actions.UserAccountAction;
import com.utilities.ExcelReader;
import com.utilities.HelperClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import jdk.internal.org.jline.utils.Log;

public class UserAccountDefinition {

    UserAccountAction userAccountAction = new UserAccountAction();
    private static final Logger logger = LogManager.getLogger(UserAccountDefinition.class);
    
    @Given("the user is on the My Account Page")
    public void the_user_is_on_the_My_Account_Page(){
    	  HelperClass.getDriver().get("https://ecommerce-playground.lambdatest.io/");
    }

    @Then("the user clicks the {string} page")
    public void the_user_clicks_the_edit_account_info_page(String pageName) {
        switch (pageName) {
            case "Edit your account information":
                userAccountAction.EditInformation();
                break;
            case "Change your password":
                userAccountAction.changePassword();
                break;
            case "Modify your wish list":
                userAccountAction.ModifyWishlist();
                break;
            case "Newsletter":
                userAccountAction.ClickNewsLetter();
                break;
            case "Modify your address book entries":
            	userAccountAction.ClickModifyAddress();
            	break;
            default:
                throw new IllegalArgumentException("Unknown page: " + pageName);
        }
    }
    @And("the user clicks new address")
    public void ClickNewAddress() {
    	userAccountAction.clickNewAddress();
    }

    @And("the user updates telephone number")
    public void the_user_updates_telephone_number() {
        userAccountAction.UpdateTelephoneNumber();
    }

  


    @Then("user should see {string}")
    public void user_should_see_success_message(String expectedMessage) {
        String actualMessage = "";
        switch (expectedMessage) {
            case "Success: Your account has been successfully updated.":
                actualMessage = userAccountAction.Edited();
                break;
            case "Success: Your password has been successfully updated.":
                actualMessage = userAccountAction.PasswordChanged();
               
                break;
            case "Success: You have modified your wish list!":
                actualMessage = userAccountAction.ModifiedWishList();
                break;
            case "Success: Your newsletter subscription has been successfully updated!":
                actualMessage = userAccountAction.NewsLetterUpdated();
                break;
            case "Password must be between 4 and 20 characters!":
            	actualMessage = userAccountAction.PasswordEmpty();
            	break;
            case "Your address has been successfully added":
            	actualMessage = userAccountAction.NewAddressCreated();
            	break;
            default:
                throw new IllegalArgumentException("Unknown message: " + expectedMessage);
        }

        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    @And("the user enters current password and new password details")
    public void EntersNewPass() {
        userAccountAction.EntersnewPass();
    }

    @And("clicks on the {string} Continue button")
    public void clicks_on_the_continue_button(String button) {
    	if(button.equals("EditInfo")) {
    		userAccountAction.EditContinue();
    	}
    	else if(button.equals("ChangePassword")) {
    		userAccountAction.ClickPassContinue();
    	}
    	else if(button.equals("NewAddress")) {
    		userAccountAction.ModifyAddressContinue();
    	}
    	else{
    		userAccountAction.clickNewsLetterContinue();
    	}
    }

    @And("the user has products in their wishlist")
    public void ProductInTheWishList() {
        logger.info("product in the wish list");
    }

    @And("the user removes a product from the wishlist")
    public void RemoveFromWishList() {
        userAccountAction.RemoveFromWishList();
    }

    @And("the user chooses to {string} the newsletter")
    public void the_user_chooses_newsletter_action(String action) {
        userAccountAction.selectNewsletterOption(action);
    }

    
    
    @And("the user enters the valid credentials")
    public void the_user_enters_the_valid_credentials() {
    	userAccountAction.EnterCredentialsForMyAccount();
    
    	
    }
    
    @And("user enters valid details")
    public void user_enters_valid_details() {
        try {
            List<Map<String, String>> testData = ExcelReader.getAddressData();
            String firstName = testData.get(0).get("firstname");
            String lastName = testData.get(0).get("lastname");
            String address = testData.get(0).get("address");
            String city = testData.get(0).get("city");
            String postcode = testData.get(0).get("postcode");

            userAccountAction.enterAddressDetails(firstName, lastName, address, city, postcode);
        } catch (Exception e) {
            throw new RuntimeException("Failed to enter valid details: " + e.getMessage(), e);
        }
    }

   
}