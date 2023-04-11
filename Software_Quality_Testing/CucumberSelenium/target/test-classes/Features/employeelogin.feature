Feature: Feature to test employee login functionality

  Scenario Outline: Check login is successful with valid employee credentials
    Given employee user is on login page
    When employee user enters <username> and <password>
    And clicks login button
    Then employee user is navigated to the home page

    Examples: 
      | username            | password |
      | employee1@email.com |      123 |
      | manager1@email.com  |      123 |
