package testcases;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseTest {

	Logger log = Logger.getLogger(HomePageTest.class);

	public HomePageTest() {
		super();
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** HomePageTest *****************************************");
	}

		@Test(priority = 1)
	public void validateHomePageTitleTest() {
	 try {
			HomePage homePage = new HomePage();
			String title = homePage.validateHomePageTitle();
			Assert.assertEquals(title, "Book My Furniture - QA(2.3.2)-Final");
		} catch (Exception e) {
			log.error(e.getMessage());
			throw (e);
		}
	}

	@Test(priority = 2)
	public void ValidateLogoImageTest() {
		try {
			HomePage homePage = new HomePage();
			Assert.assertTrue(homePage.ValidateLogoImage());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw (e);
		}
	}

	@Test(priority = 3)
	public void verifyclickSignInTest() {
		try {
			HomePage homePage = new HomePage();
			homePage.clickSignIn();
			LoginPage loginPage = new LoginPage();
			Assert.assertTrue(loginPage.getSignInPagetext());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw (e);
		}
	}

}