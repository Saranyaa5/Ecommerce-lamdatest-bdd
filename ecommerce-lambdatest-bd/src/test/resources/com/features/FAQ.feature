Feature: Soundar_29APR2025_LambdaTesters_FrequentlyAskedQuestion
 Background:
    Given the user is on the homepage
When user clicks the Phones & PDAs category

  @validateFAQ_iPodNano
  Scenario: Validate all FAQ messages displayed for iPod Nano under Phones & PDAs category
    
    And user selects the iPod Nano product
    And the user clicks frequently asked question
 Then the user should see the FAQ message "Lorem ipsum dolor sit amet, consectetur"



