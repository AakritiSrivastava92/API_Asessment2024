package ashutoshAssessment;

import org.junit.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

	

	public class assessmentGetApi {

		@Test
		public void GetBooksDetails() {
			RestAssured.baseURI = "https://official-joke-api.appspot.com/random_joke";
			RequestSpecification httpRequest = RestAssured.given();
			Response response = httpRequest.request(Method.GET, "");
			System.out.println(response.prettyPrint());
			Assert.assertEquals(200, response.getStatusCode()); 

		}

	

}
