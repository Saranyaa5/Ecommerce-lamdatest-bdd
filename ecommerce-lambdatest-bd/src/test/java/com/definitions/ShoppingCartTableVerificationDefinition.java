package com.definitions;

import org.testng.Assert;

import com.actions.ShoppingCartTableVerificationAction;

import io.cucumber.java.en.Then;

public class ShoppingCartTableVerificationDefinition {
	ShoppingCartTableVerificationAction action = new ShoppingCartTableVerificationAction();
	@Then("the shopping cart should display {string} in the product name column")
	public void the_shopping_cart_should_display_product(String expected) {
	    String text = action.verifyProductIsInTable(expected);
	    System.out.println("text:" +text);
	    Assert.assertTrue(text.contains(expected));
	}

	
	
}
