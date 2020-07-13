Feature: User Registration
	i want to check that the user can register in ourr ecpmmerce website
	
	Scenario Outline: UserRegistration
	Given The user in the home page
	When I click on register link
	And I entered "<firstname>","<lastname>","<email>","<password>"
	Then The registration page displayed successfully
	
	Examples: 
	| firstname | lastname | email | password |
	|ahmed | noor | test323@email.com |1234533|
	|gehad | mohamed | test232@email.com |1217533|
	|ali | mohamed | test123@email.com |12464533|