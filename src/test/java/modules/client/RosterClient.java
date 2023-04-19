package modules.client;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.update.roster.UpdateRosterBeforeMatchRequestBody;
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
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("toss_basepath")+"/{matchId}"+properties.getProperty("playing_11_batsmen_roster"));
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();

return response;

    }
    public Response getBowler(String matchId)
    {
        Response response=given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParam("matchId",matchId)
                .queryParam("filter","players")
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("toss_basepath")+"/{matchId}"+properties.getProperty("playing_11_bowler_roster"));
        response
                .then()
                .contentType(ContentType.JSON)
                .log().all(true);



        return response;

    }

    public Response updateRosterBeforeMatch(UpdateRosterBeforeMatchRequestBody requestBody) {
        Response response=given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParam("gameType",0)
                .body(requestBody)
                .log().all(true)
                .when()
                .put(properties.getProperty("base_uri")+properties.getProperty("basepath_getall_team")+"/{gameType}"+"/roster-before-toss");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().all(true);



        return response;

    }
}
