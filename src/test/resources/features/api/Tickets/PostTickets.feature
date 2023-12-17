# new feature
# Tags: optional
@PostTickets
Feature: POST Tickets

Background:
    Given I set API endpoint for creating a new ticket is available
    #case positive
  Scenario: Successfully create a new ticket with valid inputs
        When I send a request POST to create a new ticket with valid inputs
        And I should receive a status code of 200
        Then I should receive the details of the newly created ticket

#      Scenario: Successfully create a new ticket with future event date
#        When I send a request POST to create a new ticket with future event date
#        And I should receive a status code of 200
#        Then I should receive the details with future event date

          #case negative
    Scenario: Can not create new ticket with missing required fields
        When I send a request POST to create a new ticket with missing required fields
        And I should receive a status code of 400
        Then I should receive message error from missing required fields

#    Scenario: Can not create new ticket with past event date
#        When I send a request POST to create a new ticket with past event date
#        And I should receive a status code of 400
#        Then I should receive message error that indicate bad request

    Scenario: Can not create new ticket with negative quantity
        When I send a request POST to create a new ticket with negative quantity
        And I should receive a status code of 400
        Then I should receive message error from negative quantity





