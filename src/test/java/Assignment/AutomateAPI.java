package Assignment;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class AutomateAPI {
	
	@Test
	public void getRequest() {
	
		Response res = RestAssured.given().contentType(ContentType.JSON).get("http://calapi.inadiutorium.cz/api/v0/en/calendars/general-en/today");
		res.print();
		
		Assert.assertEquals(res.getStatusCode(), 200, "status code should be 200 but it's not");
		
		System.out.println("RESPONSE VERIFIED.....");
		System.out.println("Status code: "+res.getStatusCode());
		
		String title = res.jsonPath().getString("celebrations.title");
		System.out.println("\n------TITLE : "+title+"-----------");
		
		String date = res.jsonPath().getString("date");
		System.out.println("\n------DATE : "+date+"------");
		
		String color = res.jsonPath().getString("celebrations.colour");
		System.out.println("\n-------COLOR : "+color+"-----");	

	}
	
	
	@Test
	public void postRequest() {
			
			RestAssured.baseURI="https://reqres.in";
			String json = "{\r\n"
					+ "    \"countryCode\": \"28\",\r\n"
					+ "    \"status\": \"1\",\r\n"
					+ "    \"pagination\": {\r\n"
					+ "        \"pageNumber\": 1,\r\n"
					+ "        \"pageSize\": 15\r\n"
					+ "    }\r\n"
					+ "}";
			Response response = given().contentType("application/json").body(json).when().post("/api/users?name=aakriti&job=engg%27").then().using().extract().response();
			Assert.assertEquals(response.getStatusCode(), 201, "DATA IS NOT CREATED >>>");
			response.print();
	}
	
}
