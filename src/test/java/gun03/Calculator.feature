Feature: Calculator
  @Sum
  Scenario: Sum of two number in calculato
    Given user on start page
    When user sum the following numbers
    |1|
    |2|
    |3|
    |4|
    |5|
    Then the result should be 15
