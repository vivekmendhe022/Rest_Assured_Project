package com.crud.swagger;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Reqres2Data {

	public final static String baseurl = "https://reqres.in/api";

	public static void main(String[] args) {
		// createUser();
		// getUser();
		// updateUser();
		deleteUser();
	}

	@SuppressWarnings("unchecked")
	public static void createUser() {
		String endpoin = "/users/2";

		JSONObject json = new JSONObject();
		json.put("name", "jogin");
		json.put("job", "Teter");

		RequestSpecification req = RestAssured.given();
		req.body(json);
		req.contentType(ContentType.JSON);
		Response res = req.post(baseurl + endpoin);
		res.then().log().all();
		res.then().assertThat().statusCode(201);
	}

	public static void getUser() {
		String endpoin = "/users/2";
		RequestSpecification req = RestAssured.given();
		Response res = req.get(baseurl + endpoin);
		res.then().log().all();
	}

	@SuppressWarnings("unchecked")
	public static void updateUser() {
		String endpoin = "/users/2";
		JSONObject json = new JSONObject();
		json.put("name", "kiopoi");
		json.put("job", "graphic desiner");
		RestAssured.given().body(json).contentType(ContentType.JSON).put(baseurl + endpoin).then().log().all();
	}

	public static void deleteUser() {
		String endpoin = "/users/2";
		RestAssured.given().delete(baseurl + endpoin).then().log().all();
	}
}
