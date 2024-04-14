Feature: Customer

Background: Steps common for all scenarios
	Given User Launch Chrome browser
	When user opens URL "https://admin-demo.nopcommerce.com/"
	And User enters email as "admin@yourstore.com" and Password as "admin"
	And Click on login
	Then Page Title should be  "Dashboard / nopCommerce administration"
	When User click on Customer Menu
	And User click on customer Menu Item
	
	@Sanity
Scenario: Add new Customer

	And User click on ADD NEW button
	Then User can view ADD new customer Page
	When User enters customer info
	And click on SAVE button
	#Then User can View Confirmation message "The new customer has been added successfully."
	#And Close Browser
	
Scenario: Search customer with Email
	
	#And Enter customer email as "a@gmail.com"
	And User click on search button
	Then User should found email in search table
	#And Close Browser		