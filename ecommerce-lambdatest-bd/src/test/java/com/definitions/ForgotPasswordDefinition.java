package com.definitions;

import org.testng.Assert;
import com.actions.ForgotPasswordAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordDefinition {

    ForgotPasswordAction forgotPasswordAction = new ForgotPasswordAction();

    @When("user clicks on Forgotten Password link")
    public void user_clicks_on_forgotten_password_link() {
        forgotPasswordAction.clickForgotPassword();
    }

    @And("user enters {string} to receive reset link")
    public void user_enters_email_to_receive_reset_link(String email) {
        forgotPasswordAction.enterEmail(email);
    }

    @And("user clicks continue")
    public void user_clicks_continue() {
        forgotPasswordAction.clickContinueButton();
    }

    @Then("user should a message {string}")
    public void user_should_see_password_reset_message(String expectedMessage) {
        String actualMessage = forgotPasswordAction.verifySuccessMessage();
        if (actualMessage.isEmpty()) {
            actualMessage = forgotPasswordAction.verifyErrorMessage();
        }
        Assert.assertTrue(actualMessage.contains(expectedMessage),
            "Expected: " + expectedMessage + ", but got: " + actualMessage);
    }

}
