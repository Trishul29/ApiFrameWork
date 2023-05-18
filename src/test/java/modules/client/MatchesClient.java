package modules.client;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.create.match.CreateMatchRequestBody;
import pojo.update.match.EditMatchRequestBody;
import util.FileUtility;
import java.util.Properties;
import static io.restassured.RestAssured.given;

public class MatchesClient {
    public   String propertyPath = System.getProperty("user.dir")+ "//src//main//java//spec.properties";



    public Properties properties= FileUtility.loadProperties(propertyPath);
 String   bearerToken=properties.getProperty("bearerToken");




    public Response getAllMatches(String filter) {


        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .queryParams("page",1,"type",properties.getProperty("type_matches"),"filter",filter)
                .log().uri()
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("basepath_all_matches"));
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();

        return response;
}
    public Response CreateMatchClient(CreateMatchRequestBody requestBody)

    {
        Response response=given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+bearerToken)
                .body(requestBody)
                .log().all(true)
                .when()
                .post(properties.getProperty("base_uri")+properties.getProperty("basepath_creatematch"));
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body(true);
        return response;
    }

    public Response getMatchInfo()
    {

        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParam("MatchId",properties.getProperty("matchid"))
                .log().all(true)
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("basepath_get_matchinfo")+"/{MatchId}");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body(true);

        return response;
    }

    public Response getOneMatchFootball()
    {

        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParam("MatchId",properties.getProperty("matchid_football"))
                .log().all(true)
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("basepath_get_onematch_football")+"/{MatchId}");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body(true);

        return response;
    }

    public Response getOneMatchStatFootball() {

        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParam("MatchId",properties.getProperty("matchid_football"))
                .log().all(true)
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("basepath_get_onematch_football")+"/{MatchId}"+"/stats");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body(true);

        return response;
    }

    public Response editMatch(EditMatchRequestBody editMatchRequestBody)
    {

        Response response=given()
                .header("Authorization",bearerToken)
                .pathParams("gameType","0","id",properties.getProperty("matchid_edit_match"))
                .contentType(ContentType.JSON)
                .body(editMatchRequestBody)
                .log().all(true)
                .when()
                .put(properties.getProperty("base_uri")+properties.getProperty("basepath_edit_match")+"/{gameType}"+"/matches"+"/{id}");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body(true);
        return response;

    }

    public Response GetEditMatchDetails( )
    {

        Response response=given()
                .header("Authorization",bearerToken)
                .pathParams("gameType","0","matchId",properties.getProperty("matchid_edit_match"))
                .contentType(ContentType.JSON)
                .log().all(true)
                .log().body(true)
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("basepath_edit_match")+"/{gameType}"+"/matches"+"/{matchId}"+"/editDetails");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body(true);
        return response;

    }

    public Response getRecommended( )
    {

        Response response=given()
                .header("Authorization",bearerToken)
                .queryParam("type",properties.getProperty("recommend_matches_type"))
                .contentType(ContentType.JSON)
                .log().all(true)
                .log().body(true)
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("basepath_recommended_matches"));
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body(true);
        return response;

    }
    public Response getMyyMatches(String role, String type) {


        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .queryParams("role",role)
                .queryParam("type",type)
                .log().uri()
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("basepath_get_myymatches"));
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();

        return response;
    }

    public Response getCurrentMatchDetails(String matchId) {
        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParams("MatchId",matchId)
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("toss_basepath")+"/{MatchId}"+"/live");
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();

        return response;
    }
}
