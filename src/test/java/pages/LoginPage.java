package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class LoginPage {
	
	WebDriver driver = BaseClass.driver;
	
	ExtentTest test = BaseClass.test;
	//==========================Web Elemnents========================================//
	
		@FindBy(linkText = "Log in")
		WebElement LoginLink;
		
		@FindBy(name = "user_login")
		WebElement UserName;
		
		@FindBy(id = "password")
		WebElement Password;
		
		@FindBy(className = "rememberMe")
		WebElement Rememberme;
		
		@FindBy(name = "btn_login")
		WebElement LoginBtn;
		
		//Need to define constructor for pageFactory
		
		public LoginPage () {
			
			PageFactory.initElements(driver, this);
		}
		
		

	//===================================Functions===================================//
	
	public void LoginFuction(String UserNameVal, String PasswordVal) {
		
		LoginLink.click();
		test.log(LogStatus.PASS, "Click on Login Link", "Login link clicked successfully");
		
		UserName.sendKeys(UserNameVal);
		test.log(LogStatus.PASS, "Enter UserName", "UserName entered successfully");
		
		Password.sendKeys(PasswordVal);
		test.log(LogStatus.PASS, "Enter Password", "Password entered successfully");
		
		Rememberme.click();
		test.log(LogStatus.PASS, "Click on Rememberme", "Clicked successfully");
		
		LoginBtn.click();
		test.log(LogStatus.PASS, "Click on Login", "Login clicked successfully");
		
	}


}
