package modules.service;
import io.qameta.allure.Allure;
import modules.client.MatchOfficialsClient;
import io.restassured.response.Response;
import pojo.getAll.recommendedusers.GetRecommendedUsersResponse;

import java.util.concurrent.TimeUnit;

public class MatchOfficialsService {
    public GetRecommendedUsersResponse getRecommendedUsers()
    {
        Response response= new MatchOfficialsClient().getAllRecommended();
        int statusCode=response.statusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        GetRecommendedUsersResponse getRecommendedUsersResponse = response.as(GetRecommendedUsersResponse.class);
        getRecommendedUsersResponse.setStatusCode(statusCode);
        getRecommendedUsersResponse.setResponseTime(responseTime);
        String response_in_mili_seconds=Long.toString(responseTime);
        Allure.step("Response time:"+response_in_mili_seconds+"MiliSeconds");

        return getRecommendedUsersResponse;
    }
}


