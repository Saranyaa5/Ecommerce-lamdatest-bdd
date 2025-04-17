package com.definitions;

import org.testng.Assert;
import com.actions.ProductReviewAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductReviewDefinition {

    ProductReviewAction reviewAction = new ProductReviewAction();

    @And("user enters {string} in the Name field")
    public void user_enters_in_the_name_field(String name) {
        reviewAction.enterName(name);
    }

    @And("user writes {string} in the Review field")
    public void user_writes_in_the_review_field(String review) {
        reviewAction.enterReview(review);
    }

    @And("user leaves the Review field blank")
    public void user_leaves_the_review_field_blank() {
        reviewAction.enterReview("");
    }

    @And("user does not select any rating")
    public void user_does_not_select_any_rating() {
        // No action taken for no rating
    }

    @And("user selects a {int}-star rating")
    public void user_selects_a_star_rating(Integer stars) {
        reviewAction.selectRating(stars);
    }

    @When("user clicks on the Continue button to submit the review")
    public void user_clicks_on_continue_button() {
        reviewAction.clickContinue();
    }

    @Then("success message {string} should be displayed")
    public void success_message_should_be_displayed(String expectedMessage) {
        Assert.assertTrue(reviewAction.getSuccessMessage().contains(expectedMessage));
    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedMessage) {
    	
    		String text =  reviewAction.ErrorMessage();
    		Assert.assertTrue(text.contains(expectedMessage));
    	
    	
    }
}