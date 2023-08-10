package crud.operations;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUser2 {

	public static String url = "https://reqres.in/api/users/2";

	public static void main(String[] args) {
		deleteRequest();
	}
	
	public static void deleteRequest() {
		Response response = RestAssured.delete(url);
		System.out.println(response.statusCode());
		System.out.println("DELETE Response:\n" + response.getBody().asPrettyString());
	}

	public static void getUser() {
		Response res = RestAssured.get(url);
		System.out.println(res.getStatusCode());
		boolean isStatusCode200 = (res.getStatusCode() == 200);
		System.out.println("Status code is 200: " + isStatusCode200);
		System.out.println("GET Response:\n" + res.getBody().asPrettyString());
	}
	
	

	@SuppressWarnings("unchecked")
	public static void createUser() {
		// Create neccessary data
		JSONObject j = new JSONObject();
		j.put("name", "Mobile");
		j.put("job", "Varisous Tech Job");

		// Send Request
		RequestSpecification req = RestAssured.given();
		req.body(j);
		req.contentType(ContentType.JSON);
		Response res = req.post("https://reqres.in/api/users");

		// Validate the response
		res.then().log().all();
		System.out.println(res.getContentType());
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getBody().asPrettyString());
		res.then().assertThat().statusCode(201);
	}

}
