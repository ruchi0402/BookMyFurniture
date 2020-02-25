package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import base.CommonMethods;

public class LoggedUserPage extends CommonMethods {

	public LoggedUserPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnCategory(String category) {
		// dynamic xpath based on input from excel sheet. This is to avoid defining all
		// the categories using @FindBy annotation.
		By categoryname = By.xpath("//div[@class='circle-text-" + category + "']");
		click(categoryname);
	}
}
