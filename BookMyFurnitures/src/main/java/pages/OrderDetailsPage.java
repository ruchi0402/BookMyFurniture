package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.CommonMethods;

public class OrderDetailsPage extends CommonMethods {

	@FindBy(xpath = "//button[contains(text(),'Place Order')]")
	private WebElement placeOrder;

	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	private WebElement Yes;

	public OrderDetailsPage() {

		PageFactory.initElements(driver, this);
	}

	public void orderDetailPage(String itemdetail) {
		isDisplayed(driver.findElement(By.xpath("//h2[contains(text(),'" + itemdetail + "')]")),
				"order details page is displayed");

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
