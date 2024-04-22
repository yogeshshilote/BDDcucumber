package stepdefinition;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import PageObject.AmazonePOM;
import cucumber1.ExtentManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class amazone extends BaseClass {
	public ExtentReports extent;
	/*@Before
	public void method() {
		System.out.println("Setup Initiated");
		log=LogManager.getLogger("LoginStep");
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		log.info("Browser setup....");
		extent = ExtentManager.getInstance();
		ExtentCucumberAdapter.addTestStepLog(
			    "<span class=\"bordered-text\" style=\"background-color: lightgray;\">" +
			    "<span style=\"font-size: 14px; color: blue;\">Browser Setip....</span>" +
			    "<span style=\"font-size: 14px; color: red;\">   Edge Browser   </span>" +
			    "</span>"
			);
	}*/
	@Given("User is on the Url {string}")
	public void user_is_on_the_url(String URL) throws InterruptedException {
		amz=new AmazonePOM(driver);
		driver.get(URL);
	    Thread.sleep(3000);
	}
	@Then("Page title should be")
	public void page_title_should_be() {
	   driver.getTitle();
	   log.info(driver.getTitle());
	   ExtentCucumberAdapter.addTestStepLog(driver.getTitle());
	   ExtentCucumberAdapter.addTestStepLog(
			     "<span class=\"bordered-text\"><span style=\"font-family: Verdana, sans-serif; font-size: 14px;\">"+driver.getTitle()+"</span></span>"
			 );
	}
	@Then("Page source should be")
	public void page_source_should_be() {
	    driver.getPageSource();
	    log.info(driver.getPageSource());
	    ExtentCucumberAdapter.addTestStepLog(
			    "<span class=\"bordered-text\" style=\"background-color: lightblue;\">" +
			    "<span style=\"font-size: 14px; color:green ;\">"+driver.getPageSource()+"</span>" );
			   
	}
	
	@Then("Cookies should be")
	public void cookies_should_be() {
	   
	    Set<Cookie>cookies=new HashSet();
	    cookies= driver.manage().getCookies();
	    System.out.println(cookies);
	    log.info(cookies);
	    ExtentCucumberAdapter.addTestStepLog("Cookies: " + cookies);
	    ExtentCucumberAdapter.addTestStepLog(
			    "<span class=\"bordered-text\" style=\"background-color: lightgray;\">" +
			    "<span style=\"font-size: 14px; color:blue ;\">Cookies: "+cookies+"</span>" );
	}
	@Then("Window handle should be")
	public void window_handle_should_be() {
	    Set<Cookie>winId=driver.manage().getCookies();
	    System.out.println(winId);
	    log.info(winId);
	    ExtentCucumberAdapter.addTestStepLog("<font color=\"#A3C624\">"+winId+"</font>");
	}
	
	/*@AfterStep
	public void addScreenshot(Scenario scenario) {
		
			final byte[]screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName()); 
	}
	@After
	public void teardown(Scenario sc) throws IOException {
		System.out.println("Teardown Initiated");
		driver.quit();
}
	@Then("Close Browser")
	public void close_browser() {
		driver.close();
	   log.info("Close Browser");
	   extent.flush();
	} */
}
