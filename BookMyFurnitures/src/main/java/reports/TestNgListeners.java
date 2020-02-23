package reports;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import base.BaseClass;
import util.TestUtil;

public class TestNgListeners extends BaseClass implements ITestListener {

	public void onStart(ITestContext testContext) {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
				+ "/test-output/WebAutomation/AutomationReport" + System.currentTimeMillis() + ".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Ruchita");
		htmlReporter.config().setDocumentTitle("Automation Report ");
		htmlReporter.config().setReportName("WebAutomation Test Cases ");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult result) {
		logger = extent.createTest(result.getName()); // create new entry in the report
		logger.log(Status.PASS, result.getName() + " is passed");
		try {
			String screenshotPath = TestUtil.takeScreenshotAtEndOfTest();
			logger.addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public void onTestFailure(ITestResult result) {
		
		logger = extent.createTest(result.getName());
		logger.log(Status.FAIL, result.getName() + " is failed");
		logger.fail(result.getThrowable());
		try {
			String screenshotPath = TestUtil.takeScreenshotAtEndOfTest();
			logger.addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}
