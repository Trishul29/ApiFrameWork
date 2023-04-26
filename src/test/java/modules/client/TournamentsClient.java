package modules.client;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.create.tournament.CreateTournamentRequestBody;
import pojo.update.tournament.EditTournamentRequestBody;
import util.FileUtility;
import java.util.Properties;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class TournamentsClient {
    public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties= FileUtility.loadProperties(propertyPath);
    String bearerToken=properties.getProperty("bearerToken");

    public Response getAllTournaments(String filter) {

       String gameType=properties.getProperty("gameType");

        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
               // .queryParam("type",properties.getProperty("type"))
                .queryParam("page",1)
                .queryParam("filter",filter)
          .pathParam("gameType",gameType)

                .log().uri()
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("basepath_tournaments")+"/{gameType}"+"/tournament");

        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        // Add response body as attachment to Allure report

        return response;

    }

    public Response createTournament(CreateTournamentRequestBody requestBody)
    {
        Response response=given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+bearerToken)
                .body(requestBody)
                .log().all(true)
                .when()
                .post(properties.getProperty("base_uri")+properties.getProperty("basepath_create_tournament"));
        response
                .then()

                .contentType(ContentType.JSON)
                .log().body(true);
        return response;
    }

    public Response getPoints() {

        String id=properties.getProperty("id_tournament_point");
        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParam("id",id)
                .log().uri()
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("basepath_get_tournament_point")+"/{id}"+"/points");

        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;

    }

    public Response editTournament(EditTournamentRequestBody requestBody)
    {
        Response response=given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+bearerToken)
                .pathParam("tournament_id",properties.getProperty("id_edit_tournament"))
                .body(requestBody)
                .log().all(true)
                .when()
                .put(properties.getProperty("base_uri")+properties.getProperty("basepath_edit_tournament")+"/{tournament_id}");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body(true);
        return response;
    }

    public Response getStats()
    {
        Response response=given()
                .header("Authorization",bearerToken)
                .pathParams("gameType",properties.getProperty("gametype_aggregate_stat"),"tournamentId",properties.getProperty("tournament_id_aggregate_stat"))
                .log().uri()
                .when()
                .get(properties.getProperty("base_uri")+"/v3.0"+"/{gameType}"+"/tournament"+"/{tournamentId}"+"/tournament-aggregate-stats");
        response
                .then()
                .log().body(true)
                .contentType(ContentType.JSON);
        return response;

    }

    public Response getTournamentFilterList()
    {
        Response response=given()
                .header("Authorization",bearerToken)
               .queryParam("filter",properties.getProperty("tournament_leaderboard_filter"))
                .log().uri()
                .when()
                .get(properties.getProperty("base_uri")+"/v3.0/0/tournament-leaderboard-filter");
        response
                .then()
                .log().body(true)
                .contentType(ContentType.JSON);
        return response;

    }


    public Response getTournamentLeaderBoard(String filter, String subFilter) {
        Response response=given()
                .header("Authorization",bearerToken)
                .queryParams("filter",filter,"subFilter", subFilter,"page",1)
                .pathParam("id",properties.getProperty("tournament_leaderboard_id"))
                .log().uri()
                .when()
                .get(properties.getProperty("base_uri")+"/v3.0/0/tournament-leaderboard"+"/{id}");
        response
                .then()
                .log().body(true)
                .contentType(ContentType.JSON);
        return response;

    }
}

