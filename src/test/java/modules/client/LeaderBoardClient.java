package modules.client;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import util.FileUtility;
import java.util.Properties;
import static io.restassured.RestAssured.given;

public class LeaderBoardClient {
    public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties= FileUtility.loadProperties(propertyPath);
    String bearerToken=properties.getProperty("bearerToken");

    public Response getBoard() {


        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .queryParam("matchType",properties.getProperty("matchType"))
                .queryParam("dateType",properties.getProperty("dateType"))
                .queryParam("leaderBoardType",properties.getProperty("leaderBoardType"))
                .queryParam("page",1)
                .log().uri()
                .when()
                .get(properties.getProperty("basepath_leaderboard"));
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();

        return response;
    }
}
