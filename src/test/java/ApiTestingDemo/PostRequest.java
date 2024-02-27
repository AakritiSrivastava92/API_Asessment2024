package ApiTestingDemo;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
public class PostRequest {
	
	@Test
	public void createBookingTest() {
		//create JSON body
		
		JSONObject body = new JSONObject();
		body.put("firstname","Susan");
		body.put("lastname", "Jackson");
		body.put("totalprice", 125);
		body.put("depositpaid", false);
		
		JSONObject bookingDates  = new JSONObject();
		bookingDates.put("checkin", "2022-12-04");
		bookingDates.put("checkout", "2023-01-20");
		body.put("bookingDates", bookingDates);
		body.put("additionalneeds", "Breakfast");
		
		//get response
		
		Response res = RestAssured.given().contentType(ContentType.JSON).body(body).get("https://restful-booker.herokuapp.com/booking");
		res.print();
		
		//verification
		
		Assert.assertEquals(res.getStatusCode(), 200, "status code should be 200 but it's not");

		String str = res.jsonPath().getInt("bookingid") + "";
		System.out.println(str+"------");

		SoftAssert soft = new SoftAssert();
		
		String actualFirstName = res.jsonPath().getString("booking.firstname");
		soft.assertEquals(actualFirstName, "Susan","first name is not matched");
		
		String actualLastName = res.jsonPath().getString("booking.lastname");
		soft.assertEquals(actualLastName, "Jackson","last name is not matched");
		
		
		int price = res.jsonPath().getInt("booking.totalprice");
		soft.assertEquals(price, 125,"total price is not expected");
		
		Boolean deposit = res.jsonPath().getBoolean("booking.depositpaid");
		soft.assertFalse(deposit,"deposit should be true");
		
		String checkIn = res.jsonPath().getString("booking.bookingdates.checkin");
		soft.assertEquals(checkIn, "2022-12-04","booking check in date is not matched");
		
		String checkOut = res.jsonPath().getString("booking.bookingdates.checkout");
		soft.assertEquals(checkOut, "2023-01-20","booking check out date is not matched");
		
		soft.assertAll();

	}

}
