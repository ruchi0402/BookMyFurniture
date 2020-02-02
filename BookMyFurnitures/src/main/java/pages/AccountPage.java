package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.CommonMethods;

public class AccountPage extends CommonMethods {

	Logger log = Logger.getLogger(AccountPage.class);
	// @FindBy is to find page objects
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

	// The PageFactory Class in Selenium is an extension to the Page Object design
	// pattern.
	// It is used to initialize the elements of the Page Object or instantiate the
	// Page Objects itself. ...
	// It is used to initialize elements of a Page class without having to use
	// 'FindElement' or 'FindElements'.
	public AccountPage() {
		PageFactory.initElements(driver, this);
	}

	// creatAccount method to create new account that is fed data from testcase.
	// This method is using custom "sendKeys" and "click" for data
	// entry to the text boxes and submitting form respectively.
	public void createAccount(String name, String mobile, String emailAddress, String passwrd) {
		sendKeys(custname, name);
		sendKeys(mobileNo, mobile);
		sendKeys(email, emailAddress);
		sendKeys(password, passwrd);
		click(registerButton);
	}

//accountSuccessful method to validate that the account is successfully created.
	public void accountSuccessful() {
		isDisplayed(accountSucessful, "Account is successfully created for");
	}
}
