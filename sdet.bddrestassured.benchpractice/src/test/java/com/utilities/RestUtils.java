package com.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	
	public static String getemployeename()
	{
		String genstring=RandomStringUtils.randomAlphabetic(3);
		
		return "Deepthi"+genstring;
	}
	
	
	public static String getemployeesalary()
	{
		String genstring=RandomStringUtils.randomNumeric(5);
		
		return genstring;
	}
	
	public static String getemployeeage()
	{
		String genstring=RandomStringUtils.randomNumeric(2);
		
		return genstring;
	}

}
