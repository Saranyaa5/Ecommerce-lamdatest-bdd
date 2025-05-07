package com.definitions;

import org.testng.Assert;

import com.actions.ProductCompareAction;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductCompareDefinition {
	ProductCompareAction productCompareAction =new ProductCompareAction();
	@When("the user clicks product compare")
	public void the_user_clicks_product_compare(){
		
		productCompareAction.clickProductCompare();
		
	}
	
	@Then("the user should see no products to compare error {string}")
	public void the_user_should_see_no_products_to_compare_error(String string){
		
		Assert.assertTrue(productCompareAction.getNoProductsToCompareMessage());
	}
	
	@Then("the user should see the comparison page")
	public void the_user_should_see_the_comparison_page() {
		System.out.println("product desc in comparision page:"+productCompareAction.getProductDescription());
		
	}
	
	@When("user selects the products to compare")
	public void user_selects_the_products_to_compare() {
		productCompareAction.clickProduct();
	}
	
	@When("the user clicks the comparision button")
	public void the_user_clicks_the_comparion_button() {
		productCompareAction.comparionButton(); 
	}
	@When("the user clicks the comparision arrow")
	public void the_user_clicks_the_comparision_arrow() {
		productCompareAction.clickComparionArrow();
	}
	
	@Then("the user should see the message no products match")
	public void the_user_should_see_the_message_no_products_match() {
		productCompareAction.getNoProductsErrorMessage();
		Assert.assertTrue(productCompareAction.getNoProductsErrorMessage());
	}

	
	
	
}
