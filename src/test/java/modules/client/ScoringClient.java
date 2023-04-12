package modules.client;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.create.scoring.CreateTossRequestBody;
import util.FileUtility;

import java.util.Properties;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

public class ScoringClient {
    public    String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties= FileUtility.loadProperties(propertyPath);
    String bearerToken=properties.getProperty("bearerToken");

    public Response createTossClient(String matchId, CreateTossRequestBody createTossRequestBody)
    {
        Response response=given()
                .header("Authorization","Bearer "+bearerToken)
                .contentType(ContentType.JSON)
                .pathParam("matchId",matchId)
                .body(createTossRequestBody)
                .log().all(true)
                .when()
                .post(properties.getProperty("base_uri")+properties.getProperty("toss_basepath")+"/{matchId}"+"/toss");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;

    }
}
