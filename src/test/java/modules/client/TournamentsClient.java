package modules.client;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.create.tournament.CreateTournamentRequestBody;
import pojo.update.tournament.EditTournamentRequestBody;
import util.FileUtility;
import java.util.Properties;
import static io.restassured.RestAssured.given;


public class TournamentsClient {
    public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties= FileUtility.loadProperties(propertyPath);
    String bearerToken=properties.getProperty("bearerToken");

    public Response getAllTournaments() {

        String path=properties.getProperty("gameType");

        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .queryParam("type",properties.getProperty("type"))

                .pathParam("gameType",path)
                .queryParam("page",1)
                .log().uri()
                .when()
                .get(properties.getProperty("basepath_tournaments")+"/{gameType}"+"/tournament");

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
                .post(properties.getProperty("basepath_create_tournament"));
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
                .get(properties.getProperty("basepath_get_tournament_point")+"/{id}"+"/points");

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
                .put(properties.getProperty("basepath_edit_tournament")+"/{tournament_id}");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body(true);
        return response;
    }

}

