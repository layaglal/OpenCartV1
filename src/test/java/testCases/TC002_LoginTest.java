package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"sanity", "master"})
	public void verify_Login()
	{
		try {
		logger.info("***********Starting TC002_LoginTest***********");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("lemail"));
		lp.setPassword(p.getProperty("lpassword"));
		lp.clickLoginButton();
		
		MyAccountPage mac=new MyAccountPage(driver);
		boolean targetPage= mac.isMyAccountPageExists();
		
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***************Finished TC002_LoginTest**************");
	}

}
