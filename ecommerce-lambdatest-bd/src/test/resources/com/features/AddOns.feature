Feature: Jeevika_01MAY2025_LambdaTesters_AddOns

 Background:
    Given the user is on the homepage
 
  @addOns_Design_option
  Scenario: user clicks on designs of addOns
    When the user clicks on addons
    And clicks on designs option
    Then the user should see the design page
    
   #@add_Design_Camera
   #Scenario: when user clicks of camera and check it naivigated to camera page
   #When the user clicks on addons
    #And clicks on designs option
    #When click on camera option 
    #Then the user should see camera page
    