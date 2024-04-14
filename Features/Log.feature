Feature: Login
@Sanity 
Scenario: Successful login with valid credentials
	Given User Launch Chrome browser
	When user opens URL "https://admin-demo.nopcommerce.com/"
	And User enters email as "admin@yourstore.com" and Password as "admin"
	And Click on login
	Then Page Title should be  "Dashboard / nopCommerce administration"
	#And Close Browser
@Regression
Scenario Outline: Successful login with valid credential DDT
	Given User Launch Chrome browser
	When user opens URL "https://admin-demo.nopcommerce.com/"
	And User enters email as "<email>" and Password as "<Password>"
	And Click on login
	Then Page Title should be  "Dashboard / nopCommerce administration"
	When user click on logout link
	Then Page Title should be  "Your store. Login"
	#And Close Browser
	
Examples:
|email|Password|
|admin@yourstore.com|admin|
|admin@yourstore.com|admin|
|admin@yourstore.com|admin1|

