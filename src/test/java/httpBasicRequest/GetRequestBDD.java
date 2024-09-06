package httpBasicRequest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
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
public class GetRequestBDD {
  @Test(priority = 1)
  public void getSingleUser() 
  {
	  given()
	  
	  .when()
	  .get("https://reqres.in/api/users/1")
	  
	  .then()
	  .statusCode(200)
	  .body("data.id", equalTo(1))
	  .body("support.url.", equalTo("https://reqres.in/#support-heading"))
	  .log().all();
  }
  
  /*
   * hasItems()->Check all elements are in a collection
   * contains()->check all elements are in a collection and in a strict order
   */
  
  @Test(priority = 2)
  public void getLidtOfUser() 
  {
	  given()
	  
	  .when()
	  .get("https://reqres.in/api/users?page=1")
	  
	  .then()
	  .statusCode(200)
	  .body("data.id[2]", equalTo(3))
	  .body("data.id", hasItems(1,2,3,4,5,6))
	  .body("data.id", hasItems(6,5,4,3,2,1))
	  .body("data.id", hasItems(3,2,1,4,5,6))
	  
	  .body("data.id", contains(1,2,3,4,5,6))
//	  .body("data.id", contains(3,2,1,4,5,6))
	  
	  
	  .log().body();
  }
  
}
