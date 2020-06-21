package NONBDDApproach;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_extractingeachvaluesfromnode {
	@Test
	public void get()
	{
		//specify BASE URI
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//specify request
		
		RequestSpecification httprequest=RestAssured.given();
		
		//get response
		
		Response response=httprequest.request(Method.GET, "/Hyderabad");
		
		System.out.println(response.jsonPath().get("City"));
		System.out.println(response.jsonPath().get("Temperature"));
		System.out.println(response.jsonPath().get("Humidity"));
		System.out.println(response.jsonPath().get("WeatherDescription"));
		System.out.println(response.jsonPath().get("WindSpeed"));
		System.out.println(response.jsonPath().get("WindDirectionDegree"));
	}

}
