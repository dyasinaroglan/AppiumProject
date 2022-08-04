Feature: Open a web sites

  Scenario: Login
    Given user on homePage
    When user fill the login form as follows
    |username|
    |password|
    And user clicks submit button
    Then login should be successful
    And driver close