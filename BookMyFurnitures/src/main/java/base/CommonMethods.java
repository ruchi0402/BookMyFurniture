package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.restassured.response.Response;

public class CommonMethods extends DriverClass {

	Logger log = Logger.getLogger(CommonMethods.class);

//click method is overloaded with parameters locator and Webelement. Basically this method checks the 
// presence of the locator/webelement using try/catch block.
	public void click(By locator) {
		try {
			webDriverWait(driver.findElement(locator)).click();
		} catch (Exception e) {
			log.error(e.getMessage());
			assert false;
		}
	}

	public void click(WebElement webElement) {
		try {
			webDriverWait(webElement).click();
		} catch (Exception e) {
			log.error(e.getMessage());
			assert false;
		}

	}

//sendKeys method checks the presence the webelement using try/catch block and performs operation if available.
	public void sendKeys(WebElement webElement, String name) {
		try {
			webDriverWait(webElement).sendKeys(name);
		} catch (Exception e) {
			log.error(e.getMessage());
			assert false;
		}
	}
//isDisplayed validates the operation is successful, test case result depends on this.

	public void isDisplayed(WebElement webElement, String message) {
		try {
			webDriverWait(webElement).isDisplayed();
			log.info(message);

		} catch (Exception e) {
			log.error(e.getMessage());
			assert false;
		}
	}

	public WebElement webDriverWait(WebElement webElement) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(webElement));
		} catch (Exception e) {
			log.error(e.getMessage());
			assert false;
		}
		return webElement;

	}

	public void validateResponse(Response response, int expStatusCode) {
		int actStatusCode = response.getStatusCode();
		try {
			Assert.assertEquals(actStatusCode, expStatusCode);
			log.info("Status matched");
		} catch (Exception e) {
			log.info(e.getMessage());
			assert false;
		}
	}

		


	public void switchToTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
		// Switch focus to new tab
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.switchTo().window(tabs.get(0));
		driver.quit();
	}
}
