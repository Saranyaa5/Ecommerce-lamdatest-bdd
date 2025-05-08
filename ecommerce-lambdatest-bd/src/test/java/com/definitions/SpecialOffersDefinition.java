package com.definitions;

import org.testng.Assert;
import com.actions.SpecialOffersAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SpecialOffersDefinition {
	SpecialOffersAction specialOffersAction = new SpecialOffersAction();
	
	@When("the user clicks on the special offers")
	public void the_user_clicks_on_the_special_offers() {
		specialOffersAction.clickSpecialOffersButton();
	}

	@Then("the user should see the special offers available")
	public void the_user_should_see_the_special_offers_available() {
		String headingText = specialOffersAction.getSpecialOfferText();
		Assert.assertEquals(headingText, "Special Offers");
	}
}
