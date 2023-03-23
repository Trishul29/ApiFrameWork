package modules.service;
import modules.client.MatchOfficialsClient;
import io.restassured.response.Response;
import pojo.getAll.recommendedusers.GetRecommendedUsersResponse;

import java.util.concurrent.TimeUnit;

public class MatchOfficialsService {
    public GetRecommendedUsersResponse getRecommendedUsers()
    {
        Response response= new MatchOfficialsClient().getAllRecommended();
        int statusCode=response.statusCode();
        long responseTime= response.timeIn(TimeUnit.SECONDS);
        GetRecommendedUsersResponse getRecommendedUsersResponse = response.as(GetRecommendedUsersResponse.class);
        getRecommendedUsersResponse.setStatusCode(statusCode);
        getRecommendedUsersResponse.setResponseTime(responseTime);

        return getRecommendedUsersResponse;
    }
}


