package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement txtFname;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement txtLname;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='telephone']")
	WebElement txtTele;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='confirm']")
	WebElement txtConfPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnContinue;
	
	@FindBy(xpath="//div[@id='content']//h1")
	WebElement msgConfirmation;
	
	public void setFirstName(String fname)
	{
		txtFname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLname.sendKeys(lname);
	}

	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tele)
	{
		txtTele.sendKeys(tele);
	}
	
	public void setPassword(String psswd)
	{
		txtPassword.sendKeys(psswd);
	}
	
	public void setConfPassword(String confPsswd)
	{
		txtConfPassword.sendKeys(confPsswd);
	}
	
	public void checkPolicy()
	{
		chkPolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}
	
	public String getConfirmationMessage()
	{
		try
		{
		return (msgConfirmation.getText());
		}catch (Exception e) {
			return (e.getMessage());
		}
	}
}
