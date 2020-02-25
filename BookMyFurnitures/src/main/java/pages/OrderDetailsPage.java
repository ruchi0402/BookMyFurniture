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
	private WebElement yes;

	public OrderDetailsPage() {

		PageFactory.initElements(driver, this);
	}

	public void orderDetailPage(String itemDetail) {
		WebElement element=driver.findElement(By.xpath("//h2[contains(text(),'" + itemDetail + "')]"));
		isDisplayed(element,
				"order details page is displayed");
	}

	public void clickonPlaceOrder() {
		click(placeOrder);
		click(yes);

	}

}
