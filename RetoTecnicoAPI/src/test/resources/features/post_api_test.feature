# Author: Juan Felipe Velasco García
# Language: EN

Feature: As user i need to realize the operations POST to the REST service

  Background: The user consumes the service
    Given the user wants to call the service

  Scenario Outline: Verify the operation POST
    When consumes post services
      | name   | gender   |
      | <name> | <gender> |
    Then the user will see the correct response
      | response   |
      | <response> |

    Examples:
      | name   | gender | response |
      | Felipe | Male   | 201      |
      |        | Male   | 400      |
      | Felipe |        | 400      |
