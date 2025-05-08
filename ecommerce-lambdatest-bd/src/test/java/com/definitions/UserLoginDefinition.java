package com.definitions;

import org.testng.Assert;
import com.actions.UserLoginAction;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginDefinition {
    UserLoginAction userLoginAction = new UserLoginAction();

    @When("the user clicks on My Account")
    public void the_user_clicks_on_my_account() {
        userLoginAction.clickMyAccounts();
    }

    @When("clicks on login")
    public void clicks_on_login() {
    	// This step assumes successful navigation is verified in a subsequent step
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        userLoginAction.setEmail();
        userLoginAction.setPassword();
    }

    @When("the user clicks on the Login button")
    public void the_user_clicks_on_the_login_button() {
        userLoginAction.clickLoginButton();
    }

    @Then("the user should see the My Account page")
    public void the_user_should_see_the_my_account_page() {
        Assert.assertTrue(userLoginAction.isMyAccountPageDisplayed(), "My Account page is not displayed");
    }

    @When("the user enters E-Mail {string}")
    public void the_user_enters_e_mail(String email) {
        userLoginAction.setEmail2(email);
    }

    @When("the user enters Password {string}")
    public void the_user_enters_password(String password) {
        userLoginAction.setPassword2(password);
    }
    
    	@Then("the user should see the {string} and {string}")
    	public void the_user_should_see_the_and(String expectedResult, String check) {
    	    boolean actualResult;

    	    switch (check) {
    	        case "check1":
    	        case "check2":
    	        case "check3":
    	        case "check4":
    	            actualResult = userLoginAction.getWarningMessage();
    	            Assert.assertTrue(actualResult, "Warning message not displayed for: " + check);
    	            break;

    	        default:
    	            Assert.fail("Unknown test case identifier: " + check);
    	    }
    	}
    	
    	@Then("the user logs out")
    	public void the_user_logs_out() {
    	 userLoginAction.clickLogout();
    	}

    	@Then("the user should see the Account Logout page")
    	public void the_user_should_see_the_account_logout_page() {
    		 String expectedText = "Account Logout";
    	        String actualText = userLoginAction.getAccountLogoutText();
    	        Assert.assertEquals(actualText, expectedText, "Account Logout page is not displayed");
    	    }
    	}