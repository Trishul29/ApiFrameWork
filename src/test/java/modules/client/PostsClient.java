package modules.client;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.create.post.CreatePostRequestBody;
import pojo.create.post.CreateReplyPostRequestBody;
import util.FileUtility;
import java.util.Properties;
import static io.restassured.RestAssured.given;
public class PostsClient {
  public    String propertyPath = System.getProperty("user.dir") + "//src//main//java//spec.properties";
    public Properties properties= FileUtility.loadProperties(propertyPath);
    String bearerToken=properties.getProperty("bearerToken");

    public  Response getAll(String Path) {


        Response response = given()
                .header("Authorization","Bearer "+bearerToken)
                .queryParam("page",2)
                .log().all(true)
                .when()
                .get(Path);
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body();
        return response;

    }

    public Response createPost(CreatePostRequestBody requestBody)
    {


        Response response=given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+bearerToken)
                .body(requestBody)
                .log().all(true)
                .when()
                .post(properties.getProperty("basepath_create_post"));
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body(true);
        return response;
    }


    public Response createReplyPost(CreateReplyPostRequestBody requestBody)
    {

        Response response=given()
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+bearerToken)
                .body(requestBody)
                .log().all(true)
                .when()
                .post(properties.getProperty("basepath_create_post"));
        response
                .then()
                .contentType(ContentType.JSON)
                .log().body(true);
        return response;
    }

}
