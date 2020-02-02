package testcases_RestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import base.CommonConstant;



public class AddProduct extends BaseTest_Api{
	
		
	@SuppressWarnings("unchecked")
	@Test(priority = 1, dataProvider = "getProductData")
	public void addProductTest(String availability, String categoryId, String color , String created, String description, String discount, String material,String name, String price,String updateOn,String warranty ) {	
	RequestSpecification request = RestAssured.given();
	JSONObject requestParams = new JSONObject();
	requestParams.put("availability", availability); 
	requestParams.put("categoryId", categoryId.charAt(0));
	requestParams.put("color", color);
	requestParams.put("createdOn", created);
	requestParams.put("description", description);
	requestParams.put("discount", discount.charAt(0));
	requestParams.put("materialDescription", material);
	requestParams.put("name", name);
	requestParams.put("price", price.charAt(0));
	requestParams.put("updateOn",  updateOn);
	requestParams.put("warranty",  warranty.charAt(0));
	request.header("Content-Type", "application/json");
	request.body(requestParams.toJSONString());
	Response response = request.post(CommonConstant.postURL);	 
	int statusCode = response.getStatusCode();
	String responseBody=response.getBody().asString();
	Assert.assertEquals(statusCode, 201);
	Assert.assertEquals(responseBody.contains("Tacoma kingbed"), true);
	}	

}
