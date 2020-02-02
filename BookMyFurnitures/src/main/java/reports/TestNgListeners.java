package reports;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import util.TestUtil;

public class TestNgListeners extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext) {
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/test-output/ruchita/STMExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Ruchita");
		htmlReporter.config().setDocumentTitle("Automation Report ");
		htmlReporter.config().setReportName("WebAutomation Test Cases ");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult result) {
		logger=extent.createTest(result.getName()); // create new entry in the report
		logger.log(Status.PASS,MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
		logger.info(result.getName() + " is displayed successfully");
		try
		{
		String screenshotPath = TestUtil.takeScreenshotAtEndOfTest();
		logger.pass("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
		} catch(IOException e)
	    {
			   e.getMessage();
	    }
		
	}

	public void onTestFailure(ITestResult result) {
		logger=extent.createTest(result.getName()); 
		logger.log(Status.FAIL,MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
		logger.fail(result.getThrowable());
		try
		{
		String screenshotPath = TestUtil.takeScreenshotAtEndOfTest();
		logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
		} catch(IOException e)
	    {
	        e.getMessage();
	    }
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();

	}

}