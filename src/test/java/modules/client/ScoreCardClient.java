package modules.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.FileUtility;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class ScoreCardClient {
    public    String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties;
    String bearerToken;

    public Response getScoreCard()
    {
        properties= FileUtility.loadProperties(propertyPath);
        bearerToken=properties.getProperty("bearerToken");

        Response response=given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParam("matchId",properties.getProperty("score_card_match_id"))
                .log().all(true)
                .when()
                .get(properties.getProperty("scorecard_basepath")+"/{matchId}"+"/scorecard");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;

    }
}
