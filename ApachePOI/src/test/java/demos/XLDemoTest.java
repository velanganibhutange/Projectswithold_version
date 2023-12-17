package demos;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;

public class XLDemoTest
{

	public static void main(String[] args) throws IOException
	
	{

		XLUtils.setCellData("c:\\xldemo\\testdata.xlsx", "LoginData",1,2, "Pass");
		XLUtils.fillGreenColor("c:\\\\xldemo\\\\testdata.xlsx","Logindata", 1,2, "Pass");
		XLUtils.setCellData("c:\\xldemo\\testdata.xlsx", "LoginData",2,2, "fail");
		XLUtils.fillRedColor("c:\\xldemo\\testdata.xlsx", "Logindata",2,2,"fail");

}}
