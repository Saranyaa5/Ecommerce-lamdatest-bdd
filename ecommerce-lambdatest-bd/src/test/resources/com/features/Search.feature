Feature: Search functionality

  Background:
    Given the user is on the homepage
    When the user clicks on My Account
    And clicks on login
    And the user enters valid credentials
    And the user clicks on the Login button
    Then the user should see the My Account page

  @excel_driven_search
  Scenario Outline: Search functionality using Excel data
    When the user searches from excel for "<scenarioType>"
    Then the search results should be validated based on excel data

    Examples:
      | scenarioType                  |
      | valid_search_correctinput     |
      | valid_search_partial_match    |
      | valid_search_case_insensitive |
      | valid_search_spaces           |
      | valid_search_empty_input      |
      | invalid_search_incorrectinput |
