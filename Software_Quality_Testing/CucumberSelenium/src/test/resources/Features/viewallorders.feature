Feature: Feature to test managers can view all orders

  Scenario Outline: Check managers can successfully view all orders
    Given manager user is logged in
    When manager user clicks orders
    Then manager user is navigated to the orders page
