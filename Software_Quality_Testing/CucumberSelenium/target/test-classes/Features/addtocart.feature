Feature: Feature to test add to cart functionality

  Scenario Outline: Check customer user can successfully add to cart
    Given customer user is logged into the application
    When customer user clicks Get It! button on an item
    And clicks Add to Cart
    Then user is navigated to My Cart with appropriate item added
