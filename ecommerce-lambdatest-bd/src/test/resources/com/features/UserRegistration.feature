@registration
Feature: User Registration
  I want to register for the ecommerce LambdaTest account
  
   Background:  
    Given the user is on the homepage  
    When the user clicks on My Account.  
    And clicks the register button  
    Then the user should see the registration page  

  @ValidRegistrationInputs
  Scenario Outline: Register with valid inputs  
    When the user enters "<First Name>", "<Last Name>", "<Email>", "<Telephone>", "<Password>" and "<Confirm Password>"  
    And agrees to the Privacy Policy  
    And submits the registration form  
    Then the user should see "Your Account Has Been Created!"  

    Examples:  
      | First Name | Last Name | Email              | Telephone   | Password | Confirm Password |  
      | priya1234      | ram       | 2k21eee15@kiot.ac.in | 1674937891  | 1234     | 1234             |  

  @InValidRegistrationInputs
  Scenario Outline: Register with invalid inputs  
    When the user enters the invalid inputs "<First Name>", "<Last Name>", "<Email>", "<Telephone>", "<Password>" and "<Confirm Password>"  
    And agrees to the Privacy Policy
    And submits the registration form  
    Then the user should see "<ErrorMessage>" for "<Test Case Name>"  

    Examples:  
      | First Name | 	Last Name | Email              | Telephone   | Password | Confirm Password | ErrorMessage                                              | Test Case Name     |  
      |            | ram       | priya123@gmail.com | 1234567891  | 1234     | 1234             | First Name must be between 1 and 32 characters!          | empty first name   |  
      | priya      | ram       | oign@gma.com       | 1234567891  | 1234     | 1234             | Warning: E-Mail Address is already registered!           | existing email     |  
      | priya      | ram       | priya123@gmail.com | 1234567891  |          | 1234             | Password must be between 4 and 20 characters!            | empty password     |  
      | priya      | ram       | priya123@gmail.com | 1234567891  | 1234     | 4321             | Password confirmation does not match password!           | password mismatch  |
      
   @RegistrationWithoutAcceptingPrivacyPolicy
   Scenario Outline: Register with valid inputs  
    When the user enters "<First Name>", "<Last Name>", "<Email>", "<Telephone>", "<Password>" and "<Confirm Password>"  
    And the user not agrees to the privacy policy   
    And submits the registration form  
    Then the user should see "<ErrorMessage>" for "<Test Case Name>"  

    Examples:  
      | First Name | Last Name | Email              | Telephone   | Password | Confirm Password | ErrorMessage                                  |Test Case Name                  |
      | priya      | ram       | priya123@gmail.com | 1234567891  | 1234     | 1234             | Warning: You must agree to the Privacy Policy!|Not checking privacy policy|
   
   













  #Background:
    #Given the user is on the homepage
    #When the user clicks on "My Account"
    #And clicks the register button
    #Then the user should see the registration page
    #
    #@ValidRegistrationInputs
    #Scenario Outline: Register with valid inputs
    #When the user enters "<First Name>","<Last Name>","<Email>","<Telephone>","<Password>" and "<Confirm Password>"
    #And agrees to the Privacy Policy
    #And submits the registration form
    #Then the user should see "Your Account Has Been Created!"
    #Examples:
      #|First Name|Last Name|Email|Telephone|Password|Confirm Password|
      #|priya|ram|priya123@gmail.com|1234567891|1234|1234|
#
  #@ValidRegistrationInputs
  #Scenario Outline: Register with invalid inputs
    #When the user enters the invalid inputs "<First Name>","<Last Name>","<Email>","<Telephone>","<Password>" and "<Confirm Password>"
    #Then the user should see "<ErrorMessage>","<test case name>"
#
    #Examples:
      #|First Name|Last Name|Email|Telephone|Password|Confirm Password|ErrorMessage|test case name|
      #|     |ram|priya123@gmail.com|1234567891|1234|1234|First Name must be between 1 and 32 characters!|empty first name|
      #|priya|ram|oign@gma.com|1234567891|1234|1234|Warning: E-Mail Address is already registered!|existing emial|
      #|priya|ram|priya123@gmail.com|1234567891|    |1234|assword must be between 4 and 20 characters!|empty password|
      #|priya|ram|priya123@gmail.com|1234567891|1234|4321|Password confirmation does not match password!|password mismatch|
