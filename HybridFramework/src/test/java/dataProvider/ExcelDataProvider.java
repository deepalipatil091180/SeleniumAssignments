package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{

	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		
	try 
	{
		wb=new XSSFWorkbook(new FileInputStream(new File("./TestData/AppData.xlsx")));
	}  catch (Exception e) 
	{
	System.out.println("Failed to load or read excel file "+e.getMessage());	
	}
		
	}
	
	public String getStringData(String sheetName,int row,int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(int sheetIndex,int row,int column)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getDoubleData(String sheetName,int row,int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	
	public int getIntData(String sheetName,int row,int column)
	{
		return (int)wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	
}
