
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ProductDetailPage extends TestBase {
	
	@FindBy(xpath="//div[@class='float-right']//button[@class='btn btn-danger space'][contains(text(),'Buy Now')]")
	private WebElement buyNow;
	
public ProductDetailPage() {

		
		PageFactory.initElements(driver, this);
	}
	

   public Boolean getProductDetail( String itemdetail) {	
	return driver.findElement(By.xpath("//div[@class='float-left']//h1[contains(text(),'"+itemdetail+"')]")).isDisplayed();
	}

   public void clickBuyNow() {
		//if(signInLink.isDisplayed()||signInLink.isEnabled())
	   buyNow.click();
	  
		//else System.out.println("Element not found");
		
			
			
		}

}
