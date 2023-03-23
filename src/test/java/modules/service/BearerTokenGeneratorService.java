package modules.service;
import modules.client.BearerTokenGeneratorClient;
import io.restassured.response.Response;
import pojo.create.bearertoken.CreateBearerTokenRequestBody;
import pojo.create.bearertoken.CreateBearerTokenResponse;

public class BearerTokenGeneratorService {
    public  CreateBearerTokenResponse createBearerToken(CreateBearerTokenRequestBody requestBody) {
        Response response = new BearerTokenGeneratorClient().getToken(requestBody);
        CreateBearerTokenResponse createBearerTokenResponse = response.as(CreateBearerTokenResponse.class);
       createBearerTokenResponse.setStatusCode(response.statusCode());
       createBearerTokenResponse.setIdToken(response.getBody().jsonPath().getString("idToken"));

        return createBearerTokenResponse;

    }
}
