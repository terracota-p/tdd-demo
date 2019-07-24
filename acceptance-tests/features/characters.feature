@contract
Feature: Characters

   Scenario: Check health
     When I GET /actuator/health
     Then response code should be 200
