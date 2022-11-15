Feature: Users API Endpoints tests

  Scenario: Get list of all users
    Given I hit the get endpoint for users
    Then the response will have status 200