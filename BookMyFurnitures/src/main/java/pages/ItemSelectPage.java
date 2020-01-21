package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ItemSelectPage extends TestBase  {
	
	@FindBy(xpath="//h3[@class='text-center ng-star-inserted']")
	private WebElement searchpage;
	
public ItemSelectPage() {

		
		PageFactory.initElements(driver, this);
	}
	
	public Boolean itemSelectPage()
	
	{
		return searchpage.isDisplayed();
		
	}
	
	public void ClickonProduct(String  name) {
		driver.findElement(By.xpath("//b[contains(text(),'"+name+"')]")).click();	
		
	}
	
	

	
	

}
