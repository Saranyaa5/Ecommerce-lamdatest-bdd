@Checkout
Feature: Shopping Cart CheckOut functionality

Background:
  Given the user is on the homepage 

@CheckoutAsGuest
Scenario: To checkout the shopping cart as a guest user
  When the user searches "hp lp3065"
  And user selects the product
  And user clicks on the Add to Cart button
  And user views the shopping cart
  And the user clicks CheckOut
  And Select Guest CheckOut
  And Enter the details in form:
    | Field       | Value          |
    | First Name  | John           |
    | Last Name   | Doe            |
    | Email       | john@test.com  |
    | Telephone   | 1234567890     |
    | Address     | 123 Main St    |
    | City        | Salem          |
    | Postcode    | 12345          |
    | Country     | United States  |
  And the user accepts the terms and condition
  And clicks continue from the checkout page
  When the user clicks confirm order
  Then the order success message should be displayed


  @CheckOutEmptyCart
  Scenario: To checkout the empty shopping cart as a registered user
    #When the user clicks on My Account
    #And clicks on login
    #And the user enters valid credentials 
    #And the user clicks on the Login button
  And user views the shopping cart
  Then the user should see the message cart is empty

  @CheckoutAsRegisteredUser
  Scenario: To checkout the  cart as a registered user
    When the user clicks on My Account
    And clicks on login
    And the user enters valid credentials 
    And the user clicks on the Login button
    When the user searches "hp lp3065"
  And user selects the product
  And user clicks on the Add to Cart button
  And user views the shopping cart
  And the user clicks CheckOut
  And the user clicks use new address button
  And And Enter the details in form
    | Field       | Value          |
    | First Name  | John           |
    | Last Name   | Doe            |
    | Address     | 123 Main St    |
    | City        | Salem          |
    | Postcode    | 12345          |
  And the user accepts the terms and condition
  And clicks continue from the checkout page
  When the user clicks confirm order
  Then the order success message should be displayed

   @CheckoutWithExistingAddress
  Scenario: To checkout the  cart as registered user with existing address
    When the user clicks on My Account
    And clicks on login
    And the user enters valid credentials 
    And the user clicks on the Login button
    When the user searches "hp lp3065"
  And user selects the product
  And user clicks on the Add to Cart button
  And user views the shopping cart
  And the user clicks CheckOut
  And the user cliks use existing address button
  And the user accepts the terms and condition
  And clicks continue from the checkout page
  When the user clicks confirm order
  Then the order success message should be displayed