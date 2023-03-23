package modules.client;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.create.tournament.CreateTournamentRequestBody;
import util.FileUtility;
import java.util.Properties;
import static io.restassured.RestAssured.given;

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
}

