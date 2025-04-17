Feature: User Account Management

Background:
      Given the user is on the homepage
    When the user clicks on My Account
    And clicks on login
    And the user enters the valid credentials 
    And the user clicks on the Login button


  @EditAccount
  Scenario: Edit user account details
    Then the user clicks the "Edit your account information" page
    And the user updates telephone number
    And clicks on the "EditInfo" Continue button
    Then user should see "Success: Your account has been successfully updated."

  @ModifyAddress
  Scenario: Adding new address
  Then the user clicks the "Modify your address book entries" page
  And the user clicks new address
  And user enters valid details
  And clicks on the "NewAddress" Continue button
  Then user should see "Your address has been successfully added"
  
  

  @ModifyWishlist
  Scenario: Modify the wishlist by removing a product
    Then the user clicks the "Modify your wish list" page
    And the user has products in their wishlist
    When the user removes a product from the wishlist
    Then user should see "Success: You have modified your wish list!"

  @Newsletter
  Scenario Outline: Subscribe or Unsubscribe from newsletter
    When the user clicks the "Newsletter" page
    And the user chooses to "<action>" the newsletter
    And clicks on the "Newsletter" Continue button
    Then user should see "Success: Your newsletter subscription has been successfully updated!"

    Examples:
      | action      |
      | subscribe   |
      | unsubscribe |
      
      
      @ChangePassword
  Scenario: Change user password
    Then the user clicks the "Change your password" page
    And the user enters current password and new password details
    And clicks on the "ChangePassword" Continue button
    Then user should see "Success: Your password has been successfully updated."
    
    @ChangePassword_EmptyNewPasswordField
      Scenario: Change user password without providing new password
    Then the user clicks the "Change your password" page
    And clicks on the "ChangePassword" Continue button
    Then user should see "Password must be between 4 and 20 characters!"
    
    
    