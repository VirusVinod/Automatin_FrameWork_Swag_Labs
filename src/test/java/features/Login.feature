@Reg
Feature: Login Functionality

  Scenario: Login With Valid Credenatials
    When user enter "standard_user" and "secret_sauce"
    And user click on login button
    Then Validate user logged in sucessfully
