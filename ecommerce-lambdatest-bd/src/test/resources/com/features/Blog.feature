Feature: Jeevika_16APR2025_LambdaTesters_Blog

  Background:
    Given the user is on the homepage

  @valid_blog_filling_all_required_details
  Scenario: Adding a valid comment to the blog
    When the user clicks on the Blog button
    Then the user selects any article from the blog
    And the user is navigated to the selected blog page
    When the user enters the following comment details:
      | name      | email             | comment                                                                |
      | Jeev      | jeev@example.com  | This blog was very informative and well written. Keep it up!           |
    And clicks on the Post Comment button
    Then the user should see the message "Thank you for your comment. It has been submitted to the webmaster for approval."

  @invalid_blog_filling_without_required_details
Scenario Outline: Submitting a blog comment without filling required details
  When the user clicks on the Blog button
  Then the user selects any article from the blog
  And the user is navigated to the selected blog page
  When the user enters the name "<name>"
  And enters the email "<email>"
  And adds the comment "<comment>"
  And clicks on the Post Comment button
  Then the user should see the warning message "<message>" and "<check>"

Examples:
  | name | email            | comment                            | message           |check|
  | Jeev |                  |             |Warning: Comment Text must be between 25 and 1000 characters!|check1|
  |      | jeev@example.com | Viverra accumsan in nisl nisi scelerisque eu. Vestibulum lorem sed risus ultricies tristique. | Warning: Comment Name must be between 3 and 25 characters!  |check2|
  | Jeev | jeev@example.com | Hi                                                                  | Warning: Comment Text must be between 25 and 1000 characters!             |check3|

  @category_selection_for_blog
  Scenario: category wise selection and assertion
  When the user clicks on the Blog button
  And the user selects category
  Then the user should see article page

  
  @image_selection_on_blog
  Scenario: clicking the product image to navigate to product shopping page
  When the user clicks on the Blog button
  And clicks on the product image
  Then the product shopping page is displayed
  
 