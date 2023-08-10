package com.swagger.curd;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test {

	public static void main(String[] args) {
		String BASEURL = "https://petstore.swagger.io/v2/";
		String POSTENDPOINT = "user/createWithArray";
		String URL=BASEURL+POSTENDPOINT;
		System.out.println(URL);
		RestM r = new RestM();

		String POSTPAYLOAD = "[\r\n"
				+ "  {\r\n"
				+ "    \"id\": 100,\r\n"
				+ "    \"username\": \"Puja01\",\r\n"
				+ "    \"firstName\": \"Puja\",\r\n"
				+ "    \"lastName\": \"Maan\",\r\n"
				+ "    \"email\": \"poo@gmail.com\",\r\n"
				+ "    \"password\": \"123456\",\r\n"
				+ "    \"phone\": \"7845123256\",\r\n"
				+ "    \"userStatus\": 1\r\n"
				+ "  }\r\n"
				+ "]";
		r.postRequest(URL, POSTPAYLOAD);
		r.statusCode(URL);
	}
}

class RestM {

	public void statusCode(String URL) {
		RequestSpecification request = RestAssured.given();
		Response response = request.post();
		String contentType = response.getContentType();
		int statusCode = response.getStatusCode();
		String statusLine = response.getStatusLine();
		long time = response.getTime();
		System.out.println(contentType);
		System.out.println(statusCode);
		System.out.println(statusLine);
		System.out.println(time);
		response.then().assertThat().statusCode(200);
		if (statusCode == 200) {
			System.out.println("Created");
		} else {
			System.out.println("Error");
		}
	}

	public void getRequest(String ENDPOINT) {
		RestAssured.get(ENDPOINT).then().assertThat().statusCode(200).contentType(ContentType.JSON);
	}

	public void postRequest(String ENDPOINT, String JSONPAYLOAD) {
		RestAssured.given().contentType(ContentType.JSON).body(JSONPAYLOAD).post(ENDPOINT).then().assertThat()
				.statusCode(200).contentType(ContentType.JSON);
	}

	public void putRequest(String ENDPOINT, String JSONPAYLOAD) {
		RestAssured.given().contentType(ContentType.JSON).body(JSONPAYLOAD).put(ENDPOINT).then().assertThat()
				.statusCode(200).contentType(ContentType.JSON);
	}

	public void patchRequest(String ENDPOINT, String JSONPAYLOAD) {
		RestAssured.given().contentType(ContentType.JSON).body(JSONPAYLOAD).patch(ENDPOINT).then().assertThat()
				.statusCode(200).contentType(ContentType.JSON);
	}

	public void deleteRequest(String ENDPOINT) {
		RestAssured.delete(ENDPOINT).then().assertThat().statusCode(204);
	}

}
