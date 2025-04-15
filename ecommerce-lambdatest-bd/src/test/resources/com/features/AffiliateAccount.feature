Feature: User Registration and Affiliate Account Functionality
  I want to register for the ecommerce LambdaTest account and become an affiliate partner

  Background:  
    Given the user is on the homepage  
    When the user clicks on My Account  
    And clicks the register button  
    Then the user should see the registration page  

  @ValidRegistrationInputs
  Scenario Outline: Register with valid inputs  
    When the user enters "<First Name>", "<Last Name>", "<Email>", "<Telephone>", "<Password>" and "<Confirm Password>"  
    And agrees to the Privacy Policy  
    And submits the registration form  
    Then the user should see "Your Account Has Been Created!"  

    Examples:  
      | First Name | Last Name | Email               | Telephone  | Password | Confirm Password |  
      | priya      | ram       | ppta12e@gmail.com   | 1234567891 | 1234     | 1234             |  

  @Affiliate_Account_Creation
  Scenario Outline: Edit affiliate account with valid and invalid inputs
    When the user clicks on Edit your affiliate information
    And enters "<Account Name>" as account name
    And enters "<Account Number>" as account number
    And clicks on continue button
    Then the user should see account created "<Message>"

    Examples:
      | Account Name | Account Number | Message                                            |
      | sbi          | 12345          | Success: Your account has been successfully updated. |
      |              | 12345          | Account Name required!                            |
      | sbi          |                | Account Number required!                          |
