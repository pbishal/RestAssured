package APIScenarios;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CookieValidation {
  @Test(priority = 1)
  public void getAllCookies() 
  {
	  System.out.println("This is a test for all cookies");
	  given()
	  
	  .when()
	  .get("https://www.google.com")
	  
	  .then()
	  .log().cookies();
  }
  @Test(priority = 2)
  public void getSingleCookie() 
  {
	  System.out.println("This is a test for single cookies");
	  Response res = given()
	  
			  .when()
			  .get("https://www.google.com");
	  String singleCookie = res.getCookie("AEC");
	  
	   
			  
	 
  }
}
