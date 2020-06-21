package NONBDDApproach;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_REQUEST {
	
	@Test
	void Registrationsuccessful()
	{
		//specify BASE URI
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		//specify request
		
		RequestSpecification httprequest=RestAssured.given();
		
		
		//request payload
		
		JSONObject jsonobject=new JSONObject();
		
		jsonobject.put("FirstName", "Masala");
		jsonobject.put("LastName", "Dosa");
		jsonobject.put("UserName", "MAsaladosa");
		jsonobject.put("Password", "abc");
		jsonobject.put("Email", "masala@gmail.com");
		
		httprequest.body(jsonobject.toJSONString());
		
		httprequest.header("Content-Type","application/json");
		
		//get response
		
		Response response=httprequest.request(Method.POST, "/register");
		
		String responseBody=response.getBody().asString();
		
		System.out.println("Reponse body is"+responseBody);
		
		 int statuscode=response.getStatusCode();
		 Assert.assertEquals(statuscode, 201);
		 
		 String successcode = response.jsonPath().get("SuccessCode");
		 
		 Assert.assertEquals(successcode, "OPERATION_SUCCESS");
		
		
		
		
		
		
	}


}
