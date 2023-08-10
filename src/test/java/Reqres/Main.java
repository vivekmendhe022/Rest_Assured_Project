package Reqres;

public class Main {
    public static void main(String[] args) {
        String baseUri = "https://reqres.in/api";
        RestClient restClient = new RestClient();

        // GET Request
        restClient.getRequest(baseUri + "/users/2");

        // POST Request
        String postPayload = "{\"name\": \"John\", \"job\": \"Software Engineer\"}";
        restClient.postRequest(baseUri + "/users", postPayload);

        // PUT Request
        String putPayload = "{\"name\": \"John Smith\", \"job\": \"Senior Software Engineer\"}";
        restClient.putRequest(baseUri + "/users/2", putPayload);

        // PATCH Request
        String patchPayload = "{\"name\": \"John Doe\"}";
        restClient.patchRequest(baseUri + "/users/2", patchPayload);

        // DELETE Request
        restClient.deleteRequest(baseUri + "/users/2");
    }
}

