package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage{
		
		WebDriver ldriver;

	public LoginPage(WebDriver rDriver)
	{
		ldriver=rDriver;
		
		PageFactory.initElements(rDriver, this);
	}

	/*@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(xpath = "//button[@class = 'button-1 login-button']")
	WebElement LoginBtn;
	
	@FindBy(linkText = "Logout")
	WebElement logout;
	
	public void enterEmail(String emailAdd)
	{
		email.clear();
		email.sendKeys(emailAdd);
	}
	
	public void enterPassword(String pwd)
	{
		password.clear();
	    password.sendKeys(pwd);
	}
	
	public void clickOnLoginButton()
	{
		LoginBtn.click();
	}
	
	public void clickOnLogoutButton()
	{
		logout.click();
	}
	 ////Search Customer////
	@FindBy(id = "searchBox")
	WebElement searchbox;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div")
	WebElement searchResult;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]")
	List<WebElement> tableRows;
	
	public void enterEmail(String email)
	{
		searchbox.sendKeys(email);
	}
	
	public boolean SearchCustomerByEmail(String email)
	{
		boolean found = false;
		
		int ttlRows = tableRows.size();
		
		for(int i=1; i<=ttlRows; i++)
		{
			WebElement webelementEmailAdd = ldriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[4]"));
			
			String actaulEmailAdd = webelementEmailAdd.getText();
			
			if(actaulEmailAdd.equals(email))
			{
				found=true;
			}
		}
		return found;
	}*/
	
	@FindBy(xpath = "//input[@id = 'searchBox']")
    WebElement searchbox;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]")
	List<WebElement> tableRows;
	
	public void enterEmailAdd(String email)
	{
		searchbox.sendKeys(email);
	}
	
	public boolean SearchCustomerByEmail(String email)
	{
		boolean found = false;
		
		int ttlRows = tableRows.size();
		
		for(int i=1; i<=ttlRows; i++)
		{
			WebElement webelementemailadd = ldriver.findElement(By.xpath("//*[@id=\\\"app\\\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[4]"));
			
			if(webelementemailadd.equals(email))
			{
				found = true;
			}
		}
		return found;
	}
	
	
	
	
	
	
}
    