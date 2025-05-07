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
    
		@display_the_count_of_product_in_page
   Scenario Outline: Display the Count of Products Selected in Dropdown
		Given the user is on the homepage
		When the user clicks on Shop by Category
		And selects a specific category from the list
		And the user selects "<count>" products to display from the dropdown
    Then the user should see exactly "<count>" products displayed on the page

    Examples:
      | count |
      | 25    |
      | 50    |
      | 75    |
      
  @select_quickview_in_products
  Scenario: Selecting the Quick View option for a product
  Given the user is on the homepage  
  When the user clicks on Shop by Category  
  And selects a specific category from the list  
  And hovers over a product  
  And clicks the Quick View option  
  Then the user should see the product preview with the description
  
  #@select_addtocart_in_products
  #Scenario: Selecting the add to cart option for a product
  #Given the user is on the homepage  
  #When the user clicks on Shop by Category  
  #And selects a specific category from the list  
  #And hovers over a product  
  #And clicks the Add To Cart option
  #Then the user sees a popup message
  #And clicks on checkout button to see checkout page

      