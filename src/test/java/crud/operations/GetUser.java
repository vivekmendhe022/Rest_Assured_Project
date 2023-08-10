package crud.operations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUser {

	@SuppressWarnings("resource")
	static void m1() throws FileNotFoundException
	{
		// Request create
		// create request body
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\data.json");
		
		// send the request
		RequestSpecification r = RestAssured.given();
		r.body(file);
		r.contentType(ContentType.JSON);
		Response response = r.post("https://petstore.swagger.io/v2/store/order");
		// capture the id
//		response.then().log().all();
		Object orderId = response.jsonPath().get("id"); //.id
		System.out.println(orderId);
		
		// Request get
		// use in other request
		RequestSpecification r2 = RestAssured.given();
		r2.pathParam("oid", orderId);
		Response response2 = r2.get("https://petstore.swagger.io/v2/store/order/{oid}");
		response2.then().log().all();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		m1();
	}
}
