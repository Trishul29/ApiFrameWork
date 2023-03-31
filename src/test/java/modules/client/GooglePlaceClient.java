package modules.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.FileUtility;

import java.util.Properties;

import static io.restassured.RestAssured.*;

public class GooglePlaceClient {
    public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties= FileUtility.loadProperties(propertyPath);
    String bearerToken=properties.getProperty("bearerToken");
    public Response getList() {
      Response response=  given()
                .header("Authorization", bearerToken)
                .queryParam("text",properties.getProperty("place_name"))
                .log().all(true)
              .when()
                .get(properties.getProperty("basepath_google_place_list"));
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body(true);
        return response;
    }
    public Response getDetails() {
        Response response=  given()
                .header("Authorization", bearerToken)
                .pathParam("placeId",properties.getProperty("google_place_id"))
                .queryParam("type",properties.getProperty("google_place_type"))
                .log().all(true)
                .when()
                .get(properties.getProperty("basepath_google_place_list")+"/{placeId}");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body(true);
        return response;
    }
}
