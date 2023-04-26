package modules.client;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.FileUtility;
import java.util.Properties;
import static io.restassured.RestAssured.given;

public class MatchHighlightsClient {
    public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties= FileUtility.loadProperties(propertyPath);
    String bearerToken=properties.getProperty("bearerToken");
    public Response getHighlights() {


        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParam("matchId",properties.getProperty("HighlightmatchId"))
                .log().uri()
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("basepath_highlights")+"/{matchId}"+"/highlights/1");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();

        return response;
    }

    public Response getHighlightsFootball() {


        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParam("matchId",properties.getProperty("matchid_football"))
                .log().uri()
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("basepath_highlights_football")+"/{matchId}"+"/highlights/1");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();

        return response;
    }
}

