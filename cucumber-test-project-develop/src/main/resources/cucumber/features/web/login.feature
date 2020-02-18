@web
Feature: Login functionality

  Scenario Outline: Perform login

    Given I access the Vodafone website and I insert the username "<loginUsername>" and the password "<loginPassword>"
    When  I click on the Sign In button
    Then  I should be redirected to the landing page
    And   I should be able to verify the username "<username>" and number "<number>"
    Then  I log out from the website

    Examples:
      | loginUsername | loginPassword | username | number   |
      | testqa2       | Voda1234      | TEST     | 99301383 |
