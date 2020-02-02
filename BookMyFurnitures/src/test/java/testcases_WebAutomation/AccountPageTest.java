package testcases_WebAutomation;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import util.TestUtil;
import org.apache.log4j.Logger;


public class AccountPageTest extends BaseTest_Web {

	String sheetName = "AccountData";
	Logger log = Logger.getLogger(AccountPageTest.class);

	@DataProvider
	public Object[][] getAccountData() throws Exception {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getAccountData")
	public void createAccountTest(String testcase,String name, String mobile, String email, String password) {
		log.info("***********Executing create Account "+ testcase +"***********");
		HomePage homePage = new HomePage();
	  	LoginPage loginPage = new LoginPage();
		AccountPage accountPage = new AccountPage();
		homePage.clickSignIn();
		loginPage.clickCreateAccount();
		accountPage.createAccount(name, mobile, email, password);
		accountPage.accountSuccessful();
	}
}