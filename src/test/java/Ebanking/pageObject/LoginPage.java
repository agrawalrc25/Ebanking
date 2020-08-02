package Ebanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public	LoginPage(WebDriver rdriver)      // Constructor need to make public as we are going to access it from other package
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);  ///Page Factory
	}

	@FindBy(name="uid")               ///Locators on Login Page
	@CacheLookup
	WebElement TxtUserName;

	@FindBy(name="password")
	@CacheLookup
	WebElement TxtPassword;

	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement LoginButton;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	
	
	public void SetUsername(String uname)    //Action Methods 
	{
		TxtUserName.sendKeys(uname);
	}

	public void SetPassword(String pwd)
	{
		TxtPassword.sendKeys(pwd);
	}
	
	public void ClickSubmit()
	{
		LoginButton.click();
	}

	public void clickLogout() 
		{
			lnkLogout.click();
		}
		
	
	

}
