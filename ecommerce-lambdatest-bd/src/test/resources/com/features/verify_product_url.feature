Feature: Soundar_01MAY2025_LambdaTesters_Verify_product_url

  Background:
    Given the user is on the homepage
    When user clicks the Phones & PDAs category

  @ProductURL
  Scenario: Click on a iPod Nano product and verify the URL
    
    And user selects the iPod Nano product
    Then the URL should contain "route=product/product"

