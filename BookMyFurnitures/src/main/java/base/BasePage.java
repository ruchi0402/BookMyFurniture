package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import util.TestUtil;

public class BasePage {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	Logger log = Logger.getLogger(BasePage.class);

	public BasePage() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Admin\\Desktop\\SDET\\BookMyFurnitures\\src\\main\\java\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void instatiateBrowser() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Admin\\Desktop\\SDET\\BookMyFurnitures\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "user.dir" + "\\src\\main\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

	public void click(By locator) {
		try {
			// WebElement locator;
			driver.findElement(locator).click();
		} catch (Exception e) {
			log.info(e.getStackTrace());
			assert false;
		}
	}

	public void click(WebElement webElement) {
		try {
			// WebElement webElement1;
			driver.findElement((By) webElement).click();
		} catch (Exception e) {
			log.info(e.getStackTrace());
			assert false;
		}
	}
}