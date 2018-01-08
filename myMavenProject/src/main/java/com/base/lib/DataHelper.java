package com.base.lib;
//import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.page.obj.LogIn;

import com.base.setup.DriverSetup;
import com.gargoylesoftware.htmlunit.javascript.host.Iterator;
import com.page.obj.LogIn;
public class DataHelper extends  DriverSetup{
	public static String keyword;
	public static String LocatorType;
	public static String LocatorValue;
	public static String value;
	
	public DataHelper() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		//LogIn lo=new LogIn();
	}

	public static HashMap<String,String> storeValues = new HashMap<String, String>();
	public static List<HashMap<String,String>> mydata = new ArrayList<>();
	public static List<HashMap<String,String>> data=new ArrayList<>();
	//@SuppressWarnings("deprecation")
	//public static List<HashMap<String,String>> setData(String filepath,String sheetName)
	//@SuppressWarnings({ "null", "deprecation" })
	@SuppressWarnings("deprecation")
	public static void setData(String filepath,String sheetName)
	{
///driver=this.driver;
try
{
		FileInputStream fs = new FileInputStream(filepath);
		@SuppressWarnings("resource")
		//XSSFWorkbook workbook = new XSSFWorkbook(fs);
		//XSSFSheet sheet = workbook.getSheet(sheetName);
		Workbook workbook = new XSSFWorkbook(fs);
		Sheet sheet = workbook.getSheet(sheetName);
		
		//StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		 Row HeaderRow = sheet.getRow(0);
		 for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
		 {
			 Row currentRow = sheet.getRow(i);
			 HashMap<String,String> currentHash = new HashMap<String,String>();
			 for(int j=0;j<currentRow.getPhysicalNumberOfCells();j++)
			 {
				 Cell currentCell = currentRow.getCell(j);
				 
				 if (currentCell == null || currentCell.getCellType() == Cell.CELL_TYPE_BLANK)
				 {
					// continue;
				 }
				 else
				 {
				 currentCell.getCellTypeEnum();
				 
				 if(currentCell.getCellTypeEnum() == CellType.STRING)
				 {
					 
					 //System.out.print(currentCell.getStringCellValue() + "\t");
					currentHash.put(HeaderRow.getCell(j).getStringCellValue(), currentCell.getStringCellValue());
					 
				 }
				 }
			 }
mydata.add(currentHash);
		 }
		 fs.close();
		 }
	catch (Exception e)
	{
		e.printStackTrace();
	}
	//return mydata;
//getData(mydata);
}
	
//public static List<HashMap<String,String>> getData(List<HashMap<String,String>> currentData)
	public static List<HashMap<String,String>> getData()
{
		
	//System.out.println("Mydata : " + mydata);
	data.clear();
	//String methodName=Thread.currentThread().getStackTrace()[2].getMethodName();
	//String callingFunction=mydata.get(0).get("CallingFunction");
	//System.out.println("Calling method name: " + callingFunction);
	//System.out.println("Methodname is: " + methodName);
	for (int i=0;i<mydata.size();i++)
	{
		//System.out.println("Size of mydata: "+mydata.size());
		HashMap<String,String> currentHash = new HashMap<String,String>();
		String methodName=Thread.currentThread().getStackTrace()[2].getMethodName();
		String callingFunction=mydata.get(i).get("CallingFunction");
		
		//System.out.println(Thread.currentThread().getStackTrace()[2].getMethodName());
		
		if (methodName.equals(callingFunction))
		{	
		//	System.out.println("MATCHED!!!!!");
			currentHash.put("Data", mydata.get(i).get("Data"));
			currentHash.put("Action", mydata.get(i).get("Action"));
			currentHash.put("LocatorType", mydata.get(i).get("LocatorType"));
			currentHash.put("LocatorValue", mydata.get(i).get("LocatorValue"));
			data.add(currentHash);
		}
	//Action(i);	
	}
	//System.out.println("Printing data: "+ data);
	//String LocatorType1;
	//LocatorType1=data.get(0).get("LocatorType");
//	if (LocatorType1!=" ")
//	{
//	PerformAction();
//	}
	return data;
}

	
public static void PerformAction()
{
	keyword=data.get(0).get("Action");
	LocatorType=data.get(0).get("LocatorType");
	LocatorValue=data.get(0).get("LocatorValue");
	value=data.get(0).get("Data");
	System.out.println("keyword: " + keyword);
	System.out.println("LocatorType: "+LocatorType);
	System.out.println("LocatorValue: "+ LocatorValue);
	System.out.println("value : "+ value);
	switch(keyword)
	{
	case "Click":
		driver.findElement(Action(LocatorType,LocatorValue)).click();
		break;
		//return By.className(LocatorValue);
	case "SendKeys":
		driver.findElement(Action(LocatorType,LocatorValue)).sendKeys(value);
	
	}
}

	
public static By Action(String LocatorType, String LocatorValue)
{
	System.out.println("In action method");
//	action=data.get(0).get("Action");
//switch(action)
//{
//case "OPEN":
//	driver.get(data.get(0).get("Data"));
//}
	
	switch(LocatorType)
	{
	case "ClassName":
		return By.className(LocatorValue);
	case "cssSelector":
		return By.cssSelector(LocatorValue);
	case "Id":
		return By.id(LocatorValue);
	case "PartialLinkText":
		return By.partialLinkText(LocatorValue);
	case "Name":
		return By.name(LocatorValue);
	case "XPath":
		return By.xpath(LocatorValue);
	default:
		return By.xpath(LocatorValue);
	}

}


public static void Action(WebDriver driver)
{
	//driver=DataHelper.driver;
	
	System.out.println("Printing Data from Action method: "+data);
	keyword=data.get(0).get("Action");
//	System.out.println("Value of STR in Action method is : "+str);
switch(keyword)
{
case "OPEN":
	driver.get(data.get(0).get("Data"));
	break;
case "Sendkeys":
	LogIn.sendKeys();
	break;
	//webelement.sendKeys(data.get(0).get("Data"));
case "Click":
break;
		
}
	
//	return data;
	
}



}
	
