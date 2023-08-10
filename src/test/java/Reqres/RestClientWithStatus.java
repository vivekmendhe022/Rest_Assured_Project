package Reqres;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestClientWithStatus {

	public class RestClient {

		// GET Request
		public void getRequest(String endpoint) {
			RestAssured.get(endpoint).then()
			.assertThat().statusCode(200)
			.contentType(ContentType.JSON);
		}

		// POST Request
		public void postRequest(String endpoint, String jsonPayload) {
			RestAssured.given()
			.contentType(ContentType.JSON)
			.body(jsonPayload).post(endpoint)
			.then().assertThat()
			.statusCode(201)
			.contentType(ContentType.JSON);
		}

		// PUT Request
		public void putRequest(String endpoint, String jsonPayload) {
			RestAssured.given()
			.contentType(ContentType.JSON)
			.body(jsonPayload)
			.put(endpoint).then().assertThat()
			.statusCode(200).contentType(ContentType.JSON);
		}

		// PATCH Request
		public void patchRequest(String endpoint, String jsonPayload) {
			RestAssured.given()
			.contentType(ContentType.JSON)
			.body(jsonPayload).patch(endpoint)
			.then().assertThat()
			.statusCode(200).contentType(ContentType.JSON);
		}

		// DELETE Request
		public void deleteRequest(String endpoint) {
			RestAssured.delete(endpoint)
			.then().assertThat().statusCode(204);
		}
	}
}




















