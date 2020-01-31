package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class AccountPage extends BasePage {
	
	@FindBy(id = "name")
	private WebElement custname;

	@FindBy(id = "mobileNo")
	private WebElement mobileNo;

	@FindBy(xpath = "//div[@class='sign-up-main']//input[@id='emailId']")
	private WebElement email;

	@FindBy(xpath = "//div[@class='sign-up-main']//input[@id='password']")
	private WebElement password;

	@FindBy(xpath = "//button[contains(text(),'Register')]")
	private WebElement registerButton;

	@FindBy(xpath = "//div[@id='toast-container']")
	private WebElement accountSucessful;

	public AccountPage() {
		PageFactory.initElements(driver, this);
	}

	public void createAccount(String name, String mobile, String emailAddress, String Password) {
		sendKeys(custname, name);
		sendKeys(mobileNo, mobile);
		sendKeys(email, emailAddress);
		sendKeys(password, Password);
		click(registerButton);
	}

	public Boolean accountSuccessful() {
		return accountSucessful.isDisplayed();
	}
}
