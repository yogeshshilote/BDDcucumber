package PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PracticePOM {

		WebDriver ldriver;
		public PracticePOM(WebDriver rDriver) {
			ldriver=rDriver;
			PageFactory.initElements(rDriver, this);
		}
		
	@FindBy(xpath="//div[@id='home']//descendant::a[@id='btn_basic_example']")
	WebElement start;
	
	@FindBy(xpath="//div[@id='basic']//descendant::div/a[text()='Simple Form Demo']")
	WebElement FormLink;
	
	@FindBy(id="user-message")
	WebElement message;
	
	@FindBy(xpath="//button[text()='Show Message']")
	WebElement show;
	
	@FindBy(xpath="//span[@id='display']")
	WebElement UserMessage;
	
	@FindBy(xpath="//input[@id='value1']")
	WebElement value1;
	
	@FindBy(xpath="//input[@id='value2']")
	WebElement value2;
	
	@FindBy(xpath="//button[text()='Get Total']")
	WebElement Totalbtn;
	
	@FindBy(xpath="//span[@id='displayvalue']")
	WebElement display;
	
	//Verifying checkboxes
	@FindBy(linkText="Check Box Demo")
	WebElement cboxlink;
	
	@FindBy(id="isAgeSelected")
	WebElement select;
	
	@FindBy(xpath="//label[normalize-space()='Default Checked']")
	WebElement unselect;
	
	@FindBy(xpath="//label[normalize-space()='Default Disabled']")
	WebElement disabled;
	
	@FindBy(xpath="//input[@class='cb1-element']")
	List<WebElement> cboexes;
	
	//Dropdown
	@FindBy(linkText="Select Dropdown List")
	WebElement dropdownlink;
	
	@FindBy(id="select-demo")
	WebElement dropdown;
	
	//Alert handling
	@FindBy(linkText="Javascript Alerts")
	WebElement Alerts;
	
	@FindBy(xpath="(//button[text()='Click me!'])[1]")
	WebElement Alert;
	
	@FindBy(xpath="(//button[text()='Click me!'])[2]")
	WebElement confirm;
	
	@FindBy(xpath="//button[text()='Click for Prompt Box']")
	WebElement prompt;
	
	
	
	
	
	
	
	
	
	//Methods
	//Click on Start Practice button
	public void Start() {
		start.click();
	}
	
	//Click ON For LInk
	public void clickForm() {
		FormLink.click();
	}
	//Enter message in textbox
	public void message(String Message) {
		message.sendKeys(Message);
	}
	//Click on Show Message
	public void show() {
		show.click();
	}
	public void varifymessage(String Message) {
		if(UserMessage.getText().equals(Message)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
	//Puttting value 1 and 2
	public void value1(String value) {
		value1.sendKeys(value);
	}
	public void value2(String value) {
		value2.sendKeys(value);
	}
	//Clicking 'Get Total' Button
	public void clickTotal() {
		Totalbtn.click();
	}
	public void displayvalue(String value) {
		if(display.getText().contains(value)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
	}
	
	//Checkbox varification
	public void clickLink() {
		cboxlink.click();
	}
	public boolean selectbox() {
		select.click();
		 return select.isSelected();
	}
	public void uncheck() {
		unselect.click();
	}
	public boolean status() {
		return unselect.isEnabled();
	}
	public boolean disabledbox() {
		return disabled.isEnabled();
		
	}
	public List<String> multiplebox(int start, int end) throws InterruptedException {
		List<String> option=new ArrayList();
		for( int i=start; i<=end; i++) {
			cboexes.get(i).click();
			String text=cboexes.get(i).getText();
			option.add(text);
			
			
		}
		Thread.sleep(3000);
		return option;
	}
	
	//Dropdwn
	public void drplink() {
		dropdownlink.click();
	}
	public void droplink() {
		dropdown.click();
	}
	public void tues() {
		Select drop=new Select(dropdown);
		drop.selectByVisibleText("Tuesday");
	}
	public void thurs() {
		Select drop=new Select(dropdown);
		drop.selectByValue("Tuesday");
	}
	public List<String> all(){
		Select drop=new Select(dropdown);
		List<WebElement> options=drop.getOptions();
		List<String>text=new ArrayList();
		for(WebElement option:options) {
			String list=option.getText();
			text.add(list);
			if(list.equals("Saturday")) {
				option.click();
			}
		}
		return text;
	}
	public void AlertLink() {
		Alerts.click();
	}
	public void switchToAlert() {
         ldriver.switchTo().alert().accept();
	}
	
	
	
	

	
	
	
	}
	
	
	


