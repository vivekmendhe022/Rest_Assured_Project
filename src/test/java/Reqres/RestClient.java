package Reqres;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestClient {

	// GET Request
	public void getRequest(String endpoint) {
		Response response = RestAssured.get(endpoint);
		System.out.println("GET Response:\n" + response.getBody().asString());
	}

	// POST Request
	public void postRequest(String endpoint, String jsonPayload) {
		Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonPayload).post(endpoint);
		System.out.println("POST Response:\n" + response.getBody().asString());
	}

	// PUT Request
	public void putRequest(String endpoint, String jsonPayload) {
		Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonPayload).put(endpoint);
		System.out.println("PUT Response:\n" + response.getBody().asString());
	}

	// PATCH Request
	public void patchRequest(String endpoint, String jsonPayload) {
		Response response = RestAssured.given().contentType(ContentType.JSON).body(jsonPayload).patch(endpoint);
		System.out.println("PATCH Response:\n" + response.getBody().asString());
	}

	// DELETE Request
	public void deleteRequest(String endpoint) {
		Response response = RestAssured.delete(endpoint);
		System.out.println("DELETE Response:\n" + response.getBody().asString());
	}

}

