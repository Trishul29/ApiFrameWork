package Users.client;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.FileUtility;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class TournamentsClient {
    public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties;

    public Response getAllTournaments() {
        properties= FileUtility.loadProperties(propertyPath);
        String bearerToken=properties.getProperty("bearerToken");
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
}

