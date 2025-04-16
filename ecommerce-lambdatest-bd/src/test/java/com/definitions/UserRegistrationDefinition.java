package com.definitions;

import org.junit.Assert;


import org.openqa.selenium.interactions.Action;
import com.actions.UserRegistrationAction;
import com.utilities.HelperClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistrationDefinition {
    UserRegistrationAction userRegistrationAction = new UserRegistrationAction();
    
    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        HelperClass.openPage();
    }

    @When("the user clicks on My Account.")
    public void the_user_clicks_on() {
        userRegistrationAction.clickMyAccounts();
       
    }

    @When("clicks the register button")
    public void clicks_the_register_button() {
    	 userRegistrationAction.clickRegister();
    }
    @Then("the user should see the registration page")
    public void the_user_should_see_the_registration_page() {
        userRegistrationAction.isRegistrationPageDisplayed();
    }

    @When("the user enters {string}, {string}, {string}, {string}, {string} and {string}")
    public void the_user_enters_and(String firstName, String lastName, String email, 
                                  String telephone, String password, String confirmPassword) {
//        userRegistrationAction.enterRegistrationDetails(firstName, lastName, email, 
//                                                       telephone, password, confirmPassword);
    	String uniqueEmail = "test" + System.currentTimeMillis() + "@example.com";
        userRegistrationAction.enterRegistrationDetails(firstName, lastName, uniqueEmail, 
                                                       telephone, password, confirmPassword);

    }

    @When("agrees to the Privacy Policy")
    public void agrees_to_the_privacy_policy() throws InterruptedException {
    	
        userRegistrationAction.agreeToPrivacyPolicy();
    	
    }
    
    @And("the user not agrees to the privacy policy")
    public void the_user_not_agrees_to_the_privacy_policy() {
    	System.out.println("user didnt accepted the privary policy");
    }
    

    @When("submits the registration form")
    public void submits_the_registration_form(){
        userRegistrationAction.submitRegistration();
        
    }

    @Then("the user should see {string}")
    public void the_user_should_see(String string) throws InterruptedException {
    	
    Assert.assertEquals(userRegistrationAction.RegisterationSuccess(),string);
    }

    @When("the user enters the invalid inputs {string}, {string}, {string}, {string}, {string} and {string}")
    public void the_user_enters_the_invalid_inputs_and(String firstName, String lastName, String email, 
                                                      String telephone, String password, String confirmPassword) {
        userRegistrationAction.enterRegistrationDetails(firstName, lastName, email, 
                                                      telephone, password, confirmPassword);
    }

    @Then("the user should see {string} for {string}")
    public void the_user_should_see_for(String errorMessage, String testCaseName) {
       if(testCaseName.equals("empty first name")) {
    	   
    	   Assert.assertEquals(errorMessage,userRegistrationAction.emptyFirstNameError());
       }
       else if(testCaseName.equals("existing email")) {
    	   
    	   Assert.assertEquals(errorMessage,userRegistrationAction.existingMailError());
		       }
       else if(testCaseName.equals("empty password")) {
    	    
    	   Assert.assertEquals(errorMessage,userRegistrationAction.emptyPasswordError());
		}
       else if(testCaseName.equals("password mismatch")) {
    	   
    	   Assert.assertEquals(errorMessage,userRegistrationAction.passwordMisMathError());
		}
       else if(testCaseName.equals("Not checking privacy policy")) {
    	   
    	   Assert.assertEquals(errorMessage,userRegistrationAction.uncheckedError());
       }
       
    }
}