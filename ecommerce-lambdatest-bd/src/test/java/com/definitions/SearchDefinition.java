package com.definitions;

import com.actions.SearchAction;
import com.actions.UserLoginAction;
import com.utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.Map;

public class SearchDefinition{
    private final SearchAction searchAction;
    private final UserLoginAction userLoginAction;
    private static Map<String, String> testData;
    private String currentSearchTerm;

    public SearchDefinition() {
        this.searchAction = new SearchAction();
        this.userLoginAction = new UserLoginAction();
        
        if (testData == null) {
            testData = ExcelReader.getSearchTestData();
        }
    }

    @When("the user searches with valid input from excel")
    public void search_with_valid_input() {
        currentSearchTerm = testData.get("ValidSearchInputs");
        performSearch(currentSearchTerm);
    }

    @When("the user searches with invalid input from excel")
    public void search_with_invalid_input() {
        currentSearchTerm = testData.get("InvalidSearchInputs");
        performSearch(currentSearchTerm);
    }

    @When("the user searches with case sensitive input from excel")
    public void search_with_case_sensitive_input() {
        currentSearchTerm = testData.get("CaseSensitiveInputs");
        performSearch(currentSearchTerm);
    }

    @When("the user searches with indented input from excel")
    public void search_with_indented_input() {
        currentSearchTerm = testData.get("IndentationInputs");
        performSearch(currentSearchTerm);
    }

    @When("the user searches with category input from excel")
    public void search_with_category_input() {
        currentSearchTerm = testData.get("CategoryInputs");
        performSearch(currentSearchTerm);
    }

    private void performSearch(String searchTerm) {
        searchAction.enterSearchTerm(searchTerm);
        searchAction.clickSearchButton();
    }

    @Then("the products must be displayed")
    public void verify_products_displayed() {
        Assert.assertTrue(searchAction.areProductsDisplayed());
    }

    @Then("no products should be displayed")
    public void verify_no_products_displayed() {
        Assert.assertTrue(searchAction.isNoProductMessageDisplayed());
    }

    @Then("the message {string} should be displayed")
    public void verify_message_displayed(String message) {
        Assert.assertTrue(searchAction.isNoProductMessageDisplayed());
       
        Assert.assertEquals(message, searchAction.getNoProductMessageText());
    }
}