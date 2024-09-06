package httpBasicRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
/*
 * given()-prerequisite
 * Request headers, request payload, query and path parameter, cookies, authentication
 * 
 * when()-APIRequest
 * GET,POST,PUT,PATCH,DELETE
 * 
 * then()-validation
 * Status code, message, time, response payload, headers, cookies
 */

public class POST_BDD {
  @Test(priority = 1)
  public void postUsingHashMap() 
  {
	  System.out.println("Post Request Using HashMap");
	  
	  //Request payload
	  HashMap<String,String>map=new HashMap<String,String>();
	  map.put("name", "Bishal");
	  map.put("job", "QA Engineer");
	  
	  given()
	  .contentType("application/json")
	  .body(map)
	  
	  .when()
	  .post("https://reqres.in/api/users")
	  
	  .then()
	  .statusCode(201)
	  .body("name", equalTo("Bishal"))
	  .body("job", equalTo("QA Engineer"))
	  .log().all();  
  }
  
  @Test(priority = 2) 
  public void postUsingPOJO() 
  {
	  System.out.println("Post Request Using POJO");
	  
	  //Payload
	  POJOData data = new POJOData();
	  data.setName("Nihal");
	  data.setJob("Test Engineer");
	  
	  given()
	  .contentType("application/json")
	  .body(data)
	  
	  
	  .when()
	  .post("https://reqres.in/api/users")
	  
	  
	  .then()
	  .statusCode(201)
	  .body("name", equalTo("Nihal"))
	  .body("job", equalTo("Test Engineer"))
	  .log().all();
  }
  @Test(priority = 3) 
  public void testPOJOResponse() 
  {
	  //Payload
	  POJOData data = new POJOData();
	  data.setName("Satya");
	  data.setJob("QC Engineer");
	  
	  int id = given()
	 .contentType("application/json")
	 .body(data)
			  
	 .when()
	 .post("https://reqres.in/api/users")
	 .jsonPath().getInt("id");
	  
	  System.out.println("Generated id Is: "+id);
	  
	  /*
	  Response res = (Response) given()
			  .contentType("application/json")
			  .body(data)
			  
			  .when()
			  .post("https://reqres.in/api/users");
	  
	  System.out.println(res.asPrettyString());
	  
	  String name = res.jsonPath().getString("name");
	  Assert.assertTrue(name.equals("Satya"),"Test Fail: name not matched");
	  System.out.println("Test Passed: Name Matched");
	  */
  }
}























