package token_utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetToken {

    @Test
    public void getBearerToken() {
// Staging fire base key:  AIzaSyC80_Ysidh_cG1DVXL3uzUT3m_2Oy5tQDk
// dev firebase key: AIzaSyAPiKvVLzQf77Cf3IbGJJhsCfQhefPi2p0
// dev email ,password:troops@google.com  troops
//staging email, password:  kudos@google.com , kudoss

        RequestSpecification request = RestAssured.given()
                .urlEncodingEnabled(false)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .queryParam("key", "AIzaSyC80_Ysidh_cG1DVXL3uzUT3m_2Oy5tQDk")
                .body("{\"email\":\"kudos@google.com\",\"password\":\"kudoss\",\"returnSecureToken\":true}");

        Response response = request.post("https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword");
        String responseBody = response.getBody().asString();
        System.out.println(responseBody);
        String token = response.jsonPath().getString("idToken");
        System.out.println(token.substring(0,800));
        System.out.println(token.substring(800));

    }
}
