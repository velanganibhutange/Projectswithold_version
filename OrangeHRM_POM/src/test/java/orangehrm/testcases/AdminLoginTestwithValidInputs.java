package orangehrm.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrm.pages.LoginPage;
import utils.AppUtils;

public class AdminLoginTestwithValidInputs extends AppUtils 
{

	@Test
	public void checkAdminLogin()
	{
		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.login("Admin", "Qedge123!@#");
		boolean res = lp.isAdminModuleDisplayed();
		Assert.assertTrue(res);
		lp.logout();
		
	}
	
	
}
