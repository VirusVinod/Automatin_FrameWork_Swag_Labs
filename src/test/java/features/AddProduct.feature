@Reg
Feature: Product Add Functionality

  Scenario: Product Add to cart
    When user enter "standard_user" and "secret_sauce"
    And user click on login button
    When user add a product 
    Then Validate item add to sucessfully
