package com.definitions;

import com.utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistrationDefinition {
	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {
		HelperClass.openPage();
	}

	@When("the user clicks on {string}")
	public void the_user_clicks_on(String string) {
	    
	}

	@When("clicks the register button")
	public void clicks_the_register_button() {
	    
	}

	@Then("the user should see the registration page")
	public void the_user_should_see_the_registration_page() {
	    
	}

	@When("the user enters {string},{string},{string},{string},{string} and {string}")
	public void the_user_enters_and(String string, String string2, String string3, String string4, String string5, String string6) {
	    
	}

	@When("agrees to the Privacy Policy")
	public void agrees_to_the_privacy_policy() {
	    
	}

	@When("submits the registration form")
	public void submits_the_registration_form() {
	   
	}

	@Then("the user should see {string}")
	public void the_user_should_see(String string) {
	    
	}

	@When("the user enters the invalid inputs {string},{string},{string},{string},{string} and {string}")
	public void the_user_enters_the_invalid_inputs_and(String string, String string2, String string3, String string4, String string5, String string6) {
	    
	}
}
