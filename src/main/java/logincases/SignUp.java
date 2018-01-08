package logincases;

import base.DriverCreation;
import locators.LoginpageLocators;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import javax.mail.MessagingException;

public class SignUp extends DriverCreation {

    @Test
    public void signUp(String email, String password) throws IOException, InterruptedException, MessagingException, GeneralSecurityException{

        GetToken gt = new GetToken();
        BufferedReader reader = new BufferedReader(new FileReader("Token-File.txt"));
        chromeDriver.findElement(LoginpageLocators.loginButton).click();
        chromeDriver.findElement(LoginpageLocators.signBtn).click();
        Thread.sleep(3000);
        System.out.println("PLEASE FILL IN THE FIELDS TO SIGN-UP !!");
        try{
            chromeDriver.findElement(LoginpageLocators.signUpEmailField).sendKeys(email);
            chromeDriver.findElement(LoginpageLocators.signUpPasswordField1).sendKeys(password);
            chromeDriver.findElement(LoginpageLocators.signupPasswordField2).sendKeys(password);
            chromeDriver.findElement(LoginpageLocators.referralId).sendKeys("123");
            WebElement radioBtn = chromeDriver.findElement(LoginpageLocators.acceptTerms);
            JavascriptExecutor executor = (JavascriptExecutor)chromeDriver;
            executor.executeScript("arguments[0].click();",radioBtn);
            chromeDriver.findElement(LoginpageLocators.signUpBtn).click();
        }catch(Exception e){
            e.printStackTrace();
        }
        Thread.sleep(5500);
        gt.getToken();
        String tokenUrl = "https://coinsecure.in/accounts/verify/"+reader.readLine()+"?email="+email;
        chromeDriver.get(tokenUrl);
        Thread.sleep(5000);
        chromeDriver.findElement(LoginpageLocators.signUpPasswordField1).sendKeys(password);
        chromeDriver.findElement(LoginpageLocators.submitBtn).click();
    }
}
