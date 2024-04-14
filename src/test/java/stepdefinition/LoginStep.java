package stepdefinition;

import org.testng.annotations.AfterMethod; 
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import PageObject.AddNewCustomer;
import PageObject.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStep extends BaseClass {
	@Before
	public void method() {
		System.out.println("Setup Initiated");
		log=LogManager.getLogger("LoginStep");
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		log.info("Broeser setup....");
	}
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		
		loginpg=new LoginPage(driver);
		add=new AddNewCustomer(driver);
		
	}
	    
	

	@When("user opens URL {string}")
	public void user_opens_url(String URL) {
	   driver.get(URL);
	    log.info("Url Enters");
	}

	@When("User enters email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String Email, String Password) {
		WebElement email=driver.findElement(By.id("Email"));
		email.clear();
		email.sendKeys(Email);
		WebElement pass=driver.findElement(By.name("Password"));
		pass.clear();
		pass.sendKeys(Password);
		log.info("All the details Entered");
		
	    
	}

	@When("Click on login")
	public void click_on_login() {
		WebElement button=driver.findElement(By.xpath("//button[text()=\"Log in\"]"));
		button.click();
	    
	}

	@Then("Page Title should be  {string}")
	public void page_title_should_be(String Expected) {
		
		String Actual=driver.getTitle();
		System.out.println(Actual);
		if(Actual.equals(Expected)) {
			AssertJUnit.assertTrue(true);
		}
		else {
			AssertJUnit.assertTrue(false);
		}
		log.info("Title validation....");
	}
	@Then("Close Browser")
	public void close_browser() {
		driver.close();
	   log.info("Close Browser");
	}
	@When("user click on logout link")
	public void user_click_on_logout_link() {
	    WebElement link=driver.findElement(By.linkText("Logout"));
	    link.click();
	}
	
	@When("User click on Customer Menu")
	public void user_click_on_customer_menu() {
		add.ClickOnCustomer();
	    	}
	@When("User click on customer Menu Item")
	public void user_click_on_customer_menu_item() throws InterruptedException {
	    add.clickOnCustomerItem();
	    Thread.sleep(3000);
	}
	@When("User click on ADD NEW button")
	public void user_click_on_add_new_button() {
	    add.clickaddnewbtn();
	}
	@Then("User can view ADD new customer Page")
	public void user_can_view_add_new_customer_page() {
		String Actual=driver.getTitle();
		System.out.println(Actual);
		if(Actual.equals("Add a new customer / nopCommerce administration")) {
			AssertJUnit.assertTrue(true);
		}
		else {
			AssertJUnit.assertTrue(false);
		}
	    
	}
	@When("User enters customer info")
	public void user_enters_customer_info() {
	    add.enterEmail(generateEmailId()+"@gmail.com");
	    add.enterPassword("12345");
	    add.firstName("ABC");
	    add.lastName("XYZ");
	    add.dateofBirth("1/10/1992");
	    add.company("Dot");
	    log.info("entering Email Id and details");
	}
	@When("click on SAVE button")
	public void click_on_save_button() throws InterruptedException {
	    add.save();
	    Thread.sleep(2000);
	}
	@Then("User can View Confirmation message {string}")
	public void user_can_view_confirmation_message(String Text) {
		add.message(Text);
		
	    
	}
	@When("Enter customer email as {string}")
	public void enter_customer_email_as(String SearchEmail) {
		add.search_Email(SearchEmail);
	    
	}
	@When("User click on search button")
	public void user_click_on_search_button() throws InterruptedException {
	    add.searchButton();
	}
	@Then("User should found email in search table")
	public void user_should_found_email_in_search_table() {
	    add.table();
	    log.info(add.data);
	}
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		
			final byte[]screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName()); 
	}
	@After
	public void teardown(Scenario sc) throws IOException {
		System.out.println("Teardown Initiated");
		/*if(sc.isFailed()==true) {
			String filepath="C:\\Users\\yoges\\eclipse-workspace\\cucumber1\\Screenshot\\test1.png";
			TakesScreenshot ts=(TakesScreenshot)driver;
			File scr=ts.getScreenshotAs(OutputType.FILE);
			File file=new File(filepath);
			FileUtils.copyFile(scr, file); 
			
		}*/
		driver.quit();
		
		}

}

