package orangehrm.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import orangehrm.library.LoginPage;
import utils.AppUtils;
import utils.XLUtils;

public class AdminLoginTestwithValidData extends AppUtils
{

	String datafile ="C:\\xldemo\\TestData1.xlsx";
	String datasheet = "AdminLogin_ValidData";
	
	@Test
	public void checkAdminLogin() throws IOException
	{
		
		int rowcount = XLUtils.getRowCount(datafile, datasheet);
		
		String uid,pwd;
		
		for(int i=1;i<=rowcount;i++)
		{
			
			uid = XLUtils.getStringData(datafile, datasheet, i, 0);
			pwd = XLUtils.getStringData(datafile, datasheet, i, 1);
			
			LoginPage lp = new LoginPage();
			lp.login(uid, pwd);
			boolean res = lp.isAdminModuleDisplayed();
			Assert.assertTrue(res);
			if(res)
			{
				XLUtils.setCellData(datafile, datasheet, i, 2, "Pass");
				XLUtils.fillGreenColor(datafile, datasheet, i, 2);
			}else
			{
				XLUtils.setCellData(datafile, datasheet, i, 2, "Fail");
				XLUtils.fillRedColor(datafile, datasheet, i, 2);
			}
			lp.logout();
			
		}
		
		
	}
	
	
	
}
