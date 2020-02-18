@android
Feature: Android sample test

  Scenario Outline: Click on button to display text
    Given I click on the Display Popup Window button
    Then The text "<text>" should be displayed

    Examples:
      | text                        |
      | Text is sometimes displayed |
