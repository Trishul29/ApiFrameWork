package modules.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.FileUtility;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class SearchClient {
    public    String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties;
    String bearerToken;
    public Response getSearch()
    {
        properties= FileUtility.loadProperties(propertyPath);
        bearerToken=properties.getProperty("bearerToken");

        Response response=given()
                .header("Authorization","Bearer "+bearerToken)
                .queryParam("keyword",properties.getProperty("keyword_search"))
                .queryParam("page",1)
                .log().all(true)
                .when()
                .get(properties.getProperty("basepath_dev_search"));
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;

    }
}

