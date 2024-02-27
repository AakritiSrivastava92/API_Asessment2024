package HRone_Demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HRone_ApplicationLaunch {

	@Test
	public static void CreateCountry() {
//		RestAssured.baseURI="https://sanity-hrone-website.azurewebsites.net/app";
//		String json = "{\r\n"
//				+ "    \"countryCode\": \"\",\r\n"
//				+ "    \"countryName\": \"Bit-Country31-01\",\r\n"
//				+ "    \"internationalCode\": \"291\",\r\n"
//				+ "    \"nationality\": \"Rebelian-01\",\r\n"
//				+ "    \"activeStatus\": \"1\"\r\n"
//				+ "}";
//		Response response = RestAssured.given().contentType("application/json").body(json).post("/core/organization/location/country");
//		System.out.println("Response Body: " + response.getBody().asString());
//	
		
        String apiUrl = "https://sanity-hrone-webapi.azurewebsites.net/api/core/Country/Search";
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl);

      /*  String jsonPayload = "{\r\n"
        		+ "    \"countryCode\": \"24\",\r\n"
        		+ "    \"status\": \"1\",\r\n"
        		+ "    \"pagination\": {\r\n"
        		+ "        \"pageNumber\": 1,\r\n"
        		+ "        \"pageSize\": 15\r\n"
        		+ "    }\r\n"
        		+ "}";
        StringEntity entity = new StringEntity(jsonPayload, "UTF-8");
        entity.setContentType("application/json"); */
//        httpPost.setEntity(entity);

        try {
            HttpResponse response = httpClient.execute(httpGet);
            System.out.println("Response Code >> inside createCountry method >>>> " + response.getStatusLine().getStatusCode());
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                String responseBody = EntityUtils.toString(responseEntity);
                System.out.println("Response Body: " + responseBody);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
	        String apiUrl = "https://www.interviewbit.com/get_user_options/?path=/api-testing-interview-questions/";
	        HttpClient httpClient = HttpClients.createDefault();
	        HttpGet httpGet = new HttpGet(apiUrl);
	        try {
	            HttpResponse response = httpClient.execute(httpGet);
	            System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
//	        CreateCountry();
	    }
}
