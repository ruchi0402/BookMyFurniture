
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.CommonMethods;

public class ProductDetailPage extends CommonMethods {

	@FindBy(xpath = "//div[@class='float-right']//button[@class='btn btn-danger space'][contains(text(),'Buy Now')]")
	private WebElement buyNow;

	public ProductDetailPage() {

		PageFactory.initElements(driver, this);
	}

	public void getProductDetail(String itemdetail) {
		isDisplayed(
				driver.findElement(By.xpath("//div[@class='float-left']//h1[contains(text(),'" + itemdetail + "')]")),
				"Product Detail page is displayed");

	}

	public void clickBuyNow() {
		// if(signInLink.isDisplayed()||signInLink.isEnabled())
		click(buyNow);

		// else System.out.println("Element not found");
	}
}
