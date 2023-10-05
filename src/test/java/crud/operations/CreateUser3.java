package crud.operations;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUser3 {
	
	public static void main(String[] args) {
		createUser();
	}

	@SuppressWarnings("unchecked")
	public static void createUser() {
		// Create nessecary data
		JSONObject data = new JSONObject();
		data.put("name", "Sarswati");
		data.put("job", "Automaition Test Engineer");

		// send the request
		RequestSpecification request = RestAssured.given();
		request.body(data);
		request.contentType(ContentType.JSON);
		Response response = request.post("https://reqres.in/api/users");

		// validate the response
		response.then().log().all();
		System.out.println(response.getContentType());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getTime());
		System.out.println(response.getBody());
		response.then().assertThat().statusCode(201);
	}
}
