Feature: Feature to test Sign Up functionality
  Scenario: Check Sign Up is successful with valid credentials
    Given user is on Sign Up page
    When user enters Email, Name, password, phone, and address
    And clicks on Sign Up button
    Then user is navigated to the log in page
