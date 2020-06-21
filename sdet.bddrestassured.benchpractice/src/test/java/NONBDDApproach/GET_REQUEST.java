package NONBDDApproach;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_REQUEST {
	
	@Test
	void getweatherdetails()
	{
		//specify BASE URI
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//specify request
		
		RequestSpecification httprequest=RestAssured.given();
		
		//get response
		
		Response response=httprequest.request(Method.GET, "/Hyderabad");
		
		String responseBody=response.getBody().asString();
		
		System.out.println("Reponse body is"+responseBody);
		
		JsonPath jp = response.jsonPath();
		
		System.out.println(jp.get("City"));
		
		//status code validation starts
	int statuscode = response.getStatusCode();
		System.out.println(response.getStatusCode());
		Assert.assertEquals(statuscode, 200);
		
		String statusline = response.getStatusLine();
		
		System.out.println(statusline);
		
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		
		
		
		
		
	}

}
