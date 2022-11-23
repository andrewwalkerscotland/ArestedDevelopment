Feature: Users API Endpoints tests

  Scenario Outline: Get list of all users on page "<pageNo>"
    Given I hit the get endpoint for users page "<pageNo>"
    Then the response will have status 200
    And the response will contain 6 users
    Examples:
      | pageNo |
      | 1      |
      | 2      |

    Scenario Outline: Get single user details
      Given I hit the get endpoint for user id <userId>
      Then the response will have status 200
      And the user email will be "<email>"
      And the user first name will be "<first_name>"
      And the user last name will be "<last_name>"
      And the user avatar link will be "<avatar>"
      Examples:
      | userId | email                    | first_name | last_name | avatar                                    |
      | 1      | george.bluth@reqres.in   | George     | Bluth     | https://reqres.in/img/faces/1-image.jpg   |

