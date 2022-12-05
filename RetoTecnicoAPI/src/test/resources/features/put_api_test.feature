# Author: Juan Felipe Velasco García
# Language: EN

Feature: As user i need to realize the operations PUT to the REST service

  Background: The user consumes the service
    Given the user wants to call the service

  Scenario Outline: Verify the operation PUT
    When the user consumes PUT services
      | id   | name   | gender   |
      | <id> | <name> | <gender> |
    Then the user will see the correct response
      | response   |
      | <response> |
    And the user see the correct message
      | message   |
      | <message> |
    And and verify the update information
      | name   | gender   |
      | <name> | <gender> |

    Examples:
      | id  | name     | gender | response | message                                  |
      | 1   | Test PUT | Female | 200      | Member with id 1 is updated successfully |
      | 999 | Test PUT | Female | 404      | Member with id 999 doesn't exist         |