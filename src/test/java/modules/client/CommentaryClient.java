package modules.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.FileUtility;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class CommentaryClient {
    public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties;
    public Response getCommentary() {
        properties= FileUtility.loadProperties(propertyPath);
        String bearerToken=properties.getProperty("bearerToken");
        System.out.println(bearerToken);
        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParam("match_id",properties.getProperty("score_card_match_id"))
                .log().all(true)
                .when()
                .get(properties.getProperty("scorecard_basepath")+"/{match_id}"+"/commentary"+"/1");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body(true);
        return response;
    }
}
