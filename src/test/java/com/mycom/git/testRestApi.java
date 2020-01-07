package com.mycom.git;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class testRestApi {

	
	 @Test
	  public void getapi() {
		 
		 System.out.println("This is test case");
		 
		
			RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
	     	RequestSpecification httpRequest = RestAssured.given();
	    	Response response = httpRequest.request(Method.GET, "/Hyderabad");
			String responseBody = response.getBody().asString();
			
			//JsonPath responseBoddy = response.getBody().jsonPath();
			//responseBoddy.
			
			System.out.println("Response getStatusLine is =>  " + response.getStatusLine());
			System.out.println("Response code is =>  " + response.getStatusCode());
			System.out.println("Response Body is =>  " + responseBody);
		    System.out.println("Response Body is =>  " + responseBody);
		 
	  }	
	 
	 @Test
	 public void getBodyAndHeadTest(){
		 
		 
		    RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
			RequestSpecification httpRequest = RestAssured.given();
			Response response = httpRequest.get("/Hyderabad");
		 
			JsonPath jsonPathEvaluator = response.jsonPath();
			
			System.out.println("----------------BODY--------------------------------------");
			
			System.out.println("City received from Response " + jsonPathEvaluator.get("City"));
			System.out.println("Temperature received from Response " + jsonPathEvaluator.get("Temperature"));
			System.out.println("Humidity received from Response " + jsonPathEvaluator.get("Humidity"));
			System.out.println("Weather description received from Response " + jsonPathEvaluator.get("Weather"));
			System.out.println("City received from Response " + jsonPathEvaluator.get("WindSpeed"));
			System.out.println("City received from Response " + jsonPathEvaluator.get("WindDirectionDegree"));
			
			
			
			System.out.println("----------------HEADER--------------------------------------");
			
			
			Headers allHeaders = response.headers();
			 
			// Iterate over all the Headers
			for(Header header : allHeaders)
			{
				System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
			}
			
			
			System.out.println("----------------HEADER- Another way--------------------------------------");
			System.out.println("Content-Type from Header: " + response.header("Content-Type"));
			System.out.println("Server from Header: " + response.header("Server"));
			System.out.println("Content-Encoding: " + response.header("Content-Encoding"));
			
			//Assert.assertEquals(contentType /* actual value */, "application/json" /* expected value */);
		 
			// Reader header of a give name. In this line we will get
			// Header named Server
			
			//Assert.assertEquals(serverType /* actual value */, "nginx/1.12.1" /* expected value */);
		 
			// Reader header of a give name. In this line we will get
			// Header named Content-Encoding
			
			//Assert.assertEquals(contentEncoding /* actual value */, "gzip" /* expected value */);
		}

	 
	@SuppressWarnings("unchecked")
	@Test
	 public void testPost(){
		 
		    RestAssured.baseURI ="http://restapi.demoqa.com/customer";
			RequestSpecification request = RestAssured.given();
		 
			JSONObject requestParams = new JSONObject();
			requestParams.put("FirstName", "Virender"); // Cast
			requestParams.put("LastName", "Singh");
			requestParams.put("UserName", "sdimpleuser2dd2011");
			requestParams.put("Password", "password1");
		 
			requestParams.put("Email",  "sample2ee26d9@gmail.com");
			
			//request.
			
			request.body(requestParams.toJSONString());
			Response response = request.post("/register");
		 
			int statusCode = response.getStatusCode();
			System.out.println(statusCode);
			//Assert.assertEquals(statusCode, "201");
			String successCode = response.jsonPath().get("SuccessCode");
			System.out.println(successCode);
			
			//Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
		}

		 
	 
	 
	 
	 
	
 /*@Test(dataProvider = "dp")
 public void f(Integer n, String s) {
 }

 @DataProvider
 public Object[][] dp() {
   return new Object[][] {
     new Object[] { 1, "a" },
     new Object[] { 2, "b" },
   };
 }*/
	
 @BeforeClass
 public void beforeClass() {
 }

 @AfterClass
 public void afterClass() {
 }


  
  
}
