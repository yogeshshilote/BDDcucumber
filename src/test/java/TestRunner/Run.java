 package TestRunner;




import org.junit.runner.RunWith;		

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//Features/SearchCustomer.feature",
		glue="stepdefinition",
		dryRun=false,
		monochrome=true,
		plugin = {"pretty","html:target/cucumber-reports/reports14.html"}
		//tags="@Win",
		//plugin= {"pretty","json:target/cucumber-reports/reports1.json", "html:target/cucumber-reports/reports11.html", "junit:target/cucumber-reports/reports2.xml"}
		//plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)
		

public class Run {
   // This class will be empty
}
