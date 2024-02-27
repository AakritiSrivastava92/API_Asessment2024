package ApiTestingDemo;

//using BDD syntax
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class HealthCheckTest {
	@Test
	public void getWeatherDetails() {
		given()
		.when()
			.get("https://restful-booker.herokuapp.com/ping")
		.then()
			.assertThat()
			.statusCode(201);
	}
}
