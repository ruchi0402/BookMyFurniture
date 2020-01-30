package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BasePage {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	Logger log = Logger.getLogger(BasePage.class);

	public BasePage() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
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
					System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "user.dir" + "\\src\\main\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(CommonConstant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(CommonConstant.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

//method overloading
	public void click(By locator) {
		try {
			driver.findElement(locator).click();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw (e);
		}
	}

	public void click(WebElement webElement) {
		try {
			webElement.click();
		} catch (Exception e) {
			log.error(e.getStackTrace());
			assert false;
		}
	}

	public void sendKeys(WebElement webElement, String name) {
		try {
			webElement.sendKeys(name);
		} catch (Exception e) {
			log.error(e.getStackTrace());
			assert false;
		}
	}

}