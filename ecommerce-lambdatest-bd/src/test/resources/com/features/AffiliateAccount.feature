Feature: Jeevika_15APR2025_LambdaTesters_AffiliateAccount

Scenario Outline: Register a user and register as affiliate with valid and invalid inputs
    Given the user is on the homepage  
    When the user clicks on My Account.  
    And clicks the register button  
    Then the user should see the registration page 
      
		When the user enters "<First Name>", "<Last Name>", "<Email>", "<Telephone>", "<Password>" and "<Confirm Password>"  
    And agrees to the Privacy Policy  
    And submits the registration form  
    Then the user should see "Your Account Has Been Created!"  
    
    When the user clicks on continue on register  
    And the user clicks on register your affiliate information  
    And enters payee name "<name>"  
    And clicks on checkbox  
    And clicks on register continue button  
    Then the user sees "<message>" based on "<check>"

    Examples:  
    | First Name | Last Name | Email              | Telephone   | Password | Confirm Password | name | message                                               | check   |
    | priya      | ram       | ppta112@gmail.com  | 1234567891  | 1234     | 1234             | jeev | Success: Your account has been successfully updated.  | valid   |
  