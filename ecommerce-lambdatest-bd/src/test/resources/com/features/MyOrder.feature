
@MyOrders

Feature: My orders feature
  I want to check for the orders i made previously
  
  Background:
  Given the user is on the homepage
  When the user searches "hp lp3065"
	  And user selects the product
	  And user clicks on the Add to Cart button
	  And user views the shopping cart
	  And the user clicks CheckOut
	  And Select Registered user CheckOut
	 And Enter the details in payment register form as new user in checkout:
    | Field       | Value          |
    | First Name  | John           |
    | Last Name   | Doe            |
    | Email       |                |
    | Telephone   | 1234567890     |
    |Pass|1234|
    |Confirm pass|1234|
    | Address     | 123 Main St    |
    | City        | Salem          |
    | Postcode    | 12345          |
    | Country     | United States  |
	  And the user accepts the terms and condition
	  And the user accepts the privacy policy
	  And clicks continue from the checkout page
	  When the user clicks confirm order
	  When the user clicks on My Account in the top
	  And clicks my order history
  
 @AccessingOdersHistory
  Scenario: To checkout view the order history after ordering
	  Then the order history is displayed
	  
 @ProductReOrdering
 Scenario: To reorder the product in the order  history
 And user clicks view button
 When the user clicks reorder button
 Then the product reordered message should be displayed
 