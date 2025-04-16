
package com.definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import com.actions.OrderPageAction;

public class OrderDefinition {
    OrderPageAction orderPageAction = new OrderPageAction();

    @When("the user clicks on My Account in the top")
    public void theUserClicksOnMyAccountInTheTop() {
        orderPageAction.continue1(); 
    }

    @When("clicks my order history")
    public void clicks_my_order_history() {
        try {
            orderPageAction.clickOrderHistory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("the order history is displayed")
    public void the_order_history_is_displayed(){
//    	boolean isTableDisplayed = orderPageAction.printOrderHistoryTable();
//    	Assert.assertTrue(isTableDisplayed, "Order history table should be visible and printable.");
    	
    	    String orderHeader = orderPageAction.getTextOrder();
    	    Assert.assertTrue(orderHeader.contains("Order History"), "Order History heading should be visible.");
    	}


    }
