package modules.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.create.match.RegisterBallRequestBody;
import util.FileUtility;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class RegisterBallClient {
    public    String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties= FileUtility.loadProperties(propertyPath);
    String bearerToken=properties.getProperty("bearerToken");
    public Response register(String matchId, RegisterBallRequestBody requestBody) {
        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParams("MatchId",matchId)
                .body(requestBody)
                .log().all(true)
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("register_ball_basepath")+"/{MatchId}"+"/ball");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;
    }
}
