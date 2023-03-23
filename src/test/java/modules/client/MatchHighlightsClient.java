package modules.client;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.FileUtility;
import java.util.Properties;
import static io.restassured.RestAssured.given;

public class MatchHighlightsClient {
    public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties;

    public Response getHighlights() {
        properties= FileUtility.loadProperties(propertyPath);
        String bearerToken=properties.getProperty("bearerToken");
        String id=properties.getProperty("matchId");
        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParam("matchId",id)
                .log().uri()
                .when()
                .get(properties.getProperty("basepath_highlights")+"/{matchId}"+"/highlights/1");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();

        return response;
    }
}

