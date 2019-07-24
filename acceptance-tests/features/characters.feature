@contract
Feature: Characters

  Scenario: Check health
    When I GET /actuator/health
    Then response code should be 200

  Scenario Outline: 1. Save character with name
    Given I set body to {"leadership": <leadership>,"endurance": <endurance>}
    When I POST to /characters/<name>
    Then response code should be 201

    Examples: 
      | <name> | <leadership> | <endurance> |
      | C1     |            3 |           2 |
      | C2     |            1 |           4 |
