@Smoke

Feature: Verify the module surgical center

Scenario: Validate Module Surgical Center
Given I open the T-Integro
When I Login to T-Integro with email Username and password Password
Then I go to the Surgical Center Module
Then I go going to search for room programming in the surgical center module
When I go verify the message exists: 'No se encontraron programaciones de sala con los filtros seleccionados'

