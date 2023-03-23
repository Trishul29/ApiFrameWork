package modules.service;

import modules.client.LeaderBoardClient;
import io.restassured.response.Response;
import pojo.getAll.leaderboard.GetAllPlayerLeaderBoardResponse;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertNotNull;

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
