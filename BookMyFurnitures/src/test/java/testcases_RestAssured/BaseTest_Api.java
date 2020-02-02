package testcases_RestAssured;

import org.testng.annotations.DataProvider;

import util.TestUtil;

public class BaseTest_Api {

	@DataProvider
	public Object[][] getProductData() throws Exception {

		Object data[][] = TestUtil.getTestData("ProductPostData");
		return data;
	}

}
