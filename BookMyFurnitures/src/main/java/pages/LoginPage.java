package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {
	
	
			
	@FindBy(id="emailId")
	private WebElement email ;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//form[@class='ng-pristine ng-invalid ng-touched']//button[@class='btn btn-warning btn-lg btn-block'][contains(text(),'Clear')]")
	private WebElement clearButton;
	
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	private WebElement signInButton;
	


	@FindBy(xpath="//h2[contains(text(),'Sign in to your account')]")
	private WebElement signInpagetext;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-md']")
	private WebElement createAccount;
	
	public LoginPage() {

		
		PageFactory.initElements(driver, this);
	}
		
	public void logIntoAccount(String emailAddress, String loginpassword) {
		email.sendKeys(emailAddress);
		password.sendKeys(loginpassword);
		signInButton.submit();	
		
		
	}
	
	public Boolean getSignInPagetext() {
	return signInpagetext.isDisplayed();
	}
	public Boolean loginSuccessful() {
		return driver.findElement(By.xpath("//div[@id='toast-container']")).isDisplayed();
	}
	
	public void  clickCreateAccount() {		
		if(createAccount.isDisplayed()||createAccount.isEnabled())
			createAccount.click();
					
	}
	
	
	
	
	

}
