package com.employee.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employee.base.TestBase;
import com.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class PostEmployees extends TestBase{
	
	String empname=RestUtils.getemployeename();
	String empsalary=RestUtils.getemployeesalary();
	String empage=RestUtils.getemployeeage();
	
	
	@BeforeClass
	public void createemployees() throws InterruptedException
	{
		logger.info("*********Started TC00Create_Employees **********");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httprequest=RestAssured.given();
		
		JSONObject jsonobject=new JSONObject();
		jsonobject.put("name", empname);
		jsonobject.put("salary", empsalary);
		jsonobject.put("age", empage);
		httprequest.header("Content-Type","application/json");
		
		httprequest.body(jsonobject.toJSONString());
		response=httprequest.request(Method.POST, "/create");
		
		waitforgiventime(7000l);
	}
	
	@Test
	void checkrepsonseBody()
	{
		logger.info("Checking repsonse body");
		
		String respbody = response.getBody().asString();
		
		logger.info("response body is"+respbody);
		
		Assert.assertTrue(respbody.contains(empname));
		Assert.assertTrue(respbody.contains(empsalary));
		Assert.assertTrue(respbody.contains(empage));
	}
	
	
	@Test
	void checkstatuscode()
	{
		logger.info("Checking status code");
		
		int statuscode = response.getStatusCode();
		
		logger.info("response code is"+statuscode);
		
		Assert.assertEquals(statuscode, 200);
		}
	
	
	@Test
	void checkresponsetime()
	{
		logger.info("Checking response time");
		
		long responsetime = response.getTime();
		
		logger.info("response time is"+responsetime);
		if(responsetime>2000)
			logger.warn("Response Time is greater than 2000");
		
		Assert.assertTrue(responsetime<10000);
		}
	
	@Test
	void checkstatusLine()
	{
		logger.info("***********  Checking Status Line **********");
		
		String statusLine = response.getStatusLine(); // Getting status Line
		logger.info("Status Line is ==>" + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	
		
	}
	
	
	@Test
	void checkContentType()
	{
		logger.info("***********  Checking Content Type **********");
		
		String contentType = response.header("Content-Type");
		logger.info("Content type is ==>" + contentType);
		Assert.assertEquals(contentType, "application/json;charset=utf-8");
	}
	
	@Test
	void checkserverType()
	{
		logger.info("***********  Checking Server Type **********");
		
		String serverType = response.header("Server");
		logger.info("Server Type is =>" +serverType); 
		Assert.assertEquals(serverType, "nginx/1.16.0");
	
	}
	
	@Test
	void checkcontentEncoding()
	{
		logger.info("***********  Checking Content Encoding**********");
		
		String contentEncoding = response.header("Content-Encoding");
		logger.info("Content Encoding is==>" +contentEncoding); 
		Assert.assertEquals(contentEncoding, "gzip");
		
		
	}

	@Test
	void checkContentLenght()
	{
		logger.info("***********  Checking Content Lenght**********");
		
		String contentLength = response.header("Content-Length");
		logger.info("Content Length is==>" +contentLength); 
		
		if(Integer.parseInt(contentLength)<100)
			logger.warn("Content Length is less than 100");
		
		Assert.assertTrue(Integer.parseInt(contentLength)>100);
		
	}
		
	@Test
	void checkCookies()
	{
		logger.info("***********  Checking Cookies **********");

		String cookie = response.getCookie("PHPSESSID");
		//Assert.assertEquals(cookie,"1esuvsfslcmiee2bfrsgnijtg0");
		
	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("*********  Finished TC001_Get_All_Employees **********");
	}

}
