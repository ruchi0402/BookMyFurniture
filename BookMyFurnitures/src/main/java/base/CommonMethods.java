package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends BaseClass {

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
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(webElement));
			} catch (Exception e) {
			log.error(e.getMessage());
			assert false;
		}
		return webElement;
		
	}
	
}
