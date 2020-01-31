package testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BasePage;

import pages.HomePage;
import pages.LoggedUserPage;
import pages.LoginPage;
import util.TestUtil;

public class LoginPageTest extends BaseTest {

	String sheetName = "LoginData";
	Logger log = Logger.getLogger(LoginPageTest.class);

	public LoginPageTest() {
		super();
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** LoginPageTest *****************************************");
	}

		@DataProvider
	public Object[][] getLoginData() throws Exception {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1)
	public void getSignInPagetext() {
		try {
			HomePage homePage = new HomePage();
			LoginPage loginPage = new LoginPage();
			homePage.clickSignIn();
			Assert.assertTrue(loginPage.getSignInPagetext());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw (e);
		}
	}

	@Test(priority = 2, dataProvider = "getLoginData")
	public void logIntoAccount(String username, String password) {
	try {
		HomePage homePage = new HomePage();
		LoginPage loginPage = new LoginPage();
		homePage.clickSignIn();
		loginPage.logIntoAccount(username, password);
		Assert.assertTrue(loginPage.loginSuccessful());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw (e);
	}
	}
}
