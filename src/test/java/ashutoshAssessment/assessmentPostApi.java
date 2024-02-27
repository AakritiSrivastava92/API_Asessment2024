package ashutoshAssessment;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
public class assessmentPostApi {
	
		@Test
		public void UserRegistrationSuccessful() 
		{  
			
		    RestAssured.baseURI ="https://reqres.in/api/users"; 
		    RequestSpecification request = RestAssured.given(); 
		    JSONObject requestParams = new JSONObject();
		    requestParams.put("name", "ashutosh");
		    requestParams.put("job", "engg%28");
		    request.body(requestParams.toJSONString());
		    Response response = request.put("/Users");
		    ResponseBody body = response.getBody();
		    System.out.println(response.getStatusLine());
		    System.out.println(body.asString());
		    Assert.assertEquals(200, response.getStatusCode()); 
		  	
	}
}
