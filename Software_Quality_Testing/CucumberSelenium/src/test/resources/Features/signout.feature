Feature: Feature to test sign out functionality

  Scenario: Check that a user who is already signed in and successfully sign out
    Given user is logged into the application
    When user clicks Sign Out
    Then user is navigated to the Sign In page

