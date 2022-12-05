# Author: Juan Felipe Velasco García
# Language: EN

Feature: As user i need to realize the operations DELETE to the REST service

  Background: The user consumes the service
    Given the user wants to call the service

  Scenario Outline: Verify the operation DELETE
    When the user consumes DELETE services
      | id   |
      | <id> |
    Then the user will see the correct response
      | response   |
      | <response> |
    And the user see the correct message
      | message   |
      | <message> |
    And the user verify the eliminated member
      | id   |
      | <id> |

    Examples:
      | id | response | message                                  |
      | 9  | 200      | Member with id 9 is deleted successfully |
