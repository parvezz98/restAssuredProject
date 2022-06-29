package testrestassured;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*
 5. Make a POST call. Assert the response status code and id
Test data - https://jsonplaceholder.typicode.com/posts
body: { title: 'foo', body: 'bar', userId: 1 } 
headers:"Content-type": "application/json; charset=UTF-8"

 */
 public class MakePostCall {	
	@Test
	public void getUderID() {
		
		//Specify base URI
		//Specify base URI
		  RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		  
		  //Request object
		  RequestSpecification httpRequest=RestAssured.given();
		  
		  JSONObject requestParams=new JSONObject();
		  
		  requestParams.put("title","foo");
		  requestParams.put("body","bar");
		  requestParams.put("userId",1);
		  httpRequest.body(requestParams);
		  httpRequest.header("Content-Type","application/json;charset=UTF-8\"");
		  httpRequest.header("Accept","application/json");
		  
		  //Response object
		  Response response=httpRequest.request(Method.POST,"/posts");
		  
		  
		  //print response in console window
		  String responseBody=response.getBody().asString();
		  System.out.println("Response Body is:" +responseBody);
		  
		  //status code validation
		  int statusCode=response.getStatusCode();
		  System.out.println("Status code is: "+statusCode);
		  Assert.assertEquals(statusCode, 201);
		  
		  //Asserting the id
		  JsonPath jp= response.jsonPath();
			int value= jp.get("id");
			System.out.println(value);
			Assert.assertEquals(value, 101);
	}

}
