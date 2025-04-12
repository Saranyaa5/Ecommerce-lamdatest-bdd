package com.definitions;

import com.actions.SearchAction;
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
