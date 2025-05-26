Feature: Jeevika_26MAY2025_LambdaTesters_MainMenuOptions

  Background:
    Given the user is on the homepage

  @choosing_a_option_from_mainmenu
  Scenario: User chooses Apple from main menu
  	When user clicks on the main menu
    And clicks on apple option
    Then the user should see products from apple
