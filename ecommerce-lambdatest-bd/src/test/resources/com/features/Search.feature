Feature: Search functionality

  Background:
     Given the user is on the homepage  
    When the user clicks on My Account.  
    And clicks the register button  
    Then the user should see the registration page  
    
  @ValidSearchInputs
  Scenario: Search functionality with valid inputs
    When the user searches with valid input from excel
    Then the products must be displayed

  @InValidSearchInputs
  Scenario: Search functionality with invalid inputs
    When the user searches with invalid input from excel
    Then no products should be displayed

  @CaseSensitiveSearchInputs
  Scenario: Search functionality with case sensitive inputs
    When the user searches with case sensitive input from excel
    Then the products must be displayed

  @IndentationSearchInputs
  Scenario: Search functionality with unnecessary indentation in search
    When the user searches with indented input from excel
    Then the products must be displayed

  @SearchByCategory
  Scenario: Search functionality by category as input
    When the user searches with category input from excel
    Then the message "There is no product that matches the search criteria." should be displayed
