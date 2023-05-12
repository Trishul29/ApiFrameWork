package modules.client;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.create.team.CreateTeamRequestBody;
import util.FileUtility;
import java.util.Properties;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class TeamsClient {

    public   String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties= FileUtility.loadProperties(propertyPath);
    String bearerToken=properties.getProperty("bearerToken");
    public  Response getTeam(String id) {

        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParam("teamId",id)
                .log().uri()
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("basepath_get_team")+"/{teamId}");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;

    }

    public  Response getTeams() {

        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .queryParam("page",2)
                .log().uri()
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("basepath_getall_team"));
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;

    }

    public Response CreateTeamClient(CreateTeamRequestBody requestBody)

    {
        Response response=given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+bearerToken)
                .body(requestBody)
                .log().all(true)
                .when()
                .post(properties.getProperty("base_uri")+properties.getProperty("basepath_create_team"));
       response
               .then()
               .contentType(ContentType.JSON)
               .log().body(true);
                return response;
    }

    public Response GetTeamPlayerAccordingToGameTypeClient()
    {
        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .queryParam("matchId",properties.getProperty("matchid_getplayeraccordingtogametype"))
                .pathParam("gameType","0")
                .pathParam("teamId",properties.getProperty("teamid_getplayeraccordingtogametype"))
                .log().uri()
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("basepath_getall_team")+"/{gameType}"+"/{teamId}"+"/players");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;

    }

    public Response getTeamLeaderBoardFilterList()
    {
        Response response=given()
                .header("Authorization",bearerToken)
                .queryParam("filter",properties.getProperty("team_leaderboard_filter"))
                .queryParam("id",properties.getProperty("teamleaderboard_teamid"))
                .log().uri()
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("basepath_teamleaderboard_filter"));
        response
                .then()
                .log().body(true)
                .contentType(ContentType.JSON);
        return response;

    }


    public Response getTeamLeaderBoard(String filter,String subFilter) {
        Response response=given()
                .header("Authorization",bearerToken)
                .queryParams("filter",filter,"subFilter", subFilter,"page",1,"year",2023)
                .pathParam("id",properties.getProperty("teamleaderboard_teamid"))
                .log().uri()
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("basepath_teamleaderboard")+"/{id}");
        response
                .then()
                .log().body(true)
                .contentType(ContentType.JSON);
        return response;
    }
}
