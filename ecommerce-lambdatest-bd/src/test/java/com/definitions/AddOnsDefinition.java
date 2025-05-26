package com.definitions;

import org.junit.Assert;

import com.actions.AddOnsAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddOnsDefinition {

    AddOnsAction addonAction = new AddOnsAction();
    int intial_alt_count=0;

    @When("the user clicks on addons")
    public void the_user_clicks_on_addons() {
        addonAction.clickAddons();
    }

    @When("clicks on designs option")
    public void clicks_on_designs_option() {
        addonAction.clickDesignMenu();
    }

    @Then("the user should see the design page")
    public void the_user_should_see_the_design_page() {
        String expectedText = "Alert"; 
        String actualText = addonAction.getAlertText();
        Assert.assertTrue("Design page is not visible!", actualText.contains(expectedText));
    }
    
    @When("the user romoves one of the alert")
    public void the_user_romoves_one_of_the_alert() throws InterruptedException {
    	intial_alt_count=addonAction.getAlertDivsCount();
    	addonAction.removeAlert();
    	Thread.sleep(10000);
    }

    @Then("the alert count should be reduced")
    public void the_alert_count_should_be_reduced() {
    	int current_alt_count=addonAction.getAlertDivsCount();
    	boolean removed=current_alt_count<=intial_alt_count;
    	try {
    	Assert.assertTrue(removed);
    	}
    	catch(AssertionError e){
    		System.out.println("alerts not removed");
    		throw e;
    	}
      
    }
}
