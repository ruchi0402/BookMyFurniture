package testcases_RestAssured;

import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import util.TestUtil;

public class BaseTest_Api {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
		
	@DataProvider
	public Object[][] getProductData() throws Exception {

		Object data[][] = TestUtil.getTestData("ProductPostData");
		return data;
	}
}