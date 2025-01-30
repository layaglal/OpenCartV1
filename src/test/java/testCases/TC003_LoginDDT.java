package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;
/*
 * Data valid--login successful--test pass--Logout
 * Data valid--login unsuccessful--test fail
 * 
 * Data invalid--login unsuccessful--test pass
 * Data invalid--login successful--test fail--Logout
 */
public class TC003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="datadriven")
	public void verify_LoginDDT(String email, String pswd, String expRes)
	{
		logger.info("****************Starting TC003_LoginDDT***************");
		
		try{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pswd);
		lp.clickLoginButton();
		
		MyAccountPage mac=new MyAccountPage(driver);
		boolean targetPage= mac.isMyAccountPageExists();
		
		if(expRes.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				mac.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(expRes.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				mac.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{			
				Assert.fail();
		}
		logger.info("****************Finished TC003_LoginDDT***************");
	}

}
