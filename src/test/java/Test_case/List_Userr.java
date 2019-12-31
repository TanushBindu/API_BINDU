package Test_case;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import Utilites.LG_GET;
import Utilites.Test_Base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class List_Userr extends Test_Base
{																																					
	@Test
	void get_list_user() throws IOException
	{
		LG_GET l1 = new LG_GET();
		ArrayList<String> endpoint = LG_GET.Get_all_one_by_one();
		for (int i = 0; i < endpoint.size(); i++) 
		{
			RestAssured.baseURI = "https://reqres.in/";
			logger.info("URL ENTERED");
			RequestSpecification httprequest = RestAssured.given();
			Response response = httprequest.request(Method.GET,endpoint.get(i));
			logger.info("Endpoint ENTERED");
			String str = response.getBody().asString();
			int status_code = response.getStatusCode();
			System.out.println(status_code);
			logger.info("status Code taken");
			if (status_code==200)
			{
				test.log(LogStatus.PASS, "Test case passed");
			}
			else if(status_code==404)
			{
				test.log(LogStatus.PASS, "Test case passed");
			}
			else
			{
				test.log(LogStatus.FAIL, "Test case failes");
			}
		}
	}
	
}
