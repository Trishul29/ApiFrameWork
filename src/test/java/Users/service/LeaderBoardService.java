package Users.service;

import Users.client.LeaderBoardClient;
import io.restassured.response.Response;
import pojo.getAll.leaderboard.GetAllPlayerLeaderBoardResponse;
import pojo.getAll.tournaments.GetAllTournamentsResponse;

import java.util.concurrent.TimeUnit;

public class LeaderBoardService {
    public GetAllPlayerLeaderBoardResponse getLeaderBoard()
    {
        Response response= new LeaderBoardClient().getBoard();
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.SECONDS);
        GetAllPlayerLeaderBoardResponse getAllPlayerLeaderBoardResponse = response.as(GetAllPlayerLeaderBoardResponse.class);
        getAllPlayerLeaderBoardResponse.setStatusCode(statusCode);
        getAllPlayerLeaderBoardResponse.setResponseTime(responseTime);
        return getAllPlayerLeaderBoardResponse;
    }
}
