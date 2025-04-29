@HomePage
Feature: Saranya_20APR2025_LamdaTesters_Feature file for HomePage Assertion
  I want to use this template for my feature file
  
  Background:
   Given the user is on the homepage

  @HomePageRedirection
  Scenario: To assert the Functioning of Webelements in home page
  When the user clicks the shop now in first block
  Then the user needs to redirect to the top of home page
  
  @HomePageBlock2
  Scenario: To redirected to the product page after clicking Shop Now button in Block 2
  When the user clicks shop now in second block
  Then the user should see the "Canon EOS 5D" page
  
  @HeadPhonesBlock
  Scenario: To redirected to the product page after clicking Head phones poster
  When the user clicks hp25 Headphones poster
  Then the user should see the "HP LP3065" product page
  
  
  
  