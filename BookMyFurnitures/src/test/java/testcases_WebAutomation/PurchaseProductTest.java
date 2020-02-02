package testcases_WebAutomation;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ItemSelectPage;
import pages.HomePage;
import pages.LoggedUserPage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailPage;
import pages.SelectPaymentPage;
import util.TestUtil;

public class PurchaseProductTest extends BaseTest_Web {

	Logger log = Logger.getLogger(PurchaseProductTest.class);

	@DataProvider
	public Object[][] getProductData() throws Exception {
		String sheetName = "ProductData";
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getProductData")
	public void VerifyPurchaseProductTest(String testcase, String username, String password, String Category,
			String Item, String Payment) {
		log.info("*************Executing Purchase Product test " + testcase + "********");
		HomePage homePage = new HomePage();
		LoginPage loginPage = new LoginPage();
		LoggedUserPage logininuser = new LoggedUserPage();
		ItemSelectPage itemselect = new ItemSelectPage();
		ProductDetailPage productdetail = new ProductDetailPage();
		OrderDetailsPage orderdetail = new OrderDetailsPage();
		SelectPaymentPage selectpayment = new SelectPaymentPage();
		homePage.clickSignIn();
		loginPage.logIntoAccount(username, password);
		loginPage.loginSuccessful();
		logininuser.ClickOnCategory(Category);
		itemselect.itemSelectPage();
		itemselect.ClickonProduct(Item);
		productdetail.getProductDetail(Item);
		productdetail.clickBuyNow();
		orderdetail.orderDetailPage(Item);
		orderdetail.clickonPlaceOrder();
		selectpayment.verifySelectPaymentPage();
		selectpayment.selectPaymenttype(Payment);
		selectpayment.clickonPlaceOrder();
		selectpayment.OrderSuccessful();

	}
}
