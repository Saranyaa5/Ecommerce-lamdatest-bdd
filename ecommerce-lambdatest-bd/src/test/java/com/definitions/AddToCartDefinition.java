package com.definitions;

import org.testng.Assert;
import com.actions.AddToCartAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartDefinition {

    AddToCartAction cartAction = new AddToCartAction();

    @When("user clicks the Phones & PDAs category")
    public void clickPhonesCategory() {
        cartAction.clickOnCategory();
    }

    @When("user selects the iPod Nano product")
    public void selectProduct() {
        cartAction.selectProduct();
    }

    @When("user clicks on the Add to Cart button")
    public void clickAddToCart() {
        cartAction.clickAddToCart();
    }

    @Then("user should see a confirmation message stating {string}")
    public void verifySuccessMessage(String expectedMessage) {
        String actualMsg = cartAction.getSuccessMessage();
        Assert.assertTrue(actualMsg.contains(expectedMessage), "Actual message: " + actualMsg);
    }

    @When("user views the shopping cart")
    public void viewShoppingCart() {
        cartAction.viewShoppingCart();
    }

    @And("user removes iPod Nano from the cart")
    public void removeiPodNano() {
        cartAction.removeiPodNano();
    }

    @Then("the shopping cart should display {string}")
    public void verifyEmptyCartMessage(String expectedMessage) {
    	if(expectedMessage.equals("Your shopping cart is empty!")) {
        String text = cartAction.getEmptyCartMessage();
        Assert.assertTrue(text.contains(expectedMessage), "Actual message: " + text);}
    	else {
    		String text1 = cartAction.ProductQuantity();
            Assert.assertTrue(text1.contains(expectedMessage), "Actual message: " + text1);
    	}
    }
    
    @And("user sets the quantity to 3")
    public void SetQuantity() {
    	cartAction.setQuantity();
    }
    
    @And("user selects the Apple Cinema 30 product")
    public void SelectAppleCinema30() {
    	cartAction.selectAppleCinema();
    }
    
    
    @Then("user should see a message {string}")
    public void sizeReq(String expectedMessage) {
        String actualMsg = cartAction.getSizeReq();
        Assert.assertTrue(actualMsg.contains(expectedMessage), "Actual message: " + actualMsg);
    }
    
    
    
    
}