package testcases;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseTest {

	Logger log = Logger.getLogger(HomePageTest.class);

	@Test(priority = 1)
	public void validateHomePageTitleTest() {
		log.info("******************Starting validateHomePageTitleTest****************" );
	 		HomePage homePage = new HomePage();
			homePage.validateHomePageTitle();
			
			}
	
	@Test(priority = 2)
	public void ValidateLogoImageTest() {	
		log.info("******************Starting ValidateLogoImageTest****************" );
			HomePage homePage = new HomePage();
			homePage.ValidateLogoImage();
		
	}
}