Feature: Jeevika_12APR2025_LambdaTesters_Search

  Background:
     Given the user is on the homepage  

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
    
 #@MinimumAndMaximumSegregation
#	Scenario: Display products between minimum and maximum values
    #When the user enters the minimum value
    #And the user enters the maximum value
    #Then the user should see all products within that value range
