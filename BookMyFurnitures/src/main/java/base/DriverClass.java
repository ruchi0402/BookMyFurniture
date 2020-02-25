package base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import util.ReadProperties;

// Base class is for driver and browser set up. It extends Read Properties class from which it is getting browser and url data.
public class DriverClass {

	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	ReadProperties readconfig = new ReadProperties();
	public String browserName = readconfig.getBrowser();
	public String url = readconfig.getApplicationURL();

	public void instantiateBrowser() {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(CommonConstant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(CommonConstant.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(url);

	}

}
