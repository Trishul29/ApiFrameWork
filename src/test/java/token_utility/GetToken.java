package token_utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetToken {

  //  @Test
    public void getBearerToken()
    {

            RequestSpecification request = RestAssured.given()
                    .urlEncodingEnabled(false)
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .queryParam("key", "AIzaSyAPiKvVLzQf77Cf3IbGJJhsCfQhefPi2p0")
                    .body("{\"email\":\"troops@google.com\",\"password\":\"troops\",\"returnSecureToken\":true}");

            Response response = request.post("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword");
            String responseBody = response.getBody().asString();
            System.out.println(responseBody);
            String token = response.jsonPath().getString("idToken");
            System.out.println(token);
    }
}
