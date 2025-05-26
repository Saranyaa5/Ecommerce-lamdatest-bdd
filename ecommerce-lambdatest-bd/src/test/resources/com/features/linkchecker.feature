Feature: Soundar_26MAY2025_LambdaTesters_LINKCHECKER
  @LinkChecker
  Scenario: Count all links and verify they are not broken
    Given the user is on the homepage
    When user collect all the links on the page
    Then user should print the total number of links
    And user should validate each link is not broken
