package httpBasicRequest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PUT_DeleteRequest {
  @Test(priority = 1)
  public void update_PUTCall() 
  {
	  //Payload
	  POJOData pojo = new POJOData();
	  pojo.setName("Dinesh");
	  pojo.setJob("Test Engineer");
	  
	  
	  given()
	  .contentType("application/json")
	  .body(pojo)
	  
	  
	  
	  .when()
	  .put("https://reqres.in/api/users/2")
	  
	  
	  .then()
	  .statusCode(200)
	  .log().all();
  }
  
  @Test(priority = 2)
  public void deleteUser() 
  {
	  
	  
	  given()
	  
	  .when()
	  .delete("https://reqres.in/api/users/2")
	  
	  .then()
	  .statusCode(204)
	  .log().all();
	  
  }
}

















