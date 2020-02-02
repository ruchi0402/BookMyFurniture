package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.CommonMethods;

public class LoginPage extends CommonMethods {
	Logger log = Logger.getLogger(LoginPage.class);

	@FindBy(id = "emailId")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(xpath = "//form[@class='ng-pristine ng-invalid ng-touched']//button[@class='btn btn-warning btn-lg btn-block'][contains(text(),'Clear')]")
	private WebElement clearButton;

	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private WebElement signInButton;

	@FindBy(xpath = "//h2[contains(text(),'Sign in to your account')]")
	private WebElement signInpagetext;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-md']")
	private WebElement createAccount;

	@FindBy(xpath = "//span[contains(text(),'Hi')]")
	private WebElement loginSuccessful;

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public void logIntoAccount(String emailAddress, String loginpassword) {
		sendKeys(email, emailAddress);
		sendKeys(password, loginpassword);
		click(signInButton);
	}

	public void getSignInPagetext() {
		isDisplayed(signInpagetext, "Sign in page is displayed");

	}

	public void loginSuccessful() {
		isDisplayed(loginSuccessful, "Login is successful");
	}

	public void clickCreateAccount() {
		click(createAccount);

	}

}
