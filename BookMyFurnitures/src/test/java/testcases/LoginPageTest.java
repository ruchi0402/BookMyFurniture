package testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;

import pages.HomePage;
import pages.LoggedUserPage;
import pages.LoginPage;
import util.TestUtil;

public class LoginPageTest extends TestBase {

	
	String sheetName="LoginData";
	
	public LoginPageTest() {
		super();
	}
	


	@BeforeMethod	
	public void setup() {
		
		instatiateBrowser();
				
		}
		
		@DataProvider
		public Object[][] getLoginData()throws Exception 
		{
			Object data[][]=TestUtil.getTestData(sheetName);
			return data;
		}
	
	@Test(priority=1)
	public void getSignInPagetext(){
		HomePage homePage=new HomePage();		
		homePage.clickSignIn();	
		LoginPage loginPage=new LoginPage();
		
	Assert.assertTrue(loginPage.getSignInPagetext());
	}
	
	
	
	@Test(priority=2, dataProvider="getLoginData")
	public void logIntoAccount(String username, String password) {	
		
		HomePage homePage=new HomePage();		
		homePage.clickSignIn();	
		LoginPage loginPage=new LoginPage();
		loginPage.logIntoAccount(username, password);
	    Assert.assertTrue(loginPage.loginSuccessful());	
	
	}
	
	@AfterMethod
	public void tearDown(ITestResult result){
	if(ITestResult.FAILURE==result.getStatus())
	{
		try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	else if (ITestResult.SUCCESS==result.getStatus())
	{
		try {
			TestUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		driver.quit();
	}

}
	
	