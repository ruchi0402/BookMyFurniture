package testcaseswebautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.CommonMethods;

public class BaseTestWeb extends CommonMethods {
	

	@BeforeMethod
	public void setup() {
		instantiateBrowser();
		
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}

}
