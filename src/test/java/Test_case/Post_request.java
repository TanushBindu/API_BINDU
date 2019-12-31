package Test_case;

import java.io.IOException;
import java.util.ArrayList;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import Utilites.LG_POST;
import Utilites.RestUtils;
import Utilites.Test_Base;

import com.relevantcodes.extentreports.ExtentReports;

public class Post_request extends Test_Base
{
	RequestSpecification httpRequest;
	Response response;
	
	@Test
	void post_emp_data() throws IOException
	{
		LG_POST a1 = new LG_POST();
		ArrayList<String> a2 = LG_POST.Get_all_one_by_one();
		for (int i = 0; i < a2.size(); i++) 
		{
			RestAssured.baseURI = "https://reqres.in";
			httpRequest = RestAssured.given();
			httpRequest.header("Content-Type","application/json");
			JSONObject requestparams = new JSONObject();
			requestparams.put("name", "Tanush");
			requestparams.put("job", "Dev");
			httpRequest.body(requestparams.toJSONString());
			response = httpRequest.request(Method.POST,a2.get(i));
			int status_code = response.statusCode();
			System.out.println(status_code);
		}
		
	}	
}
