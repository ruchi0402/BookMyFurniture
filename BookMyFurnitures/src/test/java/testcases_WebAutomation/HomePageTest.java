package testcases_WebAutomation;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest_Web {

	Logger log = Logger.getLogger(HomePageTest.class);

	@Test(priority = 1)
	public void validateHomePageTitleTest() {
		log.info("******************Starting validateHomePageTitleTest****************" );
	 		HomePage homePage = new HomePage();
			homePage.validateHomePageTitle();
			
			}
	
	@Test(priority = 2)
	public void ValidateLogoImageTest() {	
		log.info("******************Starting ValidateLogoImageTest*******************" );
			HomePage homePage = new HomePage();
			homePage.ValidateLogoImage();
		
	}
}