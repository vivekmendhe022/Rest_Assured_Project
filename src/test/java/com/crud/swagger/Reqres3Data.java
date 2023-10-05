package com.crud.swagger;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Reqres3Data {
	
	public static final String baseurl = "https://reqres.in/api";

	public static void main(String[] args) {
//		post();
//		get();
//		put();
		delete();
	}

	@SuppressWarnings("unchecked")
	public static void post() {
		String endpoint = "/users";
		JSONObject json = new JSONObject();
		json.put("name", "Jolly");
		json.put("job", "Lawyer");
		RestAssured.given().body(json).contentType(ContentType.JSON).post(baseurl + endpoint).then().log().all();
	}

	public static void get() {
		String endpoint = "/users?page=2";
		RestAssured.given().get(baseurl + endpoint).then().log().all();
	}

	@SuppressWarnings("unchecked")
	public static void put() {
		String endpoint = "/users/2";
		JSONObject json = new JSONObject();
		json.put("name", "Sheshatri Ji");
		json.put("job", "Reporter");
		RestAssured.given().body(json).contentType(ContentType.JSON).put(baseurl + endpoint).then().log().all();
	}

	public static void delete() {
		String endpoint = "/users/2";
		RestAssured.given().delete(baseurl + endpoint).then().log().all();
	}

}
