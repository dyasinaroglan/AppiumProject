Feature: Calculator

  Scenario: Sum of two number in calculato
    Given user on start page
    When user sum the following numbers
    |1|
    |2|
    |3|
    Then the result should be 6
