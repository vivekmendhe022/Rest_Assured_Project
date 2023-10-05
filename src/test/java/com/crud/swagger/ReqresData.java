package com.crud.swagger;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReqresData {

	public static String baseurl = "https://reqres.in/api";

	public static void main(String[] args) {
//		createUser();
//		getUser();
//		updateUser();
		deleteUser();
	}

	@SuppressWarnings("unchecked")
	public static void createUser() {
		String endpoint = "/users";

		JSONObject json = new JSONObject();
		json.put("name", "Mavang");
		json.put("job", "Devlopers");

		RequestSpecification req = RestAssured.given();
		req.body(json);
		req.contentType(ContentType.JSON);
		Response res = req.post(baseurl + endpoint);

		res.then().log().all();
		res.then().assertThat().statusCode(201);
		System.out.println(res.getContentType());
		System.out.println("Status code: " + res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getTime() + " sec");
	}

	public static void getUser() {
		String endpoint1 = "/users/2";
		String endpoint2 = "/users?page=2";
		RequestSpecification req = RestAssured.given();
		Response res = req.get(baseurl + endpoint1);
		res.then().log().all();
		Response res2 = req.get(baseurl + endpoint2);
		res2.then().log().all();
	}

	@SuppressWarnings("unchecked")
	public static void updateUser() {
		String endpoint = "/users/2";

		JSONObject json = new JSONObject();
		json.put("name", "Ravan");
		json.put("job", "java");

		RequestSpecification req = RestAssured.given();
		req.body(json);
		req.contentType(ContentType.JSON);
		Response res = req.put(baseurl + endpoint);
		res.then().log().all();
	}

	public static void deleteUser() {
		String endpoint = "/users/2";
		RequestSpecification req = RestAssured.given();
		Response res = req.delete(baseurl + endpoint);
		res.then().log().all();
		res.then().assertThat().statusCode(204);

	}
}
