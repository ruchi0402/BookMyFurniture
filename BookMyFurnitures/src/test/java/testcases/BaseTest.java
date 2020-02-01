package testcases;

import java.io.IOException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import base.Driver;
import config.ReadProperties;
import util.TestUtil;

public class BaseTest extends Driver {
		
	@BeforeMethod
	public void setup() {
	ReadProperties.readFromPropertyFile();
	instatiateBrowser();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				TestUtil.takeScreenshotAtEndOfTest();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (ITestResult.SUCCESS == result.getStatus()) {
			try {
				TestUtil.takeScreenshotAtEndOfTest();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		driver.quit();
	}

}
