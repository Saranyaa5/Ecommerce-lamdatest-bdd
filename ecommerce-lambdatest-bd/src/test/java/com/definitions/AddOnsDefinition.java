package com.definitions;

import org.junit.Assert;

import com.actions.AddOnsAction;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddOnsDefinition {

    AddOnsAction addonAction = new AddOnsAction();

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
    
//    @When("click on camera option")
//    public void click_on_camera_option() throws InterruptedException {
//        addonAction.clickCamera();
//    }
//
//    @Then("the user should see camera page")
//    public void the_user_should_see_camera_page() {
//        String expectedText="Cameras";
//        String actualText=addonAction.getCameraText();
//        Assert.assertTrue("camera page not visible",actualText.contains(expectedText));
//    }
}
