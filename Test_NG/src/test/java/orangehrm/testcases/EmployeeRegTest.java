package orangehrm.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import orangehrm.library.AdminUtils;
import orangehrm.library.Employee;
import orangehrm.library.LoginPage;


public class EmployeeRegTest extends AdminUtils

{
	@Parameters({"fname","lname"})
	@Test
	public void checkEmpReg(String fname, String lname)
{
	

Employee emp = new Employee();
boolean res = emp.addEmployee(fname, lname);
AssertJUnit.assertTrue(res);

		

}
	}
