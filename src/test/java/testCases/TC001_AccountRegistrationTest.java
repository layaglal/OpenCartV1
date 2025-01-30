package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups={"regression","master"})
	public void verify_Account_Registration() throws InterruptedException
	{
		logger.info("***************Starting Test case execution***************");
		try{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account Link");
		//Thread.sleep(3000)[];
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage regPage= new AccountRegistrationPage(driver);
		regPage.setFirstName("layyaa");
		regPage.setLastName("Faan");
		regPage.setEmail(p.getProperty("email"));
		regPage.setTelephone("994434834");
		regPage.setPassword(p.getProperty("password"));
		regPage.setConfPassword(p.getProperty("password"));
		regPage.checkPolicy();
		regPage.clickContinue();
		logger.info("Validating expected message");
		String confirmMsg=regPage.getConfirmationMessage();
		
		Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
	}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs.........");
			Assert.fail();
		}
		
		logger.info("***************Finished Test case*************");
	}
	
	
}
