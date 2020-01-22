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
import pages.ItemSelectPage;
import pages.HomePage;
import pages.LoggedUserPage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailPage;
import pages.SelectPaymentPage;
import util.TestUtil;

public class PurchaseProductTest extends BasePage {

	Logger log = Logger.getLogger(PurchaseProductTest.class);
	String sheetName = "ProductData";

	public PurchaseProductTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		instatiateBrowser();
	}
	
	@DataProvider
	public Object[][] getProductData() throws Exception {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 1, dataProvider = "getProductData")
	public void VerifyPurchaseProductTest(String username, String password, String Category, String Item,
			String Payment) {
		try {
			HomePage homePage = new HomePage();
			LoginPage loginPage = new LoginPage();
			LoggedUserPage logininuser = new LoggedUserPage();
			ItemSelectPage itemselect = new ItemSelectPage();
			ProductDetailPage productdetail = new ProductDetailPage();
			OrderDetailsPage orderdetail = new OrderDetailsPage();
			SelectPaymentPage selectpayment = new SelectPaymentPage();
			homePage.clickSignIn();
			loginPage.logIntoAccount(username, password);
			Assert.assertTrue(loginPage.loginSuccessful());
			logininuser.ClickOnCategory(Category);
			Assert.assertTrue(itemselect.itemSelectPage());
			itemselect.ClickonProduct(Item);
			Assert.assertTrue(productdetail.getProductDetail(Item));
			productdetail.clickBuyNow();
			Assert.assertTrue(orderdetail.orderDetailPage(Item));
			orderdetail.clickonPlaceOrder();
			Assert.assertTrue(selectpayment.verifySelectPaymentPage());
			selectpayment.selectPaymenttype(Payment);
			selectpayment.clickonPlaceOrder();
			Assert.assertTrue(selectpayment.OrderSuccessful());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw (e);
		}
	}
	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				TestUtil.takeScreenshotAtEndOfTest();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (ITestResult.SUCCESS == result.getStatus()) {
			try {
				TestUtil.takeScreenshotAtEndOfTest();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		driver.quit();
	}

}