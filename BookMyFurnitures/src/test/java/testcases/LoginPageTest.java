package testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;

public class LoginPageTest extends BaseTest {

	Logger log = Logger.getLogger(LoginPageTest.class);

	@DataProvider
	public Object[][] getLoginData() throws Exception {
		String sheetName = "LoginData";
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1)
	public void getSignInPagetext() {
		log.info("******************Starting getSignInPagetext****************");
		HomePage homePage = new HomePage();
		LoginPage loginPage = new LoginPage();
		homePage.clickSignIn();
		loginPage.getSignInPagetext();

	}

	@Test(priority = 2, dataProvider = "getLoginData")
	public void logIntoAccount(String testcase, String username, String password) {
		log.info("**************Executing log in to the Account test " + testcase + "************");
		HomePage homePage = new HomePage();
		LoginPage loginPage = new LoginPage();
		homePage.clickSignIn();
		loginPage.logIntoAccount(username, password);
		loginPage.loginSuccessful();
	}

}
