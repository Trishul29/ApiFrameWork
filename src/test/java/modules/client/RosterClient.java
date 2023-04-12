package modules.client;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.FileUtility;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class RosterClient {
    public    String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties= FileUtility.loadProperties(propertyPath);
    String bearerToken=properties.getProperty("bearerToken");

    public Response getBatsmen(String matchId)
    {
        Response response=given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParam("matchId",matchId)
                .queryParam("filter","players")
                .log().all(true)
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("toss_basepath")+"/{matchId}"+properties.getProperty("playing_11_batsmen_roster"));
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();

return response;

    }
}
