Feature: Jeevika_29APR2025_LamdaTesters_SpecialOffer_in_homePage

  Background:
    Given the user is on the homepage

  @special_Offer
  Scenario: To assert special offer button in homepage
    When the user clicks on the special offers
    Then the user should see the special offers available
