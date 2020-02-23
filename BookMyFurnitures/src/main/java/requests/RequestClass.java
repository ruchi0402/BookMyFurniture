package requests;

import org.json.simple.JSONObject;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import base.CommonConstant;
import base.CommonMethods;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestClass extends CommonMethods {
	
	@SuppressWarnings("unchecked")
	public void postRequest(String availability, String categoryId, String color, String created,
			String description, String discount, String material, String name, String price, String updateOn,
			String warranty) {
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
		requestParams.put("updateOn", updateOn);
		requestParams.put("warranty", warranty.charAt(0));
		request.header("Content-Type", "application/json");
		request.body(requestParams.toJSONString());
		Response response = request.post(CommonConstant.postURL);
		validateResponse(response, 201);
		
	}
	
	public void getRequest()
	{
		RequestSpecification request = RestAssured.given();
		Response response = request.get(CommonConstant.getURL);
		validateResponse(response, 201);
		
	}
	
	
	

}
