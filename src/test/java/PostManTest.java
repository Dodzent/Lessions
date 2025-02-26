import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostManTest {

    private static final String BASE_URL = "https://postman-echo.com";

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    @Test
    public void testGetRequest() {
        String paramOne = "bar1";
        String paramTwo = "bar2";

        Response response = sendGetRequest("/get", paramOne, paramTwo);
        assertEquals(200, response.getStatusCode(), "Статус-код должен быть 200");
        assertResponseParams(response, paramOne, paramTwo);
        printResponseBody(response);
    }

    @Test
    public void testPostRawText() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = sendPostRequest("/post", "text/plain", requestBody);
        assertEquals(200, response.getStatusCode(), "Статус-код должен быть 200");
        assertEquals(requestBody, response.jsonPath().getString("data"), "Текст body не совпадает");
        printResponseBody(response);
    }

    @Test
    public void testPostFormData() {
        String jsonData = "{\"foo1\": \"bar1\", \"foo2\": \"bar2\"}";

        Response response = sendPostRequest("/post", "application/json", jsonData);
        assertEquals(200, response.getStatusCode(), "Статус-код должен быть 200");
        assertEquals("bar1", response.jsonPath().getString("data.foo1"), "Параметр foo1 не совпадает");
        assertEquals("bar2", response.jsonPath().getString("data.foo2"), "Параметр foo2 не совпадает");
        printResponseBody(response);
    }

    @Test
    public void testPutRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = sendPutRequest("/put", "text/plain", requestBody);
        assertEquals(200, response.getStatusCode(), "Статус-код должен быть 200");
        assertEquals(requestBody, response.jsonPath().getString("data"), "Текст body не совпадает");
        printResponseBody(response);
    }

    @Test
    public void testPatchRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = sendPatchRequest("/patch", "text/plain", requestBody);
        assertEquals(200, response.getStatusCode(), "Статус-код должен быть 200");
        assertEquals(requestBody, response.jsonPath().getString("data"), "Текст body не совпадает");
        printResponseBody(response);
    }

    @Test
    public void testDeleteRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = sendDeleteRequest("/delete", "text/plain", requestBody);
        assertEquals(200, response.getStatusCode(), "Статус-код должен быть 200");
        assertEquals(requestBody, response.jsonPath().getString("data"), "Текст body не совпадает");
        printResponseBody(response);
    }

    private Response sendGetRequest(String endpoint, String paramOne, String paramTwo) {
        return RestAssured.given()
                .queryParam("foo1", paramOne)
                .queryParam("foo2", paramTwo)
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    private Response sendPostRequest(String endpoint, String contentType, String body) {
        return RestAssured.given()
                .contentType(contentType)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    private Response sendPutRequest(String endpoint, String contentType, String body) {
        return RestAssured.given()
                .contentType(contentType)
                .body(body)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    private Response sendPatchRequest(String endpoint, String contentType, String body) {
        return RestAssured.given()
                .contentType(contentType)
                .body(body)
                .when()
                .patch(endpoint)
                .then()
                .extract()
                .response();
    }

    private Response sendDeleteRequest(String endpoint, String contentType, String body) {
        return RestAssured.given()
                .contentType(contentType)
                .body(body)
                .when()
                .delete(endpoint)
                .then()
                .extract()
                .response();
    }

    private void assertResponseParams(Response response, String expectedParamOne, String expectedParamTwo) {
        String actualParamOne = response.jsonPath().getString("args.foo1");
        String actualParamTwo = response.jsonPath().getString("args.foo2");

        assertEquals(expectedParamOne, actualParamOne, "Параметр foo1 не совпадает");
        assertEquals(expectedParamTwo, actualParamTwo, "Параметр foo2 не совпадает");
    }

    private void printResponseBody(Response response) {
        System.out.println("Тело ответа: " + response.getBody().asString());
    }
}

