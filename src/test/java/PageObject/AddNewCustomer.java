package PageObject;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;



public class AddNewCustomer {
	WebDriver ldriver;
	public List<String>data;
	public AddNewCustomer(WebDriver rDriver) {
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	// WebElements on Customer Page
	//Customer Menu
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
    WebElement Customer;
	
	//Customer Item
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement CustomerItem;
	
	//Add new button
	@FindBy(xpath="//a[normalize-space()='Add new']")
	WebElement addbtn;
	
	//Customer info
	@FindBy(id="Email")
	WebElement Email;
	
	@FindBy(id="Password")
	WebElement Pass;
	
	@FindBy(id="FirstName")
	WebElement FirstName;
	
	@FindBy(id="LastName")
	WebElement LastName;
	
	@FindBy(id="Gender_Male")
	WebElement Gender;
	
	@FindBy(id="DateOfBirth")
	WebElement DateOfBirth;
	
	@FindBy(id="Company")
	WebElement Company;
	
	@FindBy(name="save")
	WebElement Save;
	@FindBy(xpath="(/html/body/div[3]/div[1]/div[1]/text())[2]")
	WebElement Alert;
	
	///Search Customer///
	@FindBy(id="SearchEmail")
	WebElement searchEmail;
	
	@FindBy(id="SearchFirstName")
	WebElement SearchFirstName;
	
	@FindBy(id="SearchLastName")
	WebElement SearchLastName;
	
	@FindBy(xpath="//button[@id='search-customers']")
	WebElement searchcustomers;
	
	@FindBy(xpath="//table[@id='customers-grid']//tr/td[1]")
	List<WebElement> table;
	
	
	
	// Action Methods
	public void ClickOnCustomer(){
		Customer.click();
		
	}
	public void clickOnCustomerItem() {
		CustomerItem.click();
	}
	public void clickaddnewbtn() {
		addbtn.click();
	}
	public void enterEmail(String email) {
		Email.sendKeys(email);
	}
	public void enterPassword(String Password) {
		Pass.sendKeys(Password);
	}
	public void firstName(String First) {
		FirstName.sendKeys(First);
	}
	public void lastName(String Last) {
		LastName.sendKeys(Last);
	}
	public void dateofBirth(String dob) {
		DateOfBirth.sendKeys(dob);
	}
	public void company(String company) {
		Company.sendKeys(company);
	}
	public void save() {
		Save.click();
	}
	public void message(String Text) {
		System.out.println(Alert.getText());
		}
	public void search_Email(String email) { 
		searchEmail.sendKeys(email);
	}
	public void searchButton() throws InterruptedException { 
		searchcustomers.click();
		Thread.sleep(3000);;
	}
	public void table() { 
		List<WebElement>tableRows=ldriver.findElements(By.xpath("//table[@id='customers-grid']//tbody/tr"));
		List<WebElement>tableColumns=ldriver.findElements(By.xpath("//table[@id='customers-grid']//td"));
		int Rows=tableRows.size();
		int Column=tableColumns.size();
		System.out.println("No of rows= "+tableRows+" No of data= "+tableColumns);
		data=new LinkedList();
		for(int i=1; i<Rows; i++) {
			for(int j=2; j<=5; j++) {
				WebElement tabledata=ldriver.findElement(By.xpath("//table[@id='customers-grid']//tr["+i+"]/td["+j+"]"));
				String actual=tabledata.getText();
				System.out.print("Data in table    "+actual+"    ");
				data.add(actual);
				
			}
			System.out.println();
		}
		System.out.println(data);
		
		/*if(data.contains("a@gmail.com")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}*/
	}
	
	}


