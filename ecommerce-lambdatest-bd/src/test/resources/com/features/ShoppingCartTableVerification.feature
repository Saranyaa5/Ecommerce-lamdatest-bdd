Feature: Soundar_06MAY2025_LambdaTesters_Shopping_Cart_Table_Verification

  Background: 
      Given the user is on the homepage
      When user clicks the Phones & PDAs category

  Scenario: Verify product is in the shopping cart
    And user selects the iPod Nano product
    And user clicks on the Add to Cart button
    When user views the shopping cart
    Then the shopping cart should display "iPod Nano" in the product name column
