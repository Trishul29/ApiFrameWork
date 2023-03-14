package Users.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.FileUtility;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class MatchesClient {
    public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties;

    public Response getAllMatches() {
        properties= FileUtility.loadProperties(propertyPath);
        String bearerToken=properties.getProperty("bearerToken");
        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .queryParams("page",1,"type",properties.getProperty("type_matches"))
                .log().uri()
                .when()
                .get(properties.getProperty("basepath_all_matches"));
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();

        return response;
}
}
