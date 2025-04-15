package com.definitions;

import java.util.Map;

import org.testng.Assert;

import com.actions.AddToCartAction;
import com.actions.CheckOutAction;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutDefinition {
	CheckOutAction checkOutAction=new CheckOutAction();
	AddToCartAction cartAction = new AddToCartAction();
	
	@When("the user searches {string}")
	public void the_user_searches(String string) {
		checkOutAction.searchProdut(string);
	}

	@When("user selects the product")
	public void user_selects_the_product() {
		checkOutAction.selectSearchProduct();
	}

@When("the user clicks CheckOut")
public void the_user_clicks_check_out() {
	checkOutAction.productCheckOut();
}
	

@When("Select Guest CheckOut")
public void select_guest_check_out() {
	checkOutAction.selectGuestUser();
}

@When("Enter the details in form:")
public void enter_the_details_in_form(DataTable dataTable) {
    Map<String, String> formData = dataTable.asMap(String.class, String.class);
    checkOutAction.fillGuestCheckoutForm(
        formData.get("First Name"),
        formData.get("Last Name"),
        formData.get("Email"),
        formData.get("Telephone"),
        formData.get("Address"),
        formData.get("City"),
        formData.get("Postcode"),
        formData.get("Country"),
        formData.get("Region")
    );
}

@When("the user accepts the terms and condition")
public void the_user_accepts_the_terms_and_condition() {
	checkOutAction.acceptGuestTermsCondition();
}

@When("clicks continue from the checkout page")
public void clicks_continue_from_the_checkout_page() {
	checkOutAction.clickContinueCheckout();
}

@When("the user clicks confirm order")
public void the_user_clicks_confirm_order() {
	checkOutAction.confirmOrder();
}

@Then("the order success message should be displayed")
public void the_success_message_should_be_displayed() {
	checkOutAction.OrderSuccessMsg();
	Assert.assertTrue(checkOutAction.OrderSuccessMsg(),"order is not successfull");
	
}
@Then("the user should see the message cart is empty")
public void the_user_should_see_the_message_cart_is_empty() {
    String actualMessage = checkOutAction.EmptyCartMessage();
    String expectedMessage = "Your shopping cart is empty!";
    
    if (!actualMessage.isEmpty()) {
        Assert.assertEquals(actualMessage, expectedMessage, "Cart empty message doesn't match");
    } else {
        
        System.out.println("Products still present in cart");
    }
}
	@When("And Enter the details in form")
	public void and_enter_the_details_in_form(DataTable dataTable) {
		 Map<String, String> formData = dataTable.asMap(String.class, String.class);
		    checkOutAction.fillPaymentCheckoutForm(
		        formData.get("First Name"),
		        formData.get("Last Name"),
		        formData.get("Address"),
		        formData.get("City"),
		        formData.get("Postcode")
		       
		    );
	}
	@When("the user cliks use existing address button")
	public void the_user_cliks_use_existing_address_button() {
		checkOutAction.clickExistingAddButton();
	}
	
	@When("the user clicks use new address button")
	public void the_user_cliks_use_new_address_button() {
		 checkOutAction.clickNewAddressButton();
	}

	
}
