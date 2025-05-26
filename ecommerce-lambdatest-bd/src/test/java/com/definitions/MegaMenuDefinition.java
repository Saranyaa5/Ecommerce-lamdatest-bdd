package com.definitions;

import org.junit.Assert;

import com.actions.MegaMenuAction;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MegaMenuDefinition {

    MegaMenuAction megaMenuAction = new MegaMenuAction();
    
	@When("user clicks on the main menu")
	public void user_clicks_on_the_main_menu() {
	   megaMenuAction.hoverOnMegaMenu();
	}

	@When("clicks on apple option")
	public void clicks_on_apple_option() {
	   megaMenuAction.clickOptions();
	}

	@Then("the user should see products from apple")
	public void the_user_should_see_products_from_apple(){
		String actualText="Apple";
	   String expectedText=megaMenuAction.appleProductText();
	   Assert.assertTrue("apple page not opened after clicking the apple option",actualText.contains(expectedText));
	}
}
