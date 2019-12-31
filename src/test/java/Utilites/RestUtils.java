package Utilites;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils 
{
	public static String emp_name()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("john"+generatedString);
	}
	
	public static String emp_job()
	{
		String generatedString = RandomStringUtils.randomNumeric(2);
		return ("DEV"+generatedString);
	}
}
