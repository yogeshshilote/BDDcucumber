package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AmazonePOM {
	WebDriver ldriver;
	public AmazonePOM(WebDriver rDriver) {
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	
	
	
	//
}
