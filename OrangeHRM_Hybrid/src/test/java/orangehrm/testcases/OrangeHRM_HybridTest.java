package orangehrm.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import orangehrm.library.Employee;
import orangehrm.library.LoginPage;
import utils.AppUtils;
import utils.XLUtils;

public class OrangeHRM_HybridTest extends AppUtils 
{

	String tcfile = "C:\\xldemo\\OrangeHRMKeywords.xlsx";
	String tcsheet = "TestCases";
	String tssheet = "TestSteps";
	
	@Test
	public void checkOrangeHRM() throws IOException
	{
			
			int tccount = XLUtils.getRowCount(tcfile, tcsheet);
			int tscount = XLUtils.getRowCount(tcfile, tssheet);
			
			String tcid,tcexecute,tstcid,keyword;
			String stepres,tcres;
		
			String uid,pwd;
			String fname,lname;
			boolean res = false;
			
			LoginPage lp = new LoginPage();
			Employee emp = new Employee();
			
			for(int i=1;i<=tccount;i++)
			{
				
				tcid = XLUtils.getStringData(tcfile, tcsheet, i, 0);
				tcexecute = XLUtils.getStringData(tcfile, tcsheet, i,  2);
				
				if(tcexecute.equalsIgnoreCase("y"))
				{
					for(int j=1;j<=tscount;j++)
					{
						tstcid = XLUtils.getStringData(tcfile, tssheet, j, 0);
						if(tstcid.equalsIgnoreCase(tcid))
						{
							keyword = XLUtils.getStringData(tcfile, tssheet, j, 4);
							
							switch (keyword.toLowerCase()) 
							{
								case "adminlogin":
									uid = XLUtils.getStringData(tcfile, tssheet, j, 5);
									pwd = XLUtils.getStringData(tcfile, tssheet, j, 6);
									lp.login(uid, pwd);
									res = lp.isAdminModuleDisplayed();
									break;
								case "logout":
									res = lp.logout();
									break;
								case "invalidlogin":
									uid = XLUtils.getStringData(tcfile, tssheet, j, 5);
									pwd = XLUtils.getStringData(tcfile, tssheet, j, 6);
									lp.login(uid, pwd);
									res = lp.isErrMsgDisplayed();
									break;
								case "addemp":
									fname= XLUtils.getStringData(tcfile, tssheet, j, 5);
									lname = XLUtils.getStringData(tcfile, tssheet, j, 6);
									res = emp.addEmployee(fname, lname);
									break;
							}
							
							// code to update Step Result
							if(res)
							{
								stepres = "Pass";
								XLUtils.setCellData(tcfile, tssheet, j, 3, stepres);
								XLUtils.fillGreenColor(tcfile, tssheet, j, 3);
							}else
							{
								stepres = "Fail";
								XLUtils.setCellData(tcfile, tssheet, j, 3, stepres);
								XLUtils.fillRedColor(tcfile, tssheet, j, 3);
							}
							
							// code to update TestCase Result
							
								tcres = XLUtils.getStringData(tcfile, tcsheet, i, 3);
								
								if(!tcres.equalsIgnoreCase("fail"))
								{
									XLUtils.setCellData(tcfile, tcsheet, i, 3, stepres);
								}
								
								// filling TC Result Colors
								tcres = XLUtils.getStringData(tcfile, tcsheet, i, 3);
								if(tcres.equalsIgnoreCase("pass"))
								{
									XLUtils.fillGreenColor(tcfile, tcsheet, i, 3);
								}else
								{
									XLUtils.fillRedColor(tcfile, tcsheet, i, 3);
								}
							
						}
					}
					
				}else
				{
					XLUtils.setCellData(tcfile, tcsheet, i, 3, "Blocked");
					XLUtils.fillRedColor(tcfile, tcsheet, i, 3);
				}
			}
	}
		

	

}
