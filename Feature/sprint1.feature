Feature: Registration Process

Background:
Given User enters correct url of the Mercury Tours application
And Clicks on Registration 
And User navigates to the registration page

Scenario: As a user I want Successful Registration by entering valid data so that I can login to the application in future
When User enters the all required data
And User clicks on the submit button
Then User successfully registers into the Murcury Tours application 


Scenario: As a user I want unsuccessful Registration by not entering all required data
When User does not enter all required data
And User clicks on the submit button without all data
Then User fails to registers into the Murcury Tours application 