
Feature: Register
  As a user
  I want to register
  So that I can use application features

  @Register
  Scenario: Successfully register with valid inputs
    Given I set API endpoint for register
    When I send request to register
    Then I receive status code 200
    And I receive valid data for register

  Scenario: Can not register with existing data
    Given I set API endpoint for register
    When I send request register with existing data
    Then I receive status code 400
    And I receive message error for register

