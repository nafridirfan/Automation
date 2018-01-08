package logincases;

import base.*;
import locators.LoginpageLocators;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.*;

import static com.jayway.restassured.RestAssured.*;

public class LoginToken extends DriverCreation {

        /*
		 *  The below conditions are to check Login for different conditions. 
		 *  1. After entering Email ID, the authentication is Token based. 
		 *  2. The authentication is Google Authy based.
		 *  NOTE : To test the first condition use the Tutorial (at) coinsecure ID.
		 */

            @Test
            public void loginToken(String username, String password) throws Exception{

                BufferedReader reader = new BufferedReader(new FileReader("Token-File.txt"));
                String token = "";
                GetToken gt = new GetToken();
                chromeDriver.findElement(LoginpageLocators.loginButton).click();
                chromeDriver.findElement(LoginpageLocators.emailField).sendKeys(username);
                chromeDriver.findElement(LoginpageLocators.submitBtn).click();
                System.out.println();
                Thread.sleep(4000);
                try{
                    if(chromeDriver.findElement(LoginpageLocators.errorMsg).isDisplayed()){
                        System.out.println("Check the error message and please enter valid/correct email again. ");
                        Thread.sleep(5000);
                    } else System.out.println("Please wait while the Token is fetched.. ");
                }catch(Exception e){
                    Thread.sleep(7000);
                    gt.getToken(); //Fetches and writes the token value in a file
                    token = reader.readLine(); //read file to read token
                    chromeDriver.findElement(LoginpageLocators.tokenField).sendKeys(token);
                    chromeDriver.findElement(LoginpageLocators.submitBtn).click();
                    chromeDriver.findElement(LoginpageLocators.passwordField).sendKeys(password);
                    chromeDriver.findElement(LoginpageLocators.submitBtn).click();
                    Thread.sleep(3000);
//                    Assert.assertTrue(chromeDriver.getCurrentUrl().equals("https://coinsecure.in/exchange"));
                }

            }
	}


