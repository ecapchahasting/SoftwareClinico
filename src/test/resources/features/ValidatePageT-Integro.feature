@Test

Feature: Validate Page T-Integro

Scenario: Validate result page T-Integro
Given I open the T-Integro
When I Login to T-Integro with email Username and password Password
Then I go validate username
Then I go will Validate the Modules
Then I go to the admission module
Then I will fill in the data with the Document 20285197 Name Gabriela and first surname Rodriguez
When I verify the message exists: 'No existe registro con los parametros ingresados'
Then I go to the Surgical Center Module
Then I go going to search for room programming in the surgical center module
