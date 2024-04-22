Feature: Practice
Background: Coomon steps
	Given User Opens Edge Browser
	When User enters URL "https://demo.seleniumeasy.com/"
	And User click on Start_Practice button
Scenario Outline: Simple form Demo
	And User Click on Simple Form Demo link
	And User Enter the mesage as "<Message>"
	And Click on Show message button
	Then Varify given message is "<Message>"
	When User Enter the value "<a>" and value "<b>"
	And Click On Get Total Button
	Then Varify Total a+b= "<Total>"
	
	
	Examples:
	|Message|a|b|Total|
	|Good Morning|1|2|3|
	|Good AfterNoon|2|3|5|
	|Good Night|4|6|10|
	@Reg
	Scenario Outline: Varifying Checkboxes
		When user click on checkbox demo link text
		And click on first check box
		Then check whether checkbox get checked
		When unchecked default checkbox
		Then checked whether default checkbox is unchecked
		Then disabled checkbox should be disabled
		When user checked multiple boxes from <a> to <b>
		
		
		Examples:
		|a|b|
		|0|2|
		|1|3|
		|0|3|
		|2|3|
	
	Scenario: varyfying dropdown
		When User click on select dropdown link
		And click on day dropdown
		And Select Tuesday
		And Select Thursaday
		And select Friday
		
	Scenario: Handling Alert
		When User click on JavaScript alert link
		And User handle alert box
		And User handle confir box
		And User handles prompt box
		
	
	
	
	
	