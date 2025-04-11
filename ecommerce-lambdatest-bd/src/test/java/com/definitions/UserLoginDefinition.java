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
        String actualResult = userLoginAction.getWarningMessage();
        
        if ("check1".equals(check)) {
            Assert.assertEquals(actualResult, expectedResult, 
                "Check1 Failed: Expected warning message not displayed");
        } 
        else if ("check2".equals(check)) {
            Assert.assertEquals(actualResult, expectedResult, 
                "Check2 Failed: Empty password warning not displayed");
        }
        else if ("check3".equals(check)) {
            Assert.assertEquals(actualResult, expectedResult, 
                "Check3 Failed: Empty email warning not displayed");
        }
        else {
            Assert.fail("Unknown test case identifier: " + check);
        }
    }
}

