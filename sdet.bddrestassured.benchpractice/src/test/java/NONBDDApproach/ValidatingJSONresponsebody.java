package NONBDDApproach;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ValidatingJSONresponsebody {
	
	@Test
	public void get()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//specify requestfghjkl
		
		RequestSpecification httprequest=RestAssured.given();
		
		//get response
		
		Response response=httprequest.request(Method.GET, "/Delhi");
		
		String responsebody=response.getBody().asString();
		
		System.out.println("Repsonse body is"+responsebody);
		
		Assert.assertEquals(responsebody.contains("Delhi"), true);
	}

}
