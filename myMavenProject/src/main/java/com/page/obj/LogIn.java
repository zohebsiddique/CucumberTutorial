package com.page.obj;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.base.lib.DataHelper;
import com.base.setup.DriverSetup;


public class LogIn extends DriverSetup{
	public static WebElement username,password;
//WebElement password;
	
	public LogIn() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		username=driver.findElement(By.xpath("//*[@id=\"UserName\"]"));
		password=	driver.findElement(By.id("Password"));
		
	}
	
	
	public static void sendKeys()
	{
		username=driver.findElement(By.xpath("//*[@id=\"UserName\"]"));
		password=	driver.findElement(By.id("Password"));
		//System.out.println("Value of STR is : "+ str);
		//switch (str.getText())
		//{
		//case "username":
		//	str=username;
		//case "password":
		//	str=password;
		//}
	
		//System.out.println("Data.get(0) : "+ DataHelper.data.get(0).get("Data"));
		//System.out.println("Data.get(1) : "+ DataHelper.data.get(1).get("Data"));
		WebElement element=driver.findElement(By.xpath("//*[@id=\"UserName\"]"));
		element.sendKeys(DataHelper.data.get(0).get("Data"));
	}

}
