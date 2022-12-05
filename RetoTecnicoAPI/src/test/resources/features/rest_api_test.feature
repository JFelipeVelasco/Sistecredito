# Author: Juan Felipe Velasco García
# Language: EN

Feature: As user i need to realize the operations GET to the REST service

  Background: The user consumes the service
    Given the user wants to call the service

  Scenario Outline: Verify the operation GET
    When the user consumes get services
      | id   |
      | <id> |
    Then the user will see the correct response
      | response   |
      | <response> |
    And the user see the correct message
      | message   |
      | <message> |

    Examples:
      | id  | response | message                          |
      | 1   | 200      | Monil                            |
      | 909 | 404      | Member with id 909 doesn't exist |
      | a   | 404      | Member with id a doesn't exist   |