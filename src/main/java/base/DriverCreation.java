package base;

import locators.LoginpageLocators;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DriverCreation extends LoginpageLocators{
	
	public static ChromeDriver chromeDriver;
	public static final String cdName = "webdriver.chrome.driver";
	public static final String cdPath = "chromedriver";
	
	
	@BeforeMethod
	public void setDriver(){
		
		System.setProperty(cdName, cdPath);
		chromeDriver = new ChromeDriver();
		chromeDriver.get(loginURL);
	}

	@AfterMethod
	public void afterTest(){
//	    chromeDriver.close();
	}
}
