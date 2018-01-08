package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginpageLocators{

	public static final String loginURL = "https://coinsecure.in/home";
	public static final String apiURL = "https://api.coinsecure.in/v1";
	
	
	 //  Locators for the Login page with a static token that needs to be changed every time used intends to login.

	public static final By loginButton = By.xpath("//a[@class='logButton']");
	public static final By emailField = By.xpath("//input[@id='email']");
	public static final By tokenField = By.xpath("//input[@id='tokenLogin']");
	public static final By pinField = By.xpath("//input[@id='pin']");
	public static final String passwordValue = "P@ssw0rd";
	public static final By passwordField = By.xpath("//input[@id='password']");
	public static final By submitBtn = By.xpath("//button[@id='btnSubmitLogin']");
	public static final By TwoFa = By.xpath("//input[@id='pin']");
	public static final By msg = By.xpath("//p[contains(.,'Successfully logged in!')]");
	public static final By emailTokenMsg = By.xpath("//p[contains(.,'An Email has been sent with a temporary link. Please click the link in your email or enter the to continue.')]");
	public static final String emailMsg = "An Email has been sent with a temporary link. Please click the link in your email or enter the to continue.";
	
	//Locators to locate fields in Signup Page

	public static final By signBtn = By.xpath("//span[@onclick='getSignup()']");
	public static final By signUpEmailField = By.xpath("//input[@id='email']");
	public static final By signUpPasswordField1 = By.xpath("//input[@id='password']");
	public static final By signupPasswordField2 = By.xpath("//input[@id='repeatPassword']");
	public static final By referralId = By.xpath("//input[@id='refID']");
	public static final By acceptTerms = By.xpath("//label[@for='acceptTerms']");
	public static final By signUpBtn = By.xpath("//button[@id='btnSubmitSignup']");

	
	// Locators to locate field if Invalid email entered
	
	public static final By invalidEmailMsg = By.xpath("//p[contains(.,'Invalid Username. Please try with your correct login ID.')]");
	public static final By invalidPwdMsg = By.xpath("//span[contains(.,'Secure Login Failed')]");
	public static final By errorMsg = By.xpath("//p[contains(.,'Invalid email format!')]");

	// Locators for Forgot Password

    public static final By forgotPwdBtn = By.xpath("//a[contains(.,'Forgot Password?')]");
    public static final By forgotPwdEmail = By.xpath("//input[@ng-model='emailForgot']");
    public static final By sendCodeToEmail = By.xpath("//button[contains(.,'Send Code to Email!')]");
    public static final By enterCodeFromEmailField = By.xpath("//input[@required='required']");
    public static final By verifyLinkBtn = By.xpath("//button[contains(.,'Verify Link')]");
    public static By passwordBox = By.xpath("//input[@id='passworBox']");
    public static By repeatPasswordBox = By.xpath("//input[@id='repeatPasswordBox']");
    public static final By resetPasswordBtn = By.xpath("//button[contains(.,'Reset Password')]");

    //Locators for Invalid Data of Forgot Password.

    public static final By forgotPwdErrorMsg = By.xpath("//p[contains(.,'Please check your form and submit again!')]");
    public static final By pwdResetError = By.xpath("//span[contains(.,'Passwords Reset Error!')]");
    public static final By invalidTokenError = By.xpath("//p[contains(.,'Invalid token provided!')]");
}
