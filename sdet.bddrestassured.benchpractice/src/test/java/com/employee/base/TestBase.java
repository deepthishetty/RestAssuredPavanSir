package com.employee.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import com.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	//public ExtentReports report=ExtentManager.getInstance();
	public static ExtentTest test;
	
	public static RequestSpecification httprequest;
	
	public static Response response;
	
	public static String empid="15";
	
	public Logger logger;
	
	public void waitforgiventime(Long l) throws InterruptedException
	{
		Thread.sleep(l);
	}
	
	@BeforeClass
	public void setup()
	{
		logger=Logger.getLogger("RestAPI test");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
	}

}
