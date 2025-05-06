package com.definitions;

import org.testng.Assert;

import com.actions.FAQAction;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class FAQDefinition {
	
FAQAction faqaction = new FAQAction();

	
	@And ("the user clicks frequently asked question")
	public void the_user_clicks_all_frequently_asked_questions() {
		faqaction.validateFAQButtons();
	}
	
	
	@Then("the user should see the FAQ message {string}")
	public void user_should_see_the_faq_message(String expectedText) {

	   String actualMessages = faqaction.faqmessageList();
	    Assert.assertTrue(actualMessages.contains(expectedText));
	}

	
}


