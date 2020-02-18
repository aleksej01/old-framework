@api @todos
Feature: Fetch ToDo - API

  Scenario Outline: Make API call to fetch a ToDo object by id <id>.
    Given I request to make a call to fetch a ToDo object by id <id>
    Then The response should contain the respective ToDo object

    Examples:
      | id |
      | 1  |
