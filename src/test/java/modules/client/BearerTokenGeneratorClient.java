package modules.client;

import io.restassured.response.Response;
import pojo.create.bearertoken.CreateBearerTokenRequestBody;
import util.FileUtility;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class BearerTokenGeneratorClient {
    public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties;
public Response getToken(CreateBearerTokenRequestBody body)
{
    properties= FileUtility.loadProperties(propertyPath);

    Response response=given()
            .header("Content-Type", "application/json")
            .queryParam("key",properties.getProperty("firebase_key"))
            .body(body)
            .log().uri()
            .log().all(true)
            .when()
            .post("https://identitytoolkit.googleapis.com/v1/accounts:/signInWithPassword");
    response
            .then()
            .log().all(true);

return response;

}
}