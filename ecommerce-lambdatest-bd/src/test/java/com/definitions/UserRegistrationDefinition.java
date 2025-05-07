package com.definitions;

import org.junit.Assert;

import com.actions.UserRegistrationAction;
import com.utilities.HelperClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserRegistrationDefinition {
    UserRegistrationAction userRegistrationAction = new UserRegistrationAction();
    private static final Logger logger = LogManager.getLogger(UserRegistrationDefinition.class);
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
    	 logger.info("User didn't accept the privacy policy");
    }
    

    @When("submits the registration form")
    public void submits_the_registration_form(){
        userRegistrationAction.submitRegistration();
        
    }

    @Then("the user should see {string}")
    public void the_user_should_see(String expectedMessage) throws InterruptedException {
        
        try {
            Assert.assertEquals(expectedMessage, userRegistrationAction.RegisterationSuccess());
            logger.info("Assertion Passed: Expected message '{}' is displayed successfully.", expectedMessage);
        } catch (AssertionError e) {
            logger.error("Assertion Failed: Expected '{}', but got '{}'", expectedMessage, userRegistrationAction.RegisterationSuccess());
            throw e; 
        }
    }


    @When("the user enters the invalid inputs {string}, {string}, {string}, {string}, {string} and {string}")
    public void the_user_enters_the_invalid_inputs_and(String firstName, String lastName, String email, 
                                                      String telephone, String password, String confirmPassword) {
        userRegistrationAction.enterRegistrationDetails(firstName, lastName, email, 
                                                      telephone, password, confirmPassword);
    }

    @Then("the user should see {string} for {string}")
    public void the_user_should_see_for(String expectedMessage, String testCaseName) throws InterruptedException {
        String actualMessage = "";
        
        try {
            switch (testCaseName) {
                case "empty first name":
                    actualMessage = userRegistrationAction.emptyFirstNameError();
                    break;
                case "existing email":
                    actualMessage = userRegistrationAction.existingMailError();
                    break;
                case "empty password":
                    actualMessage = userRegistrationAction.emptyPasswordError();
                    break;
                case "password mismatch":
                    actualMessage = userRegistrationAction.passwordMisMathError();
                    break;
                case "Not checking privacy policy":
                    actualMessage = userRegistrationAction.uncheckedError();
                    break;
                default:
                    logger.warn("Unknown test case name: {}", testCaseName);
                    return;
            }

            Assert.assertEquals(expectedMessage, actualMessage);
            logger.info("Assertion Passed for '{}': Expected and actual message matched: '{}'", testCaseName, expectedMessage);

        } catch (AssertionError e) {
            logger.error("Assertion Failed for '{}': Expected '{}', but got '{}'", testCaseName, expectedMessage, actualMessage);
            throw e;
        }
    }

}