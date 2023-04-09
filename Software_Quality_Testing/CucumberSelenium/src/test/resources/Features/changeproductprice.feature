Feature: Feature to test change product price functionality

  Scenario Outline: Check employee user can successfully change the price of a product
    Given employee user is logged into the application
    When customer user clicks edit on an item
    And enters a new price and clicks submit
    Then user is navigated to Products page showing item with new price
