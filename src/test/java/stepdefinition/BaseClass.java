package stepdefinition;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Logger.*;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomer;
import PageObject.AmazonePOM;
import PageObject.LoginPage;
import PageObject.PracticePOM;

public class BaseClass {
	public WebDriver driver;
	public LoginPage loginpg;
	public AddNewCustomer add;
	public AmazonePOM amz;
	public static Logger log;
	public PracticePOM practice;
	
	public String generateEmailId() {
		return(RandomStringUtils.randomAlphabetic(7));
	}
}
