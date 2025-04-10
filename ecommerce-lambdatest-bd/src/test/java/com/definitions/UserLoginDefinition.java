/*package com.definitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.actions.UserLoginAction;
import com.utilities.ConfigReader;
import com.utilities.HelperClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLoginDefinition {
    private WebDriver driver;
    UserLoginAction la=new UserLoginAction();
//  public UserLoginDefinition(WebDriver driver) {
//        this.driver =;
//        this.la = new UserLoginAction(driver);
//       
//        ConfigReader.loadProperties("src\\test\\resources\\Cofiguration.properties");
//    }
    
    //ConfigReader.loadProperties("src\\test\\resources\\Cofiguration.properties");
  
    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        HelperClass.openPage();
    }

    @When("the user clicks on My Account")
    public void the_user_clicks_on_my_account() {
        la.clickMyAccounts();
    }

    @When("clicks on login")
    public void clicks_on_login() {
        

        la.clickLoginMenu();
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        la.setEmail(ConfigReader.getProperty("email"));
        la.setPassword(ConfigReader.getProperty("password"));
    }

    @When("the user clicks on the Login button")
    public void the_user_clicks_on_the_login_button() throws InterruptedException {
    	Thread.sleep(2000);
        la.clickLoginButton();
    }

    @Then("the user should see the My Account page")
    public void the_user_should_see_the_my_account_page() {
        Assert.assertTrue(la.isMyAccountPageDisplayed(), "My Account page is not displayed");
    }

    @When("the user enters E-Mail {string}")
    public void the_user_enters_e_mail(String email) {
        la.setEmail(email);
    }

    @When("the user enters Password {string}")
    public void the_user_enters_password(String password) {
        la.setPassword(password);
    }

    @Then("the user should see the {string}")
    public void the_user_should_see_the(String expectedWarning) {
        String actualWarning = la.getWarningMessage();
        Assert.assertEquals(actualWarning, expectedWarning, "Warning message does not match");
    }
}

*/


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

    @Then("the user should see the {string}")
    public void the_user_should_see_the(String expectedWarning) {
        String actualWarning = userLoginAction.getWarningMessage();
        Assert.assertTrue(actualWarning.contains(expectedWarning), 
            "Expected warning to contain: " + expectedWarning + " but got: " + actualWarning);
    }
}

