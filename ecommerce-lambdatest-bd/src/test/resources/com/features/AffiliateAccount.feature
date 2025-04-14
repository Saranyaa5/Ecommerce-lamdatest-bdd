Feature: Affiliate Account Creation

  Background:
    Given the user is on the homepage
    When the user clicks on My Account
    And clicks on login
    And the user enters valid credentials
    And the user clicks on the Login button
    Then the user should see the My Account page

  @Register_for_affiliate_account
  Scenario: Register as an affiliate account
    When the user clicks on register for affiliate account
    And enters payee name
    And clicks on checkbox
    And clicks on register continue button
    Then the user should see the edit your affiliate account

  @Affiliate_Account_Creation
  Scenario Outline: Edit affiliate account with valid and invalid inputs
    When the user clicks on Edit your affiliate information
    And enters "<Account Name>" as account name
    And enters "<Account Number>" as account number
    And clicks on continue button
    Then the user should see account created "<Message>"

    Examples:
      | Account Name | Account Number | Message                                          |
      | sbi          | 12345          | Success: Your account has been successfully updated. |
      |              | 12345          | Account Name required!                          |
      | sbi          |                | Account Number required!                        |

  @Custom_Affiliate_TrackingCode
  Scenario: View affiliate tracking code
    When the user clicks on custom affiliate tracking code
    Then the user sees tracking code
    And clicks on continue
