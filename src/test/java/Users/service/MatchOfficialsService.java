package Users.service;
import Users.client.MatchOfficialsClient;
import io.restassured.response.Response;
import pojo.getAll.recommendedusers.GetRecommendedUsersResponse;

public class MatchOfficialsService {
    public GetRecommendedUsersResponse getRecommendedUsers()
    {
        Response response= new MatchOfficialsClient().getAllRecommended();
        int statusCode=response.statusCode();
        GetRecommendedUsersResponse getRecommendedUsersResponse = response.as(GetRecommendedUsersResponse.class);
        getRecommendedUsersResponse.setStatusCode(statusCode);

        return getRecommendedUsersResponse;
    }
}


