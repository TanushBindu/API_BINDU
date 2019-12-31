package Test_case;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import Utilites.LG;
import Utilites.Test_Base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class A extends Test_Base
{
	@Test
	void get_list_user_1() throws IOException
	{
		LG l1 = new LG();
		ArrayList<String> endpoint = LG.Get_all_one_by_one();
		//for (int i = 0; i < endpoint.size(); i++) 
		//{
			ExtentReports report = new ExtentReports("./API_PROJECT/tanush_extents1.html");
			ExtentTest test = report.startTest("Tanush_API");
			RestAssured.baseURI = "https://reqres.in/";
			logger.info("URL ENTERED");
			RequestSpecification httprequest = RestAssured.given();
			Response response = httprequest.request(Method.GET,"/api/users/2");
			logger.info("Endpoint ENTERED");
			String str = response.getBody().asString();
			int status_code = response.getStatusCode();
			System.out.println(status_code);
			logger.info("status Code taken");
			if (status_code==400)
			{
				test.log(LogStatus.PASS, "Test case passed");
			}
			else
			{
				test.log(LogStatus.FAIL, "Test Case failed");
			}
			report.flush();
			report.endTest(test);
		//}
	}
}
