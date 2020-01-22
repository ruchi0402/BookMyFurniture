package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class OrderDetailsPage extends BasePage {

	@FindBy(xpath = "//button[contains(text(),'Place Order')]")
	private WebElement placeOrder;
	
	@FindBy(xpath="//span[contains(text(),'Yes')]")
	private WebElement Yes;
	public OrderDetailsPage() {

		PageFactory.initElements(driver, this);
	}

	public Boolean orderDetailPage(String itemdetail) {
		return driver.findElement(By.xpath("//h2[contains(text(),'" + itemdetail + "')]")).isDisplayed();
	}

	public void clickonPlaceOrder() {
		click(placeOrder);
		click(Yes);

	}

	/*
	 * try { Alert alert = driver.switchTo().alert(); String alertText =
	 * alert.getText(); System.out.println("Alert data: " + alertText);
	 * alert.accept(); } catch (NoAlertPresentException e) { e.printStackTrace(); }
	 */

//new WebDriverWait(driver, 5)
// .ignoring(NoAlertPresentException.class)
	// .until(ExpectedConditions.alertIsPresent());

}
