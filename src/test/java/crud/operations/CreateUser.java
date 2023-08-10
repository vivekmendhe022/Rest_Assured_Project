package crud.operations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUser {

	@SuppressWarnings("unchecked")
	static void createUser() {
		// Step 1: Create the necessary Data
		JSONObject obj = new JSONObject();
		obj.put("name", "Chaitra");
		obj.put("job", "Automation Tester");
		
		// step 2: send the request
		RequestSpecification req = RestAssured.given();
		req.body(obj);
		req.contentType(ContentType.JSON);
		Response resp = req.post("https://reqres.in/api/users");
		
		// Step 3: Validate the response
		resp.then().log().all();
		System.out.println(resp.getContentType());
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getStatusLine());
		System.out.println(resp.getTime());
		resp.then().assertThat().statusCode(201);
	}

	@SuppressWarnings("unchecked")
	static void register() {
		// Create necessary data
		JSONObject o = new JSONObject();
		o.put("email", "eve.holt@reqres.in");
		o.put("password", "123456");
		// send the req
		RequestSpecification req = RestAssured.given();
		req.body(o);
		req.contentType(ContentType.JSON);
		Response res = req.post("https://reqres.in/api/register");
		// validate the res
		res.then().log().all();
		System.out.println(res.getContentType());
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getTime());
	}

	@SuppressWarnings("unchecked")
	static void signin() {
		// create data
		JSONObject o = new JSONObject();
		o.put("email", "eve.holt@reqres.in");
		o.put("password", "123456");
		// send req
		RequestSpecification req = RestAssured.given();
		req.body(o);
		req.contentType(ContentType.JSON);
		Response res = req.post("https://reqres.in/api/login");
		// validate theres
		res.then().log().all();
		System.out.println(res.getContentType());
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getTime());
	}

	static void delay() {
		// create data
		JSONObject o = new JSONObject();
//		o.put("email", "eve.holt@reqres.in");
//		o.put("password", "123456");
//		// send request
		RequestSpecification req = RestAssured.given();
//		req.body(o);
		req.contentType(ContentType.JSON);
		Response res = req.post("https://reqres.in/api/users?delay=3");
		// validate the res
		res.then().log().all();
		System.out.println(res.getContentType());
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getTime());
	}

	static void reqChaning() throws FileNotFoundException {
		//Request - Create
		// Step 1: create a request body
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data.json");

		// Step 2: send the request
		RequestSpecification req = RestAssured.given();
		req.body(fis);
		req.contentType(ContentType.JSON);
		Response resp = req.post("https://petstore.swagger.io/v2/store/order");

		// Step 3: Captures the id
		int orderID = resp.jsonPath().get("id");// .id
		System.out.println(orderID);

		/* Request - Get */
		// Step 4: use in other request
		RequestSpecification req2 = RestAssured.given();
		req2.pathParam("oid", orderID);

		Response rep = req2.get("https://petstore.swagger.io/v2/store/order/{oid}");
		rep.then().log().all();

	}

	public static void main(String[] args) {
		delay();
	}
}
