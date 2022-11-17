Feature: Users API Endpoints tests

  Scenario Outline: Get list of all users on page "<pageNo>"
    Given I hit the get endpoint for users page "<pageNo>"
    Then the response will have status 200
    Examples:
      | pageNo |
      | 1      |
      | 2      |

    Scenario: Get single user details
      Given I hit the get endpoint for user id 1
      Then the response will have status 200
