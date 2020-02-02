package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.CommonMethods;

public class SelectPaymentPage extends CommonMethods {

	@FindBy(xpath = "//div[@class='ui-g']//div[1]//p-radiobutton[1]//div[1]//div[2]//span[1]")
	private WebElement creditdebitatmradiobutton;

	@FindBy(xpath = "//div[3]//p-radiobutton[1]//div[1]//div[2]")
	private WebElement cash;

	@FindBy(xpath = "//div//div[2]//p-radiobutton[1]//div[1]//div[2]//span[1]")
	private WebElement netbanking;

	@FindBy(xpath = "//button[@class='btn btn-success ng-star-inserted']")
	private WebElement placeorder;

	@FindBy(xpath = "//h2[contains(text(),'Your order is successfully placed')]")
	private WebElement orderSuccessful;

	@FindBy(xpath = "//h3[contains(text(),'Select Payment Option')]")
	private WebElement selectPaymentText;

	public SelectPaymentPage() {
		PageFactory.initElements(driver, this);
	}

	public Boolean verifySelectPaymentPage() {
		return selectPaymentText.isDisplayed();
	}

	public void selectPaymenttype(String payment) {
		if (payment.equals("card")) {
			click(creditdebitatmradiobutton);
		} else if (payment.equals("cash")) {
			click(cash);
		} else if (payment.equals("cash")) {
			click(netbanking);
		}
	}

	public void clickonPlaceOrder() {
		click(placeorder);
	}

	public void OrderSuccessful() {

		isDisplayed(orderSuccessful, "Order is placed successfully");
	}
}
