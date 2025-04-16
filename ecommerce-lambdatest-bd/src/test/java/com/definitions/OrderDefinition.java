package com.definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;

import  com.actions.*;
public class OrderDefinition {
	OrderPageAction OrderPageAction=new OrderPageAction();
	
	@When("the user clicks on My Account in the top")
	public void theUserClicksOnMyAccountInTheTop() {
		OrderPageAction.clickAccountsButton();
	}
	
	@When("clicks my order history")
	public void clicks_my_order_history() {
		OrderPageAction.clickOrderHistory();
	}

	@Then("the order history is dispalyed")
	public void the_order_history_is_dispalyed() {
		String id=OrderPageAction.getOrderId();
		System.out.println("order id is:"+id);
	   Assert.assertTrue(id!=null);
	}

	@When("user clicks view button")
	public void user_clicks_view_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks reorder button")
	public void the_user_clicks_reorder_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the product reordered message should be displayed")
	public void the_product_reordered_message_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the user clicks return button")
	public void the_user_clicks_return_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the product return button should be displayed")
	public void the_product_return_button_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
