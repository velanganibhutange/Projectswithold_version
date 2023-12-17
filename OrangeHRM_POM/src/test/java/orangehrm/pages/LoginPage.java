package orangehrm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{

	// Object Repository
	
	@FindBy(id = "txtUsername")
	WebElement uid_element;
	
	@FindBy(name = "txtPassword")
	WebElement pwd_element;
	
	@FindBy(xpath = "//input[@value='LOGIN']")
	WebElement login_element;
	
	@FindBy(linkText = "Admin")
	WebElement admin_link;
	
	
	@FindBy(partialLinkText = "Welcome")
	WebElement welcome_link;
	
	@FindBy(linkText = "Logout")
	WebElement logout_link;
	
	public void login(String uname,String pword)
	{
		uid_element.sendKeys(uname);
		pwd_element.sendKeys(pword);
		login_element.click();		
	}
	
	public boolean isAdminModuleDisplayed()
	{
		if(admin_link.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}		
	}
	
	public void logout()
	{
		welcome_link.click();
		logout_link.click();
	}
	
	
}
