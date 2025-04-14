#@Checkout
#Feature: Shopping Cart CheckOut functionality
#
  #@CheckoutAsGuest
  #Scenario: To checkout the shopping cart as a guest user
    #Given the user is on the homepage 
    #And the user adds a product into shopping cart as guest
    #When the user clicks shopping cart icon 
    #And clicks chout button
    #Then the suer sees the checkout page
    #And the user choose guest checkout
    #And fills the form as guest <fname> ,<lname>,...
    #And clicks the terms and condition checkBox and clicks continue
    #And the user confirms order details
    #Then the user see the success message
    #
    #Examples:
    #|fname|lname|email|telephone|...
    #|valid|
    #|invalid|
    #
    #@CheckoutAsregisteredUser @
    #Given the user is on the homepage 
    #When the user clicks on My Account
    #And clicks on login
    #And the user enters valid credentials 
    #And the user clicks on the Login button
    #When the user clicks shopping cart icon 
    #And clicks chout button
    #Then the user should see the shopping cart is empty 
    #
    #
    #
    #
    #
