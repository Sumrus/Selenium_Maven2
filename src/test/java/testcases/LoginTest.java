package testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	
	
	@Test
	public void LoginFaliureTest() {
		
		
		
		// Need to create obj for LoginPage Class 
		
		LoginPage login = new LoginPage();
				
		login.LoginFuction("abc@gmail.com", "@854Rusia");
				
		//To check/compare error msg 
				
		WebElement ErrorMsg = driver.findElement(By.id("msg_box"));
				
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
				
				
		AssertJUnit.assertEquals(ActualMsg, ExpMsg);
		
		
		
		
	}
	
	@Test
	public void LoginSuccessTest() {
		
		LoginPage login = new LoginPage();
		
		login.LoginFuction("sumit.rusia3@gmail.com", "@854Sumit#");
				
	
	}
	
	
	@Test
	@Parameters({"Para1","Para2"})
	public void ParameterizedTest(String UserNameVal, String PasswordVal) {
		
		LoginPage login = new LoginPage();
		login.LoginFuction(UserNameVal, PasswordVal);
		
	}
	
	
	// Providing Data through excel sheet
	
	@Test
	public void ExternalDataTest() {
		
		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
		
		LoginPage login = new LoginPage();
		login.LoginFuction(UserNameVal, PasswordVal);
		
	}
	
	

}
