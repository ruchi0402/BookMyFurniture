package base;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


public class CommonMethods extends Driver {
	
Logger log = Logger.getLogger(CommonMethods.class);	

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
			log.error(e.getMessage());
			assert false;
		}
	}

	public void sendKeys(WebElement webElement, String name) {
		try {
			webElement.sendKeys(name);
		} catch (Exception e) {
			log.error(e.getMessage());
			assert false;
		}
	}

		
	public void isDisplayed(WebElement webElement, String message ) {
		try {
			webElement.isDisplayed();
			log.info(message);
		} catch (Exception e) {
		log.error(e.getMessage());
		assert false;
		}
	}
}
