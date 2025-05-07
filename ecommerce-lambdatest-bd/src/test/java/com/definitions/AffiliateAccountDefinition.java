package com.definitions;

import static org.testng.Assert.assertTrue;
import com.actions.AffiliateAccountAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AffiliateAccountDefinition {

	AffiliateAccountAction action = new AffiliateAccountAction(); 

	@Given("the user is already registered and on the account page")
	public void the_user_is_already_registered_and_on_the_account_page() throws InterruptedException {
		// This step is assumed to be handled in the background 
	}
	@When("the user clicks on continue on register")
	public void the_user_clicks_on_continue_on_register() throws InterruptedException {
	   action.clickaccContinue();
	}	
	
	@When("the user clicks on register your affiliate information")
	public void the_user_clicks_on_register_your_affiliate_information() {
	  action.clickRegister();
	}

	@When("enters payee name {string}")
	public void enters_payee_name(String string) {
	  action.enterPayee();
	}
	@When("clicks on checkbox")
	public void clicks_on_checkbox() {
		action.clickCheckbox();
	}

	@When("clicks on register continue button")
	public void clicks_on_register_continue_button() {
		action.conitnue1();
	}
	
	@Then("the user sees {string} based on {string}")
	public void the_user_sees_based_on(String expectedMessage, String check) {
	    if (check.equalsIgnoreCase("valid")) {
	        String actualSuccess = action.successMessage();
	        assertTrue(actualSuccess.contains(expectedMessage), "Expected success message not found!");
	    } else {
	        throw new IllegalArgumentException("Invalid check value. Must be 'valid' or 'invalid'");
	    }
	}
}