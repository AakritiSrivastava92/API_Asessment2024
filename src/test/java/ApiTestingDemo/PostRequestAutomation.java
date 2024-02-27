package ApiTestingDemo;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class PostRequestAutomation {
	
	@Test
	public void postApiAuto() {
		
		RestAssured.baseURI="https://reqres.in/api/users";
		
		String json = "{\r\n"
				+ "    \"name\": \"Klaus\",\r\n"
				+ "    \"job\": \"Vampire\"\r\n"
				+ "}";
		
		RestAssured.given().body(json).post().then().log().all().assertThat().statusCode(201);
	}

}
