package NONBDDApproach;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_AUTHORIZARION_GET {
	@Test
	public void checkauthorization()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		//Basic Authentications
		
		PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme();
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		
		RestAssured.authentication=authscheme;
		
		
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET, "/");
		System.out.println("Response body is"+response.getBody().asString());
		int statuscode=response.getStatusCode();
		System.out.println("Status code is "+statuscode);
		Assert.assertEquals(statuscode, 200);
		
		
		
		
	}

}
