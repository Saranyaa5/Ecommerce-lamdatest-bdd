package com.definitions;

import static org.testng.Assert.assertTrue;

import com.actions.Verify_product_url_action;

import io.cucumber.java.en.Then;

public class Verify_product_url_definition {

	Verify_product_url_action urlaction = new Verify_product_url_action();

    @Then("the URL should contain {string}")
    public void the_Assert_product_url(String expectedUrl) {
        String currentUrl = urlaction.getProductUrl();
        System.out.println("Current Url:"+currentUrl);
        assertTrue(currentUrl.contains(expectedUrl), "Expected URL to contain: " + expectedUrl);
    }
}
