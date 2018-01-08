package com.org.learningCucumber;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.lib.DataEngine;
import com.base.lib.DataHelper;
import com.base.setup.DriverSetup;
import com.page.obj.LogIn;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinition extends DriverSetup{
	

	public WebDriver driver;
	public List<HashMap<String,String>> datamap;
	public StepDefinition() throws IOException
	{
	//	System.out.println("printing fInput and fExpected: "+ TestRunner.fInput+" "+TestRunner.fInput);
		DataHelper.setData("C:\\Zoheb\\workspace\\Test_Data.xlsx","Sheet1");
		
	}
	    
	
@Test	
@Given("^I open firefox$")
public void openBrowser()
{
	//	System.out.println("fInput and fExpected: "+fInput+" and "+fExpected);
	driver=DriverSetup.setUp("Chrome");

}

@Given("^I open application$")
public void open_application()
{
	//datamap=DataHelper.getData();
	datamap=DataHelper.getData();
	driver.get(datamap.get(0).get("Data"));

	}

@When("^I enter valid username$")
public void enter_username() throws IOException
{
	//WebElement username =driver.findElement(By.xpath("//*[@id=\"UserName\"]"));
	DataHelper.getData();
	DataEngine.PerformAction(datamap);
	//DataHelper.Action(driver);
	//datamap=DataHelper.getData();
	//username.sendKeys(datamap.get(0).get("Data"));
	//username.sendKeys(datamap.get(1).get("Data"));
	//driver.get(datamap.get(0).get("Username"));
	

}

@When("^valid password$")
public void enter_password()
{
//WebElement password=	driver.findElement(By.id("Password"));
//datamap=DataHelper.getData();
//password.sendKeys(datamap.get(0).get("Data"));
	DataHelper.getData();
	try {
		DataEngine.PerformAction(datamap);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//DataHelper.Action(driver);
	}


@When("^Click Sign In button$") 
public void click_signin()
{
	DataHelper.getData();
	try {
		DataEngine.PerformAction(datamap);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

//	WebElement signin=driver.findElement(By.id("btnSignIn"));
//	signin.click();

	}

@Then("^User dashboard should be displayed$")
public void display_dashboard()
{
	
	DataHelper.getData();
	try {
		DataEngine.PerformAction(datamap);
		System.out.println("Executed entire test");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[4]/div[1]/h5")).isDisplayed();
	driver.close();
	}

}
