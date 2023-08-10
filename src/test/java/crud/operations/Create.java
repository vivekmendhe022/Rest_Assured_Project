package crud.operations;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Create {
	
	public static void main(String[] args) {
		createUser();
	}

	@SuppressWarnings("unchecked")
	public static void createUser() {
		// Create Nessesary Data
		JSONObject j = new JSONObject();
		j.put("name", "Mobile");
		j.put("job", "Automation Test ENgineer");

		// Send Request
		RequestSpecification req = RestAssured.given();
		req.body(j);
		req.contentType(ContentType.JSON);
		Response res = req.post("https://reqres.in/api/users");

		// Validate Response
		res.then().log().all();
		System.out.println(res.getContentType());
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		System.out.println(res.getTime());
		res.then().assertThat().statusCode(201);
	}

}
