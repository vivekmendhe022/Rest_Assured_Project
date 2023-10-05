package CRUDOP;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class UserAPITest {

	// The base URI for the API
	private static final String BASE_URI = "https://example.com/api/users";

	// A sample user data in JSON format
	private static final String USER_JSON = "{\"name\":\"John\",\"email\":\"john@example.com\",\"password\":\"123456\"}";

	// A method to create a user and return the response
	@SuppressWarnings("unchecked")
	private Response createUser(String json) {

		JSONObject data = new JSONObject();
		data.put("name", "Mobile");
		data.put("job", "Automation Test ENgineer");

		return RestAssured.given().contentType(ContentType.JSON).body(json).post(BASE_URI);
	}

	// A method to get a user by id and return the response
	private Response getUser(int id) {
		return RestAssured.given().get(BASE_URI + "/" + id);
	}

	// A method to update a user by id and return the response
	private Response updateUser(int id, String json) {
		return RestAssured.given().contentType(ContentType.JSON).body(json).put(BASE_URI + "/" + id);
	}

	// A method to delete a user by id and return the response
	private Response deleteUser(int id) {
		return RestAssured.given().delete(BASE_URI + "/" + id);
	}

	// A test case to verify that a user can be created successfully
	@Test
	public void testCreateUser() {
		Response response = createUser(USER_JSON);
		Assert.assertEquals(201, response.statusCode()); // Check the status code is 201 (Created)
		Assert.assertEquals("John", response.jsonPath().getString("name")); // Check the name is John
		Assert.assertEquals("john@example.com", response.jsonPath().getString("email")); // Check the email is
																							// john@example.com
		Assert.assertNotNull(response.jsonPath().getInt("id")); // Check the id is not null
	}

	// A test case to verify that a user can be retrieved successfully
	@Test
	public void testGetUser() {
		Response createResponse = createUser(USER_JSON);
		int id = createResponse.jsonPath().getInt("id"); // Get the id of the created user
		Response getResponse = getUser(id);
		Assert.assertEquals(200, getResponse.statusCode()); // Check the status code is 200 (OK)
		Assert.assertEquals("John", getResponse.jsonPath().getString("name")); // Check the name is John
		Assert.assertEquals("john@example.com", getResponse.jsonPath().getString("email")); // Check the email is
																							// john@example.com
		Assert.assertEquals(id, getResponse.jsonPath().getInt("id")); // Check the id is same as created user
	}

	// A test case to verify that a user can be updated successfully
	@Test
	public void testUpdateUser() {
		Response createResponse = createUser(USER_JSON);
		int id = createResponse.jsonPath().getInt("id"); // Get the id of the created user
		String updatedJson = "{\"name\":\"Jane\",\"email\":\"jane@example.com\",\"password\":\"654321\"}";
		// The updated user data in JSON format

		Response updateResponse = updateUser(id, updatedJson);
		Assert.assertEquals(200, updateResponse.statusCode()); // Check the status code is 200 (OK)
		Assert.assertEquals("Jane", updateResponse.jsonPath().getString("name")); // Check the name is Jane
		Assert.assertEquals("jane@example.com", updateResponse.jsonPath().getString("email"));
		// Check the email is jane@example.com
		Assert.assertEquals(id, updateResponse.jsonPath().getInt("id")); // Check the id is same as created user
	}

	// A test case to verify that a user can be deleted successfully
	@Test
	public void testDeleteUser() {
		Response createResponse = createUser(USER_JSON);
		int id = createResponse.jsonPath().getInt("id"); // Get the id of the created user
		Response deleteResponse = deleteUser(id);
		Assert.assertEquals(204, deleteResponse.statusCode()); // Check the status code is 204 (No Content)
		Response getResponse = getUser(id);
		Assert.assertEquals(404, getResponse.statusCode());
		// Check the status code is 404 (Not Found) when trying to get the deleted user
	}
}
