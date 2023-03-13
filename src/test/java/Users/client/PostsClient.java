package Users.client;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.FileUtility;

import java.util.Properties;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class PostsClient {
  public  static  String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public  static Properties properties;

    public static Response getAll(String Path) {

        properties=FileUtility.loadProperties(propertyPath);
   String bearerToken=properties.getProperty("bearerToken");
        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .queryParam("page",1)
                .log().uri()
                .when()
                .get(Path);
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;

    }
}
