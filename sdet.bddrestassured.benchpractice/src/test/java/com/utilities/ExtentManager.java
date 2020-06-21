package com.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	public static ExtentReports extentreport;
	
	public static ExtentReports getInstance()
	
	{
		if(extentreport==null)
		{
		extentreport=new ExtentReports(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
		extentreport.loadConfig(new File("C:\\Users\\Deepthi\\eclipse-workspace\\sdet.bddrestassured.benchpractice\\extent-config.xml"));
		}
		return extentreport;
	}

}
