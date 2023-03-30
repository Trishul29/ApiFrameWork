package modules.service;

import io.qameta.allure.Allure;
import modules.client.UsersClient;
import pojo.get.user.GetUserResponse;
import io.restassured.response.Response;
import util.AllureUtility;

import java.util.concurrent.TimeUnit;

public class UsersService {
    public GetUserResponse getUserById(String id) {
        Response response = new UsersClient().getUser(id);
        int statusCode = response.statusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);

        GetUserResponse  getUserResponse= response.as(GetUserResponse.class);
        getUserResponse.setStatusCode(statusCode);
        new AllureUtility().getResponseTime(responseTime);
        return getUserResponse;
    }

}
