package Users.service;

import Users.client.MatchOfficialsClient;
import Users.client.TournamentsClient;
import io.restassured.response.Response;
import pojo.getAll.recommendedusers.GetRecommendedUsersResponse;
import pojo.getAll.tournaments.GetAllTournamentsResponse;

import java.util.concurrent.TimeUnit;

public class TournamentsService {
    public GetAllTournamentsResponse getAllTournaments()
    {
        Response response= new TournamentsClient().getAllTournaments();
        int statusCode=response.statusCode();
     long responseTime=  response.timeIn(TimeUnit.SECONDS);
    GetAllTournamentsResponse getAllTournamentsResponse = response.as(GetAllTournamentsResponse.class);
        getAllTournamentsResponse.setStatusCode(statusCode);
        getAllTournamentsResponse.setResponseTime(responseTime);

        return getAllTournamentsResponse;
    }
}
