package modules.client;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.create.scoring.batsman.SetCurrentBatsmanRequestBody;
import pojo.create.scoring.bowler.SetCurrentBowlerRequestBody;
import pojo.create.scoring.endinning.EndInningRequestBody;
import pojo.create.scoring.over.SetChangeMatchOverRequestBody;
import pojo.create.scoring.secondinning.StartSecondInningRequestBody;
import pojo.create.scoring.toss.CreateTossRequestBody;
import pojo.create.scoring.registerball.RegisterBallRequestBody;
import pojo.create.scoring.batsman.SetNewBatsMenRequestBody;
import util.FileUtility;

import java.util.Properties;

import static io.restassured.RestAssured.given;


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
                .log().body(true)
                .when()
                .post(properties.getProperty("base_uri")+properties.getProperty("toss_basepath")+"/{matchId}"+"/toss");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;

    }
    public Response SetCurrentBatsmen(String matchId, SetCurrentBatsmanRequestBody requestBody)
    {
        Response response=given()
                .header("Authorization","Bearer "+bearerToken)
                .contentType(ContentType.JSON)
                .pathParams("MatchId",matchId)
                .body(requestBody)
                .log().all(true)
                .when()
                .post(properties.getProperty("base_uri")+properties.getProperty("toss_basepath")+"/{MatchId}"+"/batsmen");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;

    }
    public Response setCurrentBowler(String matchId, SetCurrentBowlerRequestBody requestBody)
    {
        Response response=given()
                .header("Authorization","Bearer "+bearerToken)
                .contentType(ContentType.JSON)
                .pathParams("MatchId",matchId)
                .body(requestBody)
                .log().all(true)
                .when()
                .post(properties.getProperty("base_uri")+properties.getProperty("toss_basepath")+"/{MatchId}"+"/bowler");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;

    }
    public Response setChangeMatchOver(String matchId, SetChangeMatchOverRequestBody requestBody)
    {
        Response response=given()
                .header("Authorization","Bearer "+bearerToken)
                .contentType(ContentType.JSON)
                .pathParams("MatchId",matchId)
                .body(requestBody)
                .log().all(true)
                .when()
                .post(properties.getProperty("base_uri")+properties.getProperty("toss_basepath")+"/{MatchId}"+"/over");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;

    }

    public Response startScoringClient(String matchId)
    {
        Response response=given()
                .header("Authorization","Bearer "+bearerToken)
                .noContentType()
                .pathParams("MatchId",matchId)
                .log().all(true)
                .when()
                .post(properties.getProperty("base_uri")+properties.getProperty("toss_basepath")+"/{MatchId}"+"/scoring-start");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;

    }

    public Response register(String matchId, RegisterBallRequestBody requestBody) {
        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .contentType(ContentType.JSON)
                .pathParams("MatchId",matchId)
                .body(requestBody)
                .log().all(true)
                .when()
                .post(properties.getProperty("base_uri")+properties.getProperty("register_ball_basepath")+"/{MatchId}"+"/ball");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;
    }
    public Response processDismissal(String matchId, SetNewBatsMenRequestBody requestBody)
    {
        Response response=given()
                .header("Authorization","Bearer "+bearerToken)
                .contentType(ContentType.JSON)
                .pathParams("MatchId",matchId)
                .body(requestBody)
                .log().all(true)
                .when()
                .post(properties.getProperty("base_uri")+properties.getProperty("toss_basepath")+"/{MatchId}"+"/processDismissal");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;


    }


    public Response endInning(String matchId, EndInningRequestBody requestBody) {
        Response response=given()
                .header("Authorization","Bearer "+bearerToken)
                .contentType(ContentType.JSON)
                .pathParam("MatchId",matchId)
                .queryParam("action","end")
                .body(requestBody)
                .log().all(true)
                .when()
                .post(properties.getProperty("base_uri")+properties.getProperty("toss_basepath")+"/{MatchId}"+"/inning");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;


    }

    public Response changeInning(String matchId, StartSecondInningRequestBody requestBody) {
        Response response=given()
                .header("Authorization","Bearer "+bearerToken)
                .contentType(ContentType.JSON)
                .pathParam("MatchId",matchId)
                .body(requestBody)
                .log().all(true)
                .when()
                .post(properties.getProperty("base_uri")+properties.getProperty("toss_basepath")+"/{MatchId}"+"/inning");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;


    }
}

