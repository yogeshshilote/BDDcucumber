package stepdefinition;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Logger.*;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomer;
import PageObject.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage loginpg;
	public AddNewCustomer add;
	public static Logger log;
	
	public String generateEmailId() {
		return(RandomStringUtils.randomAlphabetic(7));
	}
}
