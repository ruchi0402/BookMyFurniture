package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommonMethods extends BaseClass {

	Logger log = Logger.getLogger(CommonMethods.class);

//click method is overloaded with parameters locator and Webelement. Basically this method checks the 
// presence of the locator/webelement using try/catch block.
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
			log.error(e.getMessage());
			assert false;
		}
	}

//sendKeys method checks the presence the webelement using try/catch block and performs operation if available.
	public void sendKeys(WebElement webElement, String name) {
		try {
			webElement.sendKeys(name);
		} catch (Exception e) {
			log.error(e.getMessage());
			assert false;
		}
	}
//isDisplayed validates the operation is successful, test case result depends on this.

	public void isDisplayed(WebElement webElement, String message) {
		try {
			webElement.isDisplayed();
			log.info(message);
		} catch (Exception e) {
			log.error(e.getMessage());
			assert false;
		}
	}
}
