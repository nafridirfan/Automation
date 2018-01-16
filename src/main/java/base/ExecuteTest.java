package base;

import logincases.ForgotPassword;
import logincases.LoginAuthy;
import logincases.LoginToken;
import logincases.SignUp;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class ExecuteTest {

    public static void main(String[] args) throws Exception{

        DriverCreation dc = new DriverCreation();
        dc.setDriver();
        LoginToken loginToken = new LoginToken();
        loginToken.loginToken("testing12@coinsecure.in", "password");
//        ForgotPassword forgotPassword = new ForgotPassword();
//        forgotPassword.forgotPassword("leon@coinsecure.co","password");
//        SignUp signUp = new SignUp();
//        signUp.signUp("penniy@coinsecure.co","password");
//        LoginAuthy loginAuthy = new LoginAuthy();
//        loginAuthy.loginTfa("QTM56JN4TIQMS2K2", "testingcs00@gmail.com", "CoinSecure");
    }
}
