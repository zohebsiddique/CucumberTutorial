package com.base.lib;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.base.setup.DriverSetup;
import com.page.obj.LogIn;

import junit.framework.Assert;


public class DataEngine extends DriverSetup{
	public static String value;
	public static String keyword;
	public static String LocatorType;
	public static String LocatorValue;
	public static List<HashMap<String,String>> data;
	
public DataEngine(List<HashMap<String,String>> data) throws IOException {
		super();
		data=DataEngine.data;
		
		// TODO Auto-generated constructor stub
	}


@SuppressWarnings("deprecation")
public static void PerformAction(List<HashMap<String,String>> data) throws IOException
{
	//String keyword;
	//String LocatorType;
	//String LocatorValue;
	//String value;

	keyword=data.get(0).get("Action");
	LocatorType=data.get(0).get("LocatorType");
	LocatorValue=data.get(0).get("LocatorValue");
	value=data.get(0).get("Data");
	//System.out.println("keyword: " + keyword);
	//System.out.println("LocatorType: "+LocatorType);
	//System.out.println("LocatorValue: "+ LocatorValue);
	//System.out.println("value : "+ value);
	switch(keyword)
	{
	case "Click":
		driver.findElement(Action(LocatorType,LocatorValue)).click();
		break;
		//return By.className(LocatorValue);
	case "SendKeys":
		driver.findElement(Action(LocatorType,LocatorValue)).sendKeys(value);
		break;
	case "AssertText":
		assertEqualTest(value.toString(),driver.findElement(Action(LocatorType,LocatorValue)).getText().toString());
		//Assert.assertEquals(value, driver.findElement(Action(LocatorType,LocatorValue)).getText());
		break;
	}
}

	
public static By Action(String LocatorType, String LocatorValue)
{
	//System.out.println("In action method");
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
	
//	System.out.println("Printing Data from Action method: "+data);
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

@SuppressWarnings("deprecation")
public static void assertEqualTest(String expected,String actual) throws IOException
{
	System.out.println("Printing expected: "+ expected);
	System.out.println("Printing Actual:   "+actual);
	try
	{
	Assert.assertTrue(expected.equals(actual));
	}
	//if (expected==actual)
	//{
	//Assert.assertEquals("Text Matched", expected, actual);
	//}
	catch(Exception e)
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("D:\\testScreenShot.jpg"));
		e.printStackTrace();
		//Assert.fail("Text didn't match");

	}
}

}
