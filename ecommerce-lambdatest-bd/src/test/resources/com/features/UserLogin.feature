Feature: Login Functionality

 Background:
    Given the user is on the homepage
    When the user clicks on My Account
    And clicks on login

  @validCredentials
  Scenario: User tries to login with valid credentials
    And the user enters valid credentials 
    And the user clicks on the Login button
    Then the user should see the My Account page

  @invalidCredentials
  Scenario Outline: User tries to login with invalid credentials
    And the user enters E-Mail "<email>"
    And the user enters Password "<password>"
    And the user clicks on the Login button
    Then the user should see the "<expectedResult>" and "<check>"
    

    Examples:
      | email          | password | expectedResult                                                                       |check  |
      | jee@gmail.com  | 0987     | Warning: No match for E-Mail Address and/or Password.                                |check1 |
      | jee@gmail.com  |          | Warning: No match for E-Mail Address and/or Password.                                |check2 |
       