package modules.client;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.update.user.UpdateUserProfileRequestBody;
import util.FileUtility;
import java.util.Properties;
import static io.restassured.RestAssured.given;

public class UsersClient {
    public    String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties= FileUtility.loadProperties(propertyPath);
    String bearerToken=properties.getProperty("bearerToken");

    public  Response getUser(String uid) {

        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .queryParam("userId",uid)
                .log().uri()
                .when()
                .get(properties.getProperty("base_uri")+properties.getProperty("basepathuser"));
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;

    }
    public Response editUser(UpdateUserProfileRequestBody requestBody)
    {

        Response response=given()
                .header("Authorization","Bearer "+bearerToken)
                .pathParam("source","sports")
                .body(requestBody)
                .log().all(true)
                .when()
                .put(properties.getProperty("base_uri")+properties.getProperty("base_path_edit_user")+"/{source}");
      response
              .then()
             .contentType(ContentType.JSON)
             .log().body();
        return response;


    }


}
