@Smoke

Feature: Verify the module admission

Scenario: Validate Module Admission
Given I open the T-Integro
When I Login to T-Integro with email Username and password Password
Then I go to the nursing module
Then I go will fill in the data with the Document 20285197 Name Gabriela and first surname Rodriguez and second surname Perez
When I will verify that the search message: 'Paciente no existente'
