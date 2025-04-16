
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
    	Assert.assertTrue(orderPageAction.eyeDisplayed());
    	   
    	}
    @When("user clicks view button")
    public void user_clicks_view_button() {
        orderPageAction.clickViewButton();
    }

    @When("the user clicks reorder button")
    public void the_user_clicks_reorder_button() {
        orderPageAction.clickReorderButton();
    }

    @Then("the product reordered message should be displayed")
    public void the_product_reordered_message_should_be_displayed() {
        Assert.assertTrue(orderPageAction.isReorderMessageDisplayed());
    }



    }
