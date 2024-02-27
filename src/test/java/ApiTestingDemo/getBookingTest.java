package ApiTestingDemo;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getBookingTest {

	@Test
	public void GetBookingIdsWithoutFilterTest() {
		Response res = RestAssured.get("https://restful-booker.herokuapp.com/booking/1");
		res.print();

		Assert.assertEquals(res.getStatusCode(), 200, "status code should be 200 but it's not");

		SoftAssert soft = new SoftAssert();
		
		String actualFirstName = res.jsonPath().getString("firstname");
		soft.assertEquals(actualFirstName, "Susan","first name is not matched");
		
		String actualLastName = res.jsonPath().getString("lastname");
		soft.assertEquals(actualLastName, "Jackson","last name is not matched");
		
		
		int price = res.jsonPath().getInt("totalprice");
		soft.assertEquals(price, 125,"total price is not expected");
		
		Boolean deposit = res.jsonPath().getBoolean("depositpaid");
		soft.assertFalse(deposit,"deposit should be true");
		
		String checkIn = res.jsonPath().getString("bookingdates.checkin");
		soft.assertEquals(checkIn, "2022-12-04","booking check in date is not matched");
		
		String checkOut = res.jsonPath().getString("bookingdates.checkout");
		soft.assertEquals(checkOut, "2023-01-20","booking check out date is not matched");
		
		soft.assertAll();
		
		
		
	}

}
