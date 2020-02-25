package reports;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class TestNgListenersApi extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext) {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
				+ "/test-output/RestAPIAutomation/AutomationReport" + System.currentTimeMillis() + ".html");
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
		
	}

	public void onTestFailure(ITestResult result) {
		logger = extent.createTest(result.getName());
		logger.log(Status.FAIL, result.getName() + " is failed");
		logger.fail(result.getThrowable());

	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}