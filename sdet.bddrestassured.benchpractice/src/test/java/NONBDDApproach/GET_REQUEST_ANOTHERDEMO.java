package NONBDDApproach;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_REQUEST_ANOTHERDEMO {
	
	private static final String Headers = null;

	@Test
	public void getreqest()
	
		{
			//specify BASE URI
			
			RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
			
			//specify request
			
			RequestSpecification httprequest=RestAssured.given();
			
			//get response
			
			Response response=httprequest.request(Method.GET, "/Hyderabad");
			
			//to get header information
			
			String contenttype=response.getHeader("Content-Type");
			
			System.out.println("Content type is"+contenttype);
			
			Assert.assertEquals(contenttype, "application/json");
			
			Headers header = response.headers();
			
			System.out.println("Response body is"+response.getBody().asString());
			System.out.println("response body is"+response.jsonPath().prettify());
			
			System.out.println("City is"+response.jsonPath().get("City"));
			
			JsonPath jp=new JsonPath(response.asString());
			
			System.out.println("Extract through json path"+jp.get("City"));
			
			for(Header header1:header)
			{
				System.out.println("header key is"+header1.getName());
				System.out.println("header value is"+header1.getValue());
				
			}
			
			
			
			
			
		}

	}


