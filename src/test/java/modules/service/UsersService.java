package modules.service;

import modules.client.UsersClient;
import pojo.get.user.GetUserResponse;
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
