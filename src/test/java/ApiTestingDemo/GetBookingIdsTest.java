package ApiTestingDemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

public class GetBookingIdsTest {
	@Test
	public void GetBookingIdsWithoutFilterTest() {
		Response res = RestAssured.get("https://restful-booker.herokuapp.com/booking");
		res.print();

		Assert.assertEquals(res.getStatusCode(), 200, "status code should be 200 but it's not");

		List<Integer> bookingIds = res.jsonPath().getList("bookingid");
		Assert.assertFalse(bookingIds.isEmpty(), "List of booking id is empty but it should not be");
	}

}
