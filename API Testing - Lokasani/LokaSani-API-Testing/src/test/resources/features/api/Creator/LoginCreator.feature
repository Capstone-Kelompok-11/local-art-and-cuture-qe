# new feature
# Tags: optional

Feature: Login Creator

  Background:
    Given I set API endpoint for login creator

  Scenario Outline: Successfully login creator with valid credentials
    When I send request to login creator with valid email "<email>" and valid password "<password>"
    Then I receive status code 200
    And I receive valid data for login creator
    Examples:
      | email            | password |
      | accnew@gmail.com | 123      |
