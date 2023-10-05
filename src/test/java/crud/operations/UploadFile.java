package crud.operations;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

public class UploadFile {

	public static void uploadFile() {
		// updated to proper URL format
		String URL = "http://localhost:8090/Spring_Boot_Application/upload-file";

		// Specify the path to your PNG file here
		File fileToUpload = new File("D:\\Freelancing Promotion Facebook Cover Photo (1).png");

		// Setting up the request
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.multiPart("file", fileToUpload, "image/png");

		// Sending POST request
		Response response = reqSpec.post(URL);

		// Printing & Validating the response
		System.out.println("Response Code: " + response.getStatusCode());

		// Validate the response, e.g., check status code is 200 OK
		if (response.getStatusCode() == 200) {
			System.out.println("File uploaded successfully");
			System.out.println("File URL: " + response.getBody().asString());
		} else {
			System.out.println("Failed to upload the file");
		}
	}

	public static void main(String[] args) {
		uploadFile();
	}
}
