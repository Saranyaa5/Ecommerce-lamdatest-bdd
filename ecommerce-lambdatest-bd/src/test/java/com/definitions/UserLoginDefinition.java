package com.definitions;

import org.testng.Assert;
import com.actions.UserLoginAction;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;
import io.cucumber.java.en.Given;
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
//        userLoginAction.clickLoginMenu();
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
    	    String actualResult;

    	    switch (check) {
    	        case "check1":
    	            actualResult = userLoginAction.getWarningMessage();
    	            Assert.assertEquals(actualResult, expectedResult,
    	                "Check1 Failed: Expected warning message not displayed");
    	            break;

    	        case "check2":
    	            actualResult = userLoginAction.getWarningMessage();
    	            Assert.assertEquals(actualResult, expectedResult,
    	                "Check2 Failed: Empty password warning not displayed");
    	            break;

    	        case "check3":
    	            actualResult = userLoginAction.getWarningMessage();
    	            Assert.assertEquals(actualResult, expectedResult,
    	                "Check3 Failed: Empty email warning not displayed");
    	            break;

    	        case "check4":
    	            actualResult = userLoginAction.getWarningMessage();
    	            Assert.assertEquals(actualResult, expectedResult,
    	                "Check4 Failed: Account lockout warning not displayed");
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

    