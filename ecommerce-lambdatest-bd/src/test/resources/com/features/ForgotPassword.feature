Feature: Soundar_09APR2025_LambdaTesters_ForgotPassword

  Background:
    Given the user is on the homepage
    When the user clicks on My Account
    And clicks on login
    When user clicks on Forgotten Password link

  @ForgotPasswordWithValidEmail
  Scenario: User requests a password reset link using valid email
 And user enters valid email to receive reset link
      | email              |
      | 2k21eee65@kiot.ac.in |
    And user clicks continue
    Then user should see an email sent confirmation message

  @ForgotPasswordWithInValidEmail
  Scenario: User requests a password reset link using invalid email
    And user enters Invalid email to receive reset link
      | email              |
      | 2k21eee33@kiot.ac.in |
    And user clicks continue
    Then user should see an Error Message
    
      @ForgotPasswordWithoutProvidingEmail
  Scenario: User requests a password reset link without providing email
    And user clicks continue
    Then user should see an Error Message