package orangehrm.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import orangehrm.library.LoginPage;
import utils.AppUtils;

public class AdminLoginTestwithValidInputs  extends AppUtils
{
@Parameters({"uid","pwd"})
@Test

	public void checkAdminLogin(String uid, String pwd) 
	{
		LoginPage lp = new LoginPage();
		lp.login(uid, pwd);
		boolean res = lp.isAdminModuleDisplayed();
		AssertJUnit.assertTrue(res);
		lp.logout();
	}
}
