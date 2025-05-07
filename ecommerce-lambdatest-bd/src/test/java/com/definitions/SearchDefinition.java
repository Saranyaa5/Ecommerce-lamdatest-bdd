package com.definitions;

import com.actions.SearchAction;
/*
import com.utilities.ExcelReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class SearchDefinition {

    SearchAction searchAction = new SearchAction();
    Map<String, String> rowData;
    String expectedResult;

    @When("the user searches from excel for {string}")
    public void the_user_searches_from_excel_for(String scenarioType) {
        String path = "src\\test\\resources\\testdata.xlsx";
        String sheetName = "Sheet1"; // Make sure this matches your actual sheet name

        List<Map<String, String>> data = ExcelReader.readExcelData(path, sheetName);

        for (Map<String, String> row : data) {
            if (row.get("ScenarioType").equalsIgnoreCase(scenarioType)) {
                rowData = row;
                break;
            }
        }

        if (rowData == null) {
            throw new RuntimeException("Scenario type not found in Excel: " + scenarioType);
        }

        String input = rowData.get("Input").trim().replace("\"", "");
        expectedResult = rowData.get("Expected").trim();

        searchAction.searchProduct(input);
    }

    @Then("the search results should be validated based on excel data")
    public void the_search_results_should_be_validated_based_on_excel_data() {
        String actualText = searchAction.getSearchResultText(expectedResult).trim();
        System.out.println("Expected: " + expectedResult);
        System.out.println("Actual: " + actualText);
        Assert.assertTrue("Expected text not found in search result", actualText.equalsIgnoreCase(expectedResult));
    }
}
*/
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
    
    @When("the user enters the minimum value")
    public void the_user_enters_the_minimum_value() {
        searchAction.enterMinimumValue("602"); 
    }

    @When("the user enters the maximum value")
    public void the_user_enters_the_maximum_value() {
        searchAction.enterMaximumValue("2000"); 
    }

    @Then("the user should see all products within that value range")
    public void the_user_should_see_all_products_within_that_value_range() {
        Assert.assertTrue("Products are not within the value range!", searchAction.isPriceWithinRange(602,2000));
    }
    
    
    @When("the user clicks on Shop by Category")
    public void the_user_clicks_on_shop_by_category() {
        searchAction.clickShopByCategory();
    }

    @When("selects a specific category from the list")
    public void selects_a_specific_category_from_the_list() {
        searchAction.clickCategory();
    }

    @When("the user selects {string} products to display from the dropdown")
    public void the_user_selects_products_to_display_from_the_dropdown(String count){
        searchAction.selectProductCountFromDropdown(count);
    }

    @Then("the user should see exactly {string} products displayed on the page")
    public void the_user_should_see_exactly_products_displayed_on_the_page(String count) {
        int expectedCount = Integer.parseInt(count);
        int actualCount = searchAction.getDisplayedProductCount();
        Assert.assertEquals("Product count does not match the selected dropdown value.", expectedCount, actualCount);
    }

    
}

