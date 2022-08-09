package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	
	
	public static WebDriver driver;
	
	
	// Creating the object
	
	XSSFWorkbook wbook;
	XSSFSheet sheet;
	
	//Genrating Report 
	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeTest
	public void DataSetup() throws IOException {
		
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet("Sheet1");
		
		report = new ExtentReports("ExtentReport.html");
		
	}
	
	@AfterTest
	public void DataTearDown() throws IOException {
		
		wbook.close();
		report.flush();
		report.close();
	}
	
	@BeforeMethod
	public void SetUp(Method method) {
		
		test = report.startTest(method.getName());
		
		//first setup is to define the driver
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		
		
		//creating the obj
		//webdriver is Interface therefore creating the obj of ChromeDriver which is implimenting the webdriver
		
		 driver = new ChromeDriver();
		 
		// driver = new FirefoxDriver();
		
		driver.get("https://www.simplilearn.com/");
		
		//Maximising the Window
		
		driver.manage().window().maximize();
		
		//Implicit Wait
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
	}
	
	
	@AfterMethod
	public void TearDown() {
		
		report.endTest(test);
		driver.close();
		
	}

}
