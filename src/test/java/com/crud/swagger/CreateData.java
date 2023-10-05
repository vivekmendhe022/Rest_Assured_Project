package com.crud.swagger;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateData {

	public static void main(String[] args) {
//		createData();
//		getData();
//		updateData();
		deleteData();
	}

	public static void getData() {
		String baseurl = "https://reqres.in/api";
		String endpoint = "/users?page=2";
		RequestSpecification req = RestAssured.given();
		Response res = req.get(baseurl + endpoint);
		res.then().log().all();
	}

	@SuppressWarnings("unchecked")
	public static void updateData() {

		String baseurl = "https://reqres.in/api";
		String endpoint = "/users/2";

		// Create Update data
		JSONObject json = new JSONObject();
		json.put("name", "Morpheus");
		json.put("job", "web developer");

		// send request
		RequestSpecification req = RestAssured.given();
		req.body(json);
		req.contentType(ContentType.JSON);
		Response res = req.put(baseurl + endpoint);

		// send response
		res.then().log().all();
//		res.then().assertThat().statusCode(200);

	}

	public static void deleteData() {
		String baseurl = "https://reqres.in/api";
		String endpoint = "/users/2";

		// send request
		RequestSpecification req = RestAssured.given();
		Response res = req.delete(baseurl + endpoint);

		// display response
		res.then().log().all();
		res.then().assertThat().statusCode(204);
	}

	@SuppressWarnings("unchecked")
	public static void createData() {
		String baseurl = "https://reqres.in/api";
		String endpoint = "/users";

		// Create neccessary data
		JSONObject json = new JSONObject();
		json.put("name", "Java Morgan");
		json.put("job", "Developer");

		// send request
		RequestSpecification req = RestAssured.given();
		req.body(json);
		req.contentType(ContentType.JSON);
		Response res = req.post(baseurl + endpoint);

		// send response
		res.then().log().all();
		System.out.println("===================");
		System.out.println(res.getContentType());
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getTime());
		res.then().assertThat().statusCode(201);
	}
}
