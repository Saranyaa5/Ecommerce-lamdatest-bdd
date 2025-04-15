package com.definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.actions.AffiliateAccountAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AffiliateAccountDefinition {

	AffiliateAccountAction action = new AffiliateAccountAction(); // Ensure initialized

	// Register
	@When("the user clicks on register for affiliate account")
	public void the_user_clicks_on_register_for_affiliate_account() {
		action.clickRegister();
	}

	@When("enters payee name")
	public void enters_payee_name() {
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

	@Then("the user should see the edit your affiliate account")
	public void the_user_should_see_the_edit_your_affiliate_account() {
		String text = action.editOption();
		assertEquals(text, "Edit your affiliate information");
	}

	// Edit
	@When("the user clicks on Edit your affiliate information")
	public void the_user_clicks_on_edit_your_affiliate_information() {
		action.clickAffiliate();
	}

	@When("enters {string} as account name")
	public void enters_as_account_name(String accName) {
		action.affiliateaccName(accName);
	}

	@When("enters {string} as account number")
	public void enters_as_account_number(String accNumber) {
		action.affiliateaccNumber(accNumber);
	}

	@When("clicks on continue button")
	public void clicks_on_continue_button() {
		action.clickContinue();
	}

	@Then("the user should see account created {string}")
	public void the_user_should_see_account_created(String expectedMessage) {
		String actualMessage = action.accountText();
		assertTrue(actualMessage.contains(expectedMessage), "Expected message not matched!");
	}

	// Tracking code
	@When("the user clicks on custom affiliate tracking code")
	public void the_user_clicks_on_custom_affiliate_tracking_code() {
		action.clickTracking();
	}

	@Then("the user sees tracking code")
	public void the_user_sees_tracking_code() {
		String trackingValue = action.getTrackingCode();
		assertTrue(trackingValue != null && !trackingValue.isEmpty(), "Tracking code is empty or null!");
	}

	@Then("clicks on continue")
	public void clicks_on_continue() {
		action.clickTrackingContinue();
	}
}
