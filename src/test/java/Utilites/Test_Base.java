package Utilites;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Test_Base 
{
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID;
	public static Logger logger;
	public ExtentReports report;
	public ExtentTest test;
	@BeforeSuite
	public void setUp()
	{
		report = new ExtentReports("./API_PROJECT/tanush_extents.html",false);
		test = report.startTest("Tanush_API");
	}
	@BeforeClass
	public void setup()
	{
		logger = Logger.getLogger("api_tanush");
		PropertyConfigurator.configure("Log4j.properties");
		logger.setLevel(Level.DEBUG);

	}
	@BeforeSuite
	void teadDown()
	{
		report.flush();
		report.endTest(test);
	}	
}
