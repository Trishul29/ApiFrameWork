package Users.service;

import Users.client.UsersClient;
import pojo.get.GetUserResponse;
import io.restassured.response.Response;

public class UsersService {
    public GetUserResponse getUserById(String id) {
        Response response = new UsersClient().getUser(id);
        int statusCode = response.statusCode();
        GetUserResponse  getUserResponse= response.as(GetUserResponse.class);
        getUserResponse.setStatusCode(statusCode);
        return getUserResponse;
    }

}
