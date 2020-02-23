package testcases_RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import requests.RequestClass;

public class AddProductTest extends BaseTest_Api {

	@Test(priority = 1, dataProvider = "getProductData")
	public void addProductTest(String availability, String categoryId, String color, String created, String description,
			String discount, String material, String name, String price, String updateOn, String warranty) {
	
		 RequestClass request=new RequestClass();
		 request.postRequest(availability,categoryId,color,created,description,discount,material,name,price,updateOn,warranty);
		
		
	}

}