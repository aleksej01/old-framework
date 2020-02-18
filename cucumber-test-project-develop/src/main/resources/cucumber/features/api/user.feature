@api @users
Feature: Fetch Users - API

  Scenario Outline: Make API call to fetch a User object by id <id>.
    Given I request to make a call to fetch a User object by id <id>
    Then The response should contain the respective User object

    Examples:
      | id |
      | 1  |