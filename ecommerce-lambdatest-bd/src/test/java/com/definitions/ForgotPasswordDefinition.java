package com.definitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.actions.ForgotPasswordAction;
import com.actions.UserLoginAction;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordDefinition {

	ForgotPasswordAction forgotPasswordAction = new ForgotPasswordAction();

   
    UserLoginAction userLoginAction = new UserLoginAction();

  
    
    @When("user clicks on Forgotten Password link")
    public void user_clicks_on_forgotten_password_link() {
        forgotPasswordAction.clickForgotPassword();
    }

    @And("user enters valid email to receive reset link")
    public void user_enters_valid_email_to_receive_reset_link(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> emailList = dataTable.asMaps(String.class, String.class);
        String email = emailList.get(0).get("email");
        forgotPasswordAction.enterEmail(email);
    }

    @And("user enters Invalid email to receive reset link")
    public void user_enters_invalid_email_to_receive_reset_link(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> emailList = dataTable.asMaps(String.class, String.class);
        String email = emailList.get(0).get("email");
        forgotPasswordAction.enterEmail(email);
    }

    @And("user clicks continue")
    public void user_clicks_continue() {
        forgotPasswordAction.clickContinueButton();
    }

    @Then("user should see an email sent confirmation message")
    public void user_should_see_an_email_sent_confirmation_message() {
        String text = forgotPasswordAction.verifySuccessMessage();
        Assert.assertTrue(text.contains("An email with a confirmation link has been sent your email address."));
        
    }

    @Then("user should see an Error Message")
    public void user_should_see_an_error_message() {
       String text =  forgotPasswordAction.verifyErrorMessage();
       Assert.assertTrue(text.contains("Warning: The E-Mail Address was not found in our records, please try again!"));
    }
}
