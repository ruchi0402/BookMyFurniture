package testcases;



import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

import java.io.IOException;

import org.apache.log4j.Logger;

public class AccountPageTest extends TestBase  {

	
	
	String sheetName="AccountData";
	Logger log = Logger.getLogger(AccountPageTest.class);
	
	
	public AccountPageTest() {
		super();
	}
	


	@BeforeMethod	
	public void setup() {
		
		instatiateBrowser();
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** CreateAccountTest *****************************************");	
			
			
		}

	@DataProvider
	public Object[][] getAccountData()throws Exception 
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test (priority=1, dataProvider="getAccountData")
        public void createAccountTest(String name, String mobile, String email, String password) {	
		try
		{
			HomePage homePage=new HomePage();	
			homePage.clickSignIn();
			LoginPage loginPage=new LoginPage();
			loginPage.clickCreateAccount();
			AccountPage accountpage=new AccountPage();
		    
		
		accountpage.createAccount(name, mobile, email, password);	
		Assert.assertTrue(accountpage.accountSuccessful());
		
		}
		catch (Exception e) {
			 log.error(e.getMessage());
			  throw(e);
		    
		}

		
					
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

