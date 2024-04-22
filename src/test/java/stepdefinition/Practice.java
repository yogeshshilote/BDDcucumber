package stepdefinition;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import PageObject.PracticePOM;
import cucumber1.ExtentManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice extends BaseClass {
    private PracticePOM practice;

    @Before
    public void setup() {
        log = LogManager.getLogger("LoginStep");
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        log.info("Browser setup....");
        //extent = ExtentManager.getInstance();
        ExtentCucumberAdapter.addTestStepLog(
            "<span class=\"bordered-text\" style=\"background-color: lightgray;\">" +
            "<span style=\"font-size: 14px; color: blue;\">Browser Setup....</span>" +
            "<span style=\"font-size: 14px; color: red;\">   Edge Browser   </span>" +
            "</span>"
        );
    }

    @Given("User Opens Edge Browser")
    public void user_opens_edge_browser() {
        practice = new PracticePOM(driver);
    }

    @When("User enters URL {string}")
    public void user_enters_url(String URL) {
        driver.get(URL);
        ExtentCucumberAdapter.addTestStepLog("<a href=\"https://demo.seleniumeasy.com/\">URL</a>");


    }
	@When("User click on Start_Practice button")
	public void user_click_on_start_practice_button() {
		practice.Start();
	}
	@When("User Click on Simple Form Demo link")
	public void user_click_on_simple_form_demo_link() {
		practice.clickForm();
		ExtentCucumberAdapter.addTestStepLog("<span style=\"color: green;\">User Click On the form link</span>");

	}
	@When("User Enter the mesage as {string}")
	public void user_enter_the_mesage_as(String Message) {
	   practice.message(Message);
	   ExtentCucumberAdapter.addTestStepLog("<span style=\"color: green;\">"+Message+"<span>");
	}
	@When("Click on Show message button")
	public void click_on_show_message_button() {
	    practice.show();
	}
	@Then("Varify given message is {string}")
	public void varify_given_message_is(String Message) {
		practice.varifymessage(Message);
		ExtentCucumberAdapter.addTestStepLog("<span style=\"color: green;\">"+Message+"<span>");
		}
	@When("User Enter the value {string} and value {string}")
	public void user_enter_the_value_and_value(String val1, String val2) {
	    practice.value1(val1);
	    practice.value2(val2);
	    ExtentCucumberAdapter.addTestStepLog("<span style=\"color: green;\">"+"Value1= "+val1+"   Value2= "+val2+"<span>");
	}
	
	@When("Click On Get Total Button")
	public void click_on_get_total_button() {
	    practice.clickTotal();
	}
	@Then("Varify Total a+b= {string}")
	public void varify_total_a_b(String Total) {
	    practice.displayvalue(Total);
	    ExtentCucumberAdapter.addTestStepLog("<button style=\"color: red;\"> Total= "+Total+"<button>");
	}
	
	// code for check box
	    @When("user click on checkbox demo link text")
	    public void user_click_on_checkbox_demo_link_text() {
	       practice.clickLink();
	       ExtentCucumberAdapter.addTestStepLog("<span style=\"color: green;\"> User clicked on Checkbox link </span>");
	    }
	    @When("click on first check box")
	    public void click_on_first_check_box() {
	    	practice.selectbox();
	       
	    }
	    @Then("check whether checkbox get checked")
	    public void check_whether_checkbox_get_checked() {
	    	 if(practice.selectbox()==true) {
		        	ExtentCucumberAdapter.addTestStepLog("<span style=\"color: green\">Checbox is Successfully selected</span>");
		        }
		        else {
		        	ExtentCucumberAdapter.addTestStepLog("<span style=\"color: green\">Checkbox failed to select</span>");
		        }
	    }
	    @When("unchecked default checkbox")
	    public void unchecked_default_checkbox() {
	    	practice.uncheck();
	    }
	    @Then("checked whether default checkbox is unchecked")
	    public void checked_whether_default_checkbox_is_unchecked() {
	    	ExtentCucumberAdapter.addTestStepLog("<span style=\"color: green\">checkbox selected= "+practice.status()+"</span>");
	    }
	    @Then("disabled checkbox should be disabled")
	    public void disabled_checkbox_should_be_disabled() {
	    	ExtentCucumberAdapter.addTestStepLog("<span style=\"color: green\">checkbox diabled= "+practice.disabledbox()+"</span>");
	    }
	    @When("user checked multiple boxes from {int} to {int}")
	    public void user_checked_multiple_boxes_from_to(Integer a, Integer b) throws InterruptedException {
	    	 List<String> result = practice.multiplebox(a, b);
	    	    String logMessage = "<span style=\"color: green\">checkbox disabled = " + String.join(", ", result) + "</span>";
	    	    ExtentCucumberAdapter.addTestStepLog(logMessage);
	    }
	    
	    //dropdown
	    @When("User click on select dropdown link")
	    public void user_click_on_select_dropdown_link() {
	        practice.drplink();
	    }
	    @When("click on day dropdown")
	    public void click_on_day_dropdown() {
	        practice.droplink();
	    }
	    @When("Select Tuesday")
	    public void select_tuesday() {
	        practice.tues();
	    }
	    @When("Select Thursaday")
	    public void select_thursaday() {
	        practice.thurs();
	    }
	    @When("select Friday")
	    public void select_friday() {
	        
	        ExtentCucumberAdapter.addTestStepLog("<span style=\"color: green\">All Option = "+practice.all()+"</span>");
	    }
	
	 @AfterStep
	    public void addScreenshot(Scenario scenario) {
	        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	        scenario.attach(screenshot, "image/png", scenario.getName());
	    }

	    @After
	    public void teardown() {
	        System.out.println("Teardown Initiated");
	        driver.quit();
	    }
	}

