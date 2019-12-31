package Test_case;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;

import Utilites.Test_Base;

public class Put_repquest extends Test_Base
{
	static RequestSpecification httpRequest;
	static Response response;
	public static void main(String[] args) 
	{
		RestAssured.baseURI = "https://reqres.in/";
		httpRequest = RestAssured.given();
		httpRequest.header("Content-Type","application/json");
		JSONObject requestparams = new JSONObject();
		logger.info("******JSON OBJECT******");
		requestparams.put("name", "Bindu");
		requestparams.put("job", "TE");
		httpRequest.body(requestparams.toJSONString());
		response = httpRequest.request(Method.PUT,"/api/users");
		int status_code = response.getStatusCode();
		System.out.println(status_code);
	}
}
