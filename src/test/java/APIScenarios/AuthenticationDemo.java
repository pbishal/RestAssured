package APIScenarios;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class AuthenticationDemo {
  @Test(priority = 1)
  public void basicAuth() 
  {
	
	  given()
	  .auth().basic("postman", "password")
	  
	  
	  .when()
	  .get("https://postman-echo.com/basic-auth")
	  
	  .then()
	  .statusCode(200)
	  .body("authenticated", equalTo(true))
	  .log().body();
	  
	  System.out.println("Basic authentication is completed");
  }
  @Test(priority = 2)
  public void digestAuth() 
  {
	  given()
	  .auth().digest("postman", "password")
	  
	  
	  .when()
	  .get("https://postman-echo.com/digest-auth")
	  
	  .then()
	  .statusCode(200)
	  .body("authenticated", equalTo(true))
	  .log().body();
	  
	  System.out.println("Digest authentication is completed");
  }
  @Test(priority = 3)
  public void bearerTokenAuth() 
  {
	  given()
	  .header("Authorizaruin","Bearer 12345")
	  
	  
	  .when()
	  .get("https://postman-echo.com")
	  
	  .then()
	  .statusCode(200)
	  .log().all();
  }
  @Test(priority = 4)
  public void oAuth2Test() 
  {
	  given()
	  .auth().oauth2("12345")
	  
	  
	  .when()
	  .get("https://postman-echo.com")
	  
	  .then()
	  .statusCode(200)
	  .log().all();
  }
}
















