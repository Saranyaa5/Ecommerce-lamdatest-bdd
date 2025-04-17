package com.definitions;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.actions.AddToCartAction;
import com.actions.CheckOutAction;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutDefinition {
    
    private static final Logger logger = LogManager.getLogger(CheckoutDefinition.class);
    
    CheckOutAction checkOutAction = new CheckOutAction();
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
        boolean isOrderSuccessful = checkOutAction.OrderSuccessMsg();
        try {
            Assert.assertTrue(isOrderSuccessful, "Order is not successful");
            logger.info("Order placed successfully. Success message verified.");
        } catch (AssertionError e) {
            logger.error("Order success message not displayed. Order placement failed.", e);
            throw e;
        }
    }

    @Then("the user should see the message cart is empty")
    public void the_user_should_see_the_message_cart_is_empty() {
        String actualMessage = checkOutAction.EmptyCartMessage();
        String expectedMessage = "Your shopping cart is empty!";
        
        if (!actualMessage.isEmpty()) {
            try {
                Assert.assertEquals(actualMessage, expectedMessage, "Cart empty message doesn't match");
                logger.info("Verified: Cart is empty with correct message.");
            } catch (AssertionError e) {
                logger.error("Cart empty message does not match. Actual: {}, Expected: {}", actualMessage, expectedMessage, e);
                throw e;
            }
        } else {
            logger.warn("Cart is not empty. Products still present.");
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

    @When("Select Registered user CheckOut")
    public void select_registered_user_check_out() {
        checkOutAction.selectRegUser();
    }

    @When("the user accepts the privacy policy")
    public void the_user_accepts_the_privacy_policy() {
        checkOutAction.clickPrivacyPolicy();
    }

    @When("the user removes product from cart")
    public void the_user_removes_product_from_cart() {
        checkOutAction.reomveProduct();
    }

    @When("Enter the details in payment register form:")
    public void enter_the_details_in_payment_register_form(DataTable dataTable) {
        Map<String, String> formData = dataTable.asMap(String.class, String.class);
        checkOutAction.fillRegisterCheckoutForm(
            formData.get("First Name"),
            formData.get("Last Name"),
            formData.get("Email"),
            formData.get("Telephone"),
            formData.get("Pass"),
            formData.get("Confirm pass"),
            formData.get("Address"),
            formData.get("City"),
            formData.get("Postcode"),
            formData.get("Country")
        );
    }

    @When("Enter the details in payment register form as new user in checkout:")
    public void UniqueCheckOutMail(DataTable dataTable) {
        Map<String, String> formData = dataTable.asMap(String.class, String.class);
        String uniqueEmail = "checkout" + System.currentTimeMillis() + "@test.com";
        checkOutAction.fillRegisterCheckoutForm(
            formData.get("First Name"),
            formData.get("Last Name"),
            uniqueEmail,
            formData.get("Telephone"),
            formData.get("Pass"),
            formData.get("Confirm pass"),
            formData.get("Address"),
            formData.get("City"),
            formData.get("Postcode"),
            formData.get("Country")
        );
    }

    @Then("the user sould see the email alread exist error")
    public void the_user_sould_see_the_email_alread_exist_error() {
        String errorMessage = checkOutAction.getDuplicateEmailError();
        try {
            Assert.assertEquals(errorMessage, "Warning: E-Mail Address is already registered!", "Duplicate email error message does not match.");
            logger.info("Duplicate email error message verified successfully.");
        } catch (AssertionError e) {
            logger.error("Duplicate email error message mismatch. Actual: {}", errorMessage, e);
            throw e;
        }
    }
}

