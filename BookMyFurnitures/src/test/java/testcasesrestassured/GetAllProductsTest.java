package testcasesrestassured;

import org.testng.annotations.Test;

import requests.RequestClass;

public class GetAllProductsTest extends BaseTestApi {

	@Test
	public void getAllProductTest() {
		

		RequestClass request=new RequestClass();
		request.getRequest();
	}
	

}