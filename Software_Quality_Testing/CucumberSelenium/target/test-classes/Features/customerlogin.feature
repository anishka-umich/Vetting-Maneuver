Feature: Feature to test customer login functionality

  Scenario Outline: Check login is successful with valid customer credentials
    Given customer user is on login page
    When customer user enters <username> and <password>
    And clicks on login button
    Then user is navigated to the home page

    Examples: 
      | username            | password |
      | customer1@email.com |      123 |
	 