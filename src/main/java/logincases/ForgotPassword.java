package logincases;

import base.*;
import locators.LoginpageLocators;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;

import org.testng.Assert;
import org.testng.annotations.*;

import javax.mail.MessagingException;


public class ForgotPassword extends DriverCreation{

    /*
    Test case to verify the Forgot Password functionality. Enters an Email ID, reads the Token from Email,
    validates the token and then let's the user type a New Password
     */

    @Test
    public void forgotPassword(String email, String password) throws IOException, MessagingException, GeneralSecurityException, InterruptedException {

        BufferedReader readInput = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader("Token-File.txt"));
        GetToken gt = new GetToken();

        chromeDriver.findElement(LoginpageLocators.loginButton).click();
        chromeDriver.findElement(LoginpageLocators.forgotPwdBtn).click();

        System.out.println("Enter the Registered/Valid email");
//        String email = readInput.readLine();
        chromeDriver.findElement(LoginpageLocators.forgotPwdEmail).sendKeys(email);
        chromeDriver.findElement(LoginpageLocators.sendCodeToEmail).click();
        Thread.sleep(5000);
        System.out.println("***************");
        try{
            if(chromeDriver.findElement(LoginpageLocators.forgotPwdErrorMsg).isDisplayed()){
                System.out.println("PLEASE CHECK YOUR FORM AND SUBMIT AGAIN !! ");
                Thread.sleep(5000);
            }
        }catch(Exception e){
            System.out.println("INSIDE CATCH");
            gt.getToken();
//            String token = reader.readLine();
//            chromeDriver.findElement(LoginpageLocators.enterCodeFromEmailField).sendKeys(token + "?email=" + email);
//            chromeDriver.findElement(LoginpageLocators.verifyLinkBtn).click();
            String tokenUrl = "https://coinsecure.in/accounts/verify/"+reader.readLine()+"?email="+email;
            chromeDriver.get(tokenUrl);
            System.out.println("Please enter the New Password.. ");
            Thread.sleep(5000);
            System.out.println(chromeDriver.findElement(LoginpageLocators.passwordBox).isDisplayed());
            chromeDriver.findElement(LoginpageLocators.passwordBox).sendKeys(password);
            System.out.println("Please enter the same password as above");
            chromeDriver.findElement(LoginpageLocators.repeatPasswordBox).sendKeys(password);
            chromeDriver.findElement(LoginpageLocators.resetPasswordBtn).click();
            Thread.sleep(5000);
//            if(chromeDriver.findElement(LoginpageLocators.pwdResetError).isDisplayed()){
//                System.out.println("PLEASE TYPE IN THE SAME PASSWORD !!");
//            }
        }
        Assert.assertTrue(chromeDriver.getCurrentUrl().equalsIgnoreCase("https://coinsecure.in/doLogin"));
    }
}
