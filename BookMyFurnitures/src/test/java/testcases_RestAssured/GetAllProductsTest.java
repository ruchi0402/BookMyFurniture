package testcases_RestAssured;

import org.testng.annotations.Test;

import requests.RequestClass;

public class GetAllProductsTest extends BaseTest_Api {

	@Test
	public void getAllProductTest() {
		

		RequestClass request=new RequestClass();
		request.getRequest();
	}
	

}