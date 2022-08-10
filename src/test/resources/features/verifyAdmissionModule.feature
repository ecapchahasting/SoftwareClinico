@Smoke

Feature: Verify the module admission

Scenario: Validate Module Admission
Given I open the T-Integro
When I Login to T-Integro with email Username and password Password
Then I go to the admission module
Then I will fill in the data with the Document 20285197 Name Gabriela and first surname Rodriguez
When I verify the message exists: 'No existe registro con los parametros ingresados'
