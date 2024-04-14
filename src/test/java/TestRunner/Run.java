package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import org.junit.runner.RunWith;		

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features={".//Features/customer.feature",".//Features/Log.feature"},
		glue="stepdefinition",
		dryRun=false,
		monochrome=false,
		//tags="@Regression",
		//plugin= {"pretty","json:target/cucumber-reports/reports1.json", "html:target/cucumber-reports/reports11.html", "junit:target/cucumber-reports/reports2.xml"}
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
		

public class Run extends AbstractTestNGCucumberTests {
   // This class will be empty
}
