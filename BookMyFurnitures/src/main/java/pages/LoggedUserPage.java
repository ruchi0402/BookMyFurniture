package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.CommonMethods;

public class LoggedUserPage extends CommonMethods {

	
	@FindBy(xpath = "//div[@class='circle-text-chair']")
	private WebElement chair;

	@FindBy(xpath = "//div[@class='circle-text-sofa']")
	private WebElement sofa;

	@FindBy(xpath = "//div[@class='circle-text-table']")
	private WebElement table;

	@FindBy(xpath = "")
	private WebElement bed;

	
	public LoggedUserPage() {
		PageFactory.initElements(driver, this);
	}

	public void ClickOnCategory(String category) {
		By categoryname = By.xpath("//div[@class='circle-text-" + category + "']");
		click(categoryname);
	}
}
