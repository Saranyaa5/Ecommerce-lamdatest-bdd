package com.definitions;

import com.actions.SearchAction;
import com.utilities.ExcelReader;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.Map;

public class SearchDefinition{
    private final SearchAction searchAction;
    private static Map<String, String> testData;
    private String currentSearchTerm;

    public SearchDefinition() {
        this.searchAction = new SearchAction();   
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
    
    @When("hovers over a product")
    public void hovers_over_a_product() {
    	searchAction.hoverOverFirstProduct();
    }

    @When("clicks the Quick View option")
    public void clicks_the_quick_view_option() {
        // Already handled in hover method
    }

    @Then("the user should see the product preview with the description")
    public void the_user_should_see_the_product_preview_with_the_description() {
        Assert.assertTrue("Quick View was not displayed!", searchAction.isQuickViewDisplayed());
    }

    @When("clicks the Add To Cart option")
    public void clicks_the_add_to_cart_option() {
        // Already handled in next step
    }

    @Then("the user sees a popup message")
    public void the_user_sees_a_popup_message() {
        searchAction.clickAddToCartAndHandlePopup();
    }

    @Then("clicks on checkout button to see checkout page")
    public void clicks_on_checkout_button_to_see_checkout_page() {
        Assert.assertTrue("Checkout page was not displayed.", searchAction.isCheckoutPageDisplayed());
    }
    
}

