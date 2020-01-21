package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;



public class SelectPaymentPage extends TestBase {
	
	@FindBy(xpath="//div[@class='ui-g']//div[1]//p-radiobutton[1]//div[1]//div[2]//span[1]")
	private WebElement creditdebitatmradiobutton;
	
	@FindBy(xpath="//div[3]//p-radiobutton[1]//div[1]//div[2]")
	private WebElement cash;
	
	@FindBy(xpath="//div//div[2]//p-radiobutton[1]//div[1]//div[2]//span[1]")
	private WebElement netbanking;
	
	@FindBy(xpath="//button[@class='btn btn-success ng-star-inserted']")
	private WebElement placeorder;
	
	
	
public SelectPaymentPage() {

		
		PageFactory.initElements(driver, this);
	}

public Boolean verifySelectPaymentPage() {	
	return driver.findElement(By.xpath("//h3[contains(text(),'Select Payment Option')]")).isDisplayed();
	

}

public void selectPaymenttype(String payment)  {	
	if (payment.equals("card"))
	{
		creditdebitatmradiobutton.click();
	}
	
	else if (payment.equals("cash"))
	{
		cash.click();
		
	}
	
	else if (payment.equals("cash"))
	{
		netbanking.click();
		
	}
	
	}


public void clickonPlaceOrder()
{
	placeorder.click();
	
}

public Boolean OrderSuccessful()

{
	return driver.findElement(By.xpath("//h2[contains(text(),'Your order is successfully placed')]")).isDisplayed();
}
}




