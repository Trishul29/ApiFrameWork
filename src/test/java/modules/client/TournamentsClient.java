package modules.client;
import io.qameta.allure.Allure;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.time.StopWatch;
import pojo.create.tournament.CreateTournamentRequestBody;
import util.FileUtility;
import java.util.Properties;
import static io.restassured.RestAssured.given;
import static org.hamcrest.StringDescription.asString;


public class TournamentsClient {
    public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties;
    String bearerToken;

    public Response getAllTournaments() {
        properties= FileUtility.loadProperties(propertyPath);
        bearerToken=properties.getProperty("bearerToken");
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
        properties= FileUtility.loadProperties(propertyPath);
        bearerToken=properties.getProperty("bearerToken");
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
        properties= FileUtility.loadProperties(propertyPath);
        bearerToken=properties.getProperty("bearerToken");
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

}

