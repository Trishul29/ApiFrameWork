package Tests_Monitor;

import Users.service.BearerTokenGeneratorService;
import org.testng.annotations.Test;
import pojo.create.bearertoken.CreateBearerTokenRequestBody;
import pojo.create.bearertoken.CreateBearerTokenResponse;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

//public class CreateBearerToken {
//    @Test
//    public void shouldGetBearerToken() {
//        CreateBearerTokenRequestBody createBearerTokenRequestBody = new CreateBearerTokenRequestBody.Builder().build();
//        CreateBearerTokenResponse createBearerTokenResponse = new BearerTokenGeneratorService().createBearerToken(createBearerTokenRequestBody);
//        assertEquals(createBearerTokenResponse.getStatusCode(),200);
//        System.out.println(createBearerTokenResponse.getIdToken());
//        assertNotNull(createBearerTokenResponse.getIdToken());
//
//    }
//}
//
