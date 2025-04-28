package com.definitions;

import org.testng.Assert;

import com.actions.EstimateShippingACtion;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EstimateShippingDefinition {

	EstimateShippingACtion estimateshippingaction = new EstimateShippingACtion();

@When("the user clicks on the Shopping Cart")
public void the_user_clicks_on_the_shopping_cart() {
    
	estimateshippingaction.Shoppingcart();
}

@When("the user clicks the Edit Cart button")
public void the_user_clicks_the_edit_cart_button() {
	estimateshippingaction.EditCartbutton();
}

@When("the user clicks the Estimate Shipping and Taxes button")
public void the_user_clicks_the_estimate_shipping_and_taxes_button() {
	estimateshippingaction.EstimateShippingButton();
}

@When("the user enters the required shipping details")
public void the_user_enters_the_required_shipping_details() {
	estimateshippingaction.EnterDetails();
}

@When("the user clicks the Get Quotes button")
public void the_user_clicks_the_get_quotes_button() {
	estimateshippingaction.GetQuotesButton();
	
}

@When("the user selects Flat Shipping Rate and clicks Apply Shipping button")
public void the_user_selects_flat_shipping_rate_and_clicks_apply_shipping_button() {
	estimateshippingaction.selectsFlatShippingRate();
	
}


@Then("the user should see message {string}")
public void  the_user_should_see_message(String expected) {
	String actual = estimateshippingaction.EstimateShippingSuccessmsg();
	Assert.assertTrue(actual.contains(expected));
	
}

	
	
}
