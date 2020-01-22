package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;

public class ItemSelectPage extends BasePage {

	@FindBy(xpath = "//h3[@class='text-center ng-star-inserted']")
	private WebElement searchpage;

	public ItemSelectPage() {

		PageFactory.initElements(driver, this);
	}

	public Boolean itemSelectPage()

	{
		return searchpage.isDisplayed();

	}

	public void ClickonProduct(String product) {
		By productname = By.xpath("//b[contains(text(),'" + product + "')]");
		click(productname);
	}

}
