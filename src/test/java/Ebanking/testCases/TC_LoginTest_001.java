package Ebanking.testCases;


import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Ebanking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	
	@Test
	public void loginTest() throws IOException
	{
		//driver.get(baseURL);	 put in Base Class
		
		logger.info("URL Open");
		
		LoginPage lp=new LoginPage(driver);
		lp.SetUsername(username);
		logger.info("Enter Username");
		
		lp.SetPassword(password);
		logger.info("Enter Password");
		
		lp.ClickSubmit();
		logger.info("Click Submit Button");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else
		{
			captureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
			
	}

}
