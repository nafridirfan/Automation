package logincases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;

import com.j256.twofactorauth.TimeBasedOneTimePasswordUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import base.DriverCreation;
import locators.LoginpageLocators;
import org.testng.annotations.*;

public class LoginAuthy extends DriverCreation{
	
	public static Actions actions;


	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	@Test
	public void loginTfa(String key, String username, String password) throws GeneralSecurityException, NullPointerException{

//	    base32Secret = key;
		chromeDriver.get(loginURL);
		chromeDriver.findElement(LoginpageLocators.loginButton).click();
		try{
			actions = new Actions(chromeDriver);
			System.out.println("Enter the registered email");
			System.out.println(chromeDriver.getTitle());
			chromeDriver.findElement(LoginpageLocators.emailField).sendKeys(username);
			chromeDriver.findElement(LoginpageLocators.submitBtn).click();
			Thread.sleep(3000);
            if(chromeDriver.getTitle().equalsIgnoreCase("Coinsecure | 2 Factor Authentication")){
                System.out.println("Please enter your password. (The password you type will be visible) ");
                chromeDriver.findElement(LoginpageLocators.passwordField).sendKeys(password);
                actions.sendKeys(Keys.TAB).perform();
                actions.sendKeys(Keys.TAB).perform();
                Thread.sleep(8000);
                String token = TimeBasedOneTimePasswordUtil.generateCurrentNumberString(key);
                System.out.println(token);
                chromeDriver.findElement(LoginpageLocators.pinField).sendKeys(token);
                Thread.sleep(3000);
                actions.sendKeys(Keys.TAB).perform();
                actions.sendKeys(Keys.TAB).perform();
                actions.sendKeys(Keys.TAB).perform();
                actions.sendKeys(Keys.ENTER).perform();
            } else System.out.println("Google Authy has not been Enabled for this User.  ");
            Thread.sleep(5000);
			Assert.assertTrue(chromeDriver.getCurrentUrl().equals("https://coinsecure.in/exchange"));
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
