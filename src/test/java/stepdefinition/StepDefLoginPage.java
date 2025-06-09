package stepdefinition;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import PageObject.LoginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefLoginPage {

	public WebDriver driver;
	public LoginPage loginpg;


	/*@Given("User Launch Edge browser")
	public void user_launch_edge_browser() {
		WebDriverManager.edgedriver().setup();
		driver =new EdgeDriver();

		loginpg = new LoginPage(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String password) {
		loginpg.enterEmail(emailAdd);
		loginpg.enterPassword(password);

	}

	@When("Click on Login")
	public void click_on_login() {
		loginpg.clickOnLoginButton();

	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle=driver.getTitle();

		if(actualTitle.equals(expectedTitle)) 
		{
			Assert.assertTrue(true); //pass
		}
		else
		{
			Assert.assertTrue(false); //fail
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		loginpg.clickOnLogoutButton();
	}

	/*@Then("page Title should be {string}")
	public void page_title_should_be(String string) {

	}*/
	

	@Given("User Launch Edge browser")
	public void user_launch_edge_browser() {
		WebDriverManager.edgedriver().setup();
		driver =new EdgeDriver();

		loginpg = new LoginPage(driver);
		
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);	
	}

	@When("Enter Customer Email")
	public void enter_customer_email() {
		loginpg.enterEmailAdd("alden@example.com");	
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedEmail = "alden@example.com";
		
		//Assert.assertTrue(loginpg.SearchCustomerByEmail(expectedEmail));
		
		if(loginpg.SearchCustomerByEmail(expectedEmail) ==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		
	}
	@Then("close browser")
	public void close_browser() {
	   driver.close();
	}

}