Feature: Login Functionality

Background:
	Given User enters the url of the Mercury Tours application
	And User navigates to the login page

Scenario: Successful Login with valid credentials	
	When User enters the valid username and valid password
	And User clicks on the submit button in home page
	Then User successfully login into the Murcury Tours application   

Scenario: Unsuccessful Login with valid username and invalid password
	When User enters the invalid credentials
	And User clicks on the submit button in home page with invalid credentials 
	Then User failed login into the Murcury Tours application   


