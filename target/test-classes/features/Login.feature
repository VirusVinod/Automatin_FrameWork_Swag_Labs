@Reg
Feature: Login Functionality

  Scenario: Login With Valid Credenatials
    When user enter "standard_user" and "secret_sauce"
    And user click on login button
    Then Validate user logged in sucessfully

  Scenario: Login With Valid Emild and Invalid password
    When user enter "standard_user" and "secret_sauce123"
    And user click on login button
    Then Validate login error massage

  Scenario: Login With Invalid Emild and Valid password
    When user enter "Vinod" and "secret_sauce"
    And user click on login button
    Then Validate login error massage

  Scenario: Login With Blank Emild and  password
    When user enter "  and " "
    And user click on login button
    Then Verify the login error message for blank email and password fields.
