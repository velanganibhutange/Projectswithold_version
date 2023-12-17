package orangehrm.testcases;

import java.io.IOException;

import utils.XLUtils;

public class Test1 {

	public static void main(String[] args) throws IOException 
	{
		String tcfile = "C:\\xldemo\\OrangeHRMKeywords.xlsx";
		String tcsheet = "TestCases";
		String tssheet = "TestSteps";
		
		String x = XLUtils.getStringData(tcfile, tssheet, 5, 6);
		System.out.println(x);

	}

}
