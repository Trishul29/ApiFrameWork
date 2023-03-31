package modules.client;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
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
                .queryParam("UserId",uid)
                .log().uri()
                .when()
                .get(properties.getProperty("basepathuser"));
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;

    }
}
