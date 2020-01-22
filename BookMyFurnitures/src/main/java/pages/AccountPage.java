package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class AccountPage extends BasePage {

	@FindBy(id = "name")
	private WebElement custname;

	@FindBy(id = "mobileNo")
	private WebElement mobileNo;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/bmf-layout[1]/div[2]/app-login[1]/div[1]/p-sidebar[1]/div[1]/app-signup[1]/div[1]/div[1]/form[1]/div[3]/input[1]")
	private WebElement email;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/bmf-layout[1]/div[2]/app-login[1]/div[1]/p-sidebar[1]/div[1]/app-signup[1]/div[1]/div[1]/form[1]/div[4]/div[1]/input[1]")
	private WebElement password;

	@FindBy(xpath = "//button[contains(text(),'Register')]")
	private WebElement registerButton;

	public AccountPage() {
		PageFactory.initElements(driver, this);
	}
	public void createAccount(String name, String mobile, String emailAddress, String Password) {
		custname.sendKeys(name);
		mobileNo.sendKeys(mobile);
		email.sendKeys(emailAddress);
		password.sendKeys(Password);
		click(registerButton);
	}
	public Boolean accountSuccessful() {
		return driver.findElement(By.xpath("//div[@id='toast-container']")).isDisplayed();
	}
}
