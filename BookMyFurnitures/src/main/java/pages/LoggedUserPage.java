package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class LoggedUserPage extends BasePage {

	@FindBy(xpath = "//div[@id='toast-container']")
	private WebElement loggedIn;

	@FindBy(xpath = "//div[@class='circle-text-chair']")
	private WebElement chair;

	@FindBy(xpath = "//div[@class='circle-text-sofa']")
	private WebElement sofa;

	@FindBy(xpath = "//div[@class='circle-text-table']")
	private WebElement table;

	@FindBy(xpath = "")
	private WebElement bed;

	public String verifyLoginPageUrl() {
		return driver.getCurrentUrl();
	}

	public Boolean verifyUserLoggedIn() {
		return loggedIn.isDisplayed();
	}

	public LoggedUserPage() {
		PageFactory.initElements(driver, this);
	}

	public void ClickOnCategory(String category) {
		By categoryname = By.xpath("//div[@class='circle-text-" + category + "']");
		click(categoryname);
	}
}
