package httpBasicRequest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Create_Update_DeleteSameUser {
	
	int id;
	
  @Test(priority = 1)
  public void createUser() 
  {
	  //PayLoad
	  POJOData pojo = new POJOData();
	  pojo.setName("Aniket");
	  pojo.setJob("Android Dev");
	  
	  id = given()
	  .contentType("application/json")
	  .body(pojo)
	  
	  
	  .when()
	  .post("https://reqres.in/api/users")
	  .jsonPath().getInt("id");
	  
	 System.out.println("User created with id: "+id);
  }
  @Test(priority = 2, dependsOnMethods = "createUser")
  public void updateSameUser() 
  {
	  System.out.println("Same user is updating........");
	//PayLoad
	  POJOData pojo = new POJOData();
	  pojo.setName("Ashish");
	  pojo.setJob("iOS Dev");
	  
	  given()
	  .contentType("application/json")
	  .body(pojo)
	  
	  .when()
	  .put("https://reqres.in/api/users/"+id)
	  
	  .then()
	  .log().body();
	  
	  System.out.println("User updated with "+id);
  }
  @Test(priority = 3, dependsOnMethods = "updateSameUser")
  public void deleteSameUser() 
  {
	  System.out.println("Same user is Deleting........");
	  given()
	  
	  .when()
	  .delete("https://reqres.in/api/users/"+id)
	  
	  .then()
	  .statusCode(204);
	  
	  System.out.println("User deleted with id:"+id);
	  
  }
}




















