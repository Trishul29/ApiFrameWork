package modules.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.FileUtility;
import java.util.Properties;
import static io.restassured.RestAssured.given;

public class MatchOfficialsClient {
    public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties= FileUtility.loadProperties(propertyPath);
    String bearerToken=properties.getProperty("bearerToken");

    public Response getAllRecommended() {

        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .queryParam("city",properties.getProperty("city"))
                .queryParam("role",properties.getProperty("role"))
                .queryParam("pageNo",1)
                .log().uri()
                .when()
                .get(properties.getProperty("basepath_recommended"));
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;

    }
}
