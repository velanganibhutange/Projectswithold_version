package demos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat.Style;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils 

{
	
public static FileInputStream fi;
public static FileOutputStream fo;
public static Workbook wb;
public static Sheet ws;
public static Row row;
public static Cell cell;
public static CellStyle style;


public static String getStringData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
{
	fi = new FileInputStream(xlfile);
	wb = new XSSFWorkbook(fi);
	ws = wb.getSheet(xlsheet);
	row = ws.getRow(rownum);
	
	String data;
	try 
	{
		cell = row.getCell(colnum);
		data = cell.getStringCellValue();
	} catch (Exception e)
	{
		data = "";
		System.err.println("no data found");
	}
	
	wb.close();
	return data;
}
public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
{
	fi = new FileInputStream(xlfile);
	wb = new XSSFWorkbook(fi);
	ws = wb.getSheet(xlsheet);
	row = ws.getRow(rownum);
	cell = row.createCell(colnum);
	cell.setCellValue(data);
	
	fo = new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
	
}	
public static void fillGreenColor(String xlfile,String xlsheet,int rownum,int colnum, String string) throws IOException
{
	
	fi = new FileInputStream(xlfile);
	wb = new XSSFWorkbook(fi);
	ws = wb.getSheet(xlsheet);
	row = ws.getRow(rownum);
	cell = row.getCell(colnum);
	
	style = wb.createCellStyle();
	style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	
	cell.setCellStyle(style);
	fo = new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
}
public static void fillRedColor(String xlfile,String xlsheet,int rownum,int colnum, String string) throws IOException
{
	
	fi = new FileInputStream(xlfile);
	wb = new XSSFWorkbook(fi);
	ws = wb.getSheet(xlsheet);
	row = ws.getRow(rownum);
	cell = row.getCell(colnum);
	
	style = wb.createCellStyle();
	style.setFillForegroundColor(IndexedColors.RED.getIndex());
	style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	
	cell.setCellStyle(style);
	fo = new FileOutputStream(xlfile);
	wb.write(fo);
	wb.close();
}
public static int getRowCount(String datafile, String datasheet) {
	// TODO Auto-generated method stub
	return 0;
}
}


