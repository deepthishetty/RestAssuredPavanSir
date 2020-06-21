package com.employee.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class DeleteEmployee extends TestBase {
	
	@BeforeClass
	void deleteEmployee() throws InterruptedException
	{
		logger.info("*********Started TC005_Delete_Employee_Record **********");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httprequest = RestAssured.given();
		
		response = httprequest.request(Method.GET, "/employees");
				System.out.println(response.getBody().asString());
		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();
			 
		//Capture id
		String empID=jsonPathEvaluator.get("data[13].id");
		response = httprequest.request(Method.DELETE, "/delete/"+empID); //Pass ID to delete record
		
		Thread.sleep(3000);
	}
	
	@Test
	void checkResposeBody()
	{
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("successfully! deleted Records"), true);

	}
		
	@Test
	void checkStatusCode()
	{
		int statusCode = response.getStatusCode(); // Gettng status code
		Assert.assertEquals(statusCode, 200);
	}
		
	@Test
	void checkstatusLine()
	{
		String statusLine = response.getStatusLine(); // Gettng status Line
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	
	@Test
	void checkContentType()
	{
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}

	@Test
	void checkserverType()
	{
		String serverType = response.header("Server");
		Assert.assertEquals(serverType, "nginx/1.14.1");
	}

	@Test
	void checkcontentEncoding()
	{
		String contentEncoding = response.header("Content-Encoding");
		Assert.assertEquals(contentEncoding, "gzip");

	}

	@AfterClass
	void tearDown()
	{
		logger.info("*********  Finished TC005_Delete_Employee_Record **********");
	}



}
