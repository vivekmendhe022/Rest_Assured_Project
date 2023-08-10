package cud.operations.two;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUser {

	public static void main(String[] args) {
		createUser();
	}

	@SuppressWarnings("unchecked")
	public static void createUser() {

		// Step 1: Create the necessary Data JSONObject
		JSONObject obj = new JSONObject();
		obj.put("name", "Vivek");
		obj.put("job", "Tester");

		// step 2: send the request
		RequestSpecification req = RestAssured.given();
		req.body(obj);
		req.contentType(ContentType.JSON);
		Response response = req.post("https://reqres.in/api/users");

		// Step 3: Validate the response
		response.then().log().all();
		String contentType = response.getContentType();
		int statusCode = response.getStatusCode();
		String statusLine = response.getStatusLine();
		long time = response.getTime();
		System.out.println(contentType);
		System.out.println(statusCode);
		System.out.println(statusLine);
		System.out.println(time);
		response.then().assertThat().statusCode(201);
		if (statusCode == 201) {
			System.out.println("Created");
		} else {
			System.out.println("Error");
		}
	}

	@SuppressWarnings("unchecked")
	public Object createData(String key, String value) {
		JSONObject object = new JSONObject();
		object.put(key, value);
		return object;
	}

	@SuppressWarnings("unchecked")
	public void creatUser2() {
		// create necessary data
		JSONObject object = new JSONObject();
		object.put("name", "Chaitra");
		object.put("job", "Teacher");

		// send request
		RequestSpecification req = RestAssured.given();
		req.body(object);
		req.contentType(ContentType.JSON);
		Response response = req.post("https://reqres.in/api/users");

		// vlidate response
		response.then().log().all();
		System.out.println(response.getContentType());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getTime());
		response.then().assertThat().statusCode(201);
	}

}
