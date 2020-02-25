package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.CommonMethods;

public class ItemSelectPage extends CommonMethods {

	@FindBy(xpath = "//h3[@class='text-center ng-star-inserted']")
	private WebElement searchpage;

	public ItemSelectPage() {

		PageFactory.initElements(driver, this);
	}

	public Boolean itemSelectPage()

	{
		return searchpage.isDisplayed();

	}

	public void clickonProduct(String product) {
		// dynamic xpath based on input from excel sheet. This is used as there are
		// numerous products on the page and defining each of them using
		// page object is not useful.
		By productname = By.xpath("//b[contains(text(),'" + product + "')]");
		click(productname);
	}

}
