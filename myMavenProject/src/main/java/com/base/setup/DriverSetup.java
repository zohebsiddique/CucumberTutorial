package com.base.setup;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class DriverSetup{
	public DriverSetup() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public static WebDriver driver;
	@SuppressWarnings("deprecation")
	public static WebDriver setUp(String BROWSER) {
		try {
			if (BROWSER.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:/Zoheb/Drivers/chromedriver.exe");
				driver= new ChromeDriver();
				driver.manage().window().maximize();
		//		driver.get("www.gmail.com");
		}
		else if (BROWSER.equalsIgnoreCase("Firefox")) {
				FirefoxProfile firefoxProfile = new FirefoxProfile();
				firefoxProfile.setAssumeUntrustedCertificateIssuer(false);
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			//	driver.get("www.gmail.com");
				
			}else if (BROWSER.contentEquals("InternetExplorer")) {

				DesiredCapabilities capabilities = DesiredCapabilities
						.internetExplorer();
				capabilities
						.setCapability(
								InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
								true);
				capabilities.setCapability("ignoreProtectedModeSettings", true);
				File file = new File("D:\\Zoheb\\Selenium\\Files\\Driver\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				driver = new InternetExplorerDriver(capabilities);
				driver.manage().window().maximize();
				//driver.get("www.gmail.com");
			} 
		} catch (Exception e) {
			e.printStackTrace();

		}
		return driver;

}
}
