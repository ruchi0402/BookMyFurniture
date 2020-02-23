package testcases_WebAutomation;

import java.lang.reflect.Method;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.CommonMethods;

public class BaseTest_Web extends CommonMethods {
	

	@BeforeMethod
	public void setup() {
		instatiateBrowser();
		
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

}
