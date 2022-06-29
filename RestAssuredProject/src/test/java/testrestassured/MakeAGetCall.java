package testrestassured;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*
 
4. Make a GET call. Assert the response status code and userId
Test data - https://jsonplaceholder.typicode.com/posts/1
jsonplaceholder.typicode.com
jsonplaceholder.typicode.com
{ "userId": 1, "id": 1, "title": "sunt autfacererepellat provident occaecatiexcepturioptioreprehenderit", "body": "quia et suscipit\nsuscipitrecusandae ...

 */

public class MakeAGetCall {
	@Test
	public void getUserID() {


	RestAssured.baseURI="https://jsonplaceholder.typicode.com/posts";
	  
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  //Response object
	  Response response=httpRequest.request(Method.GET,"/1");
	  
	  
	  //print response in console window
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	  //status code validation
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is: "+statusCode);
	  Assert.assertEquals(statusCode, 200);
	  
	  //Asserting the id
	  JsonPath jp= response.jsonPath();
	  int value= jp.get("userId");
	  System.out.println(value);
	  Assert.assertEquals(value, 1);


}
}
