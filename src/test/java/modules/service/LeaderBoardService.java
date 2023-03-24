package modules.service;

import io.qameta.allure.Allure;
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
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        GetAllPlayerLeaderBoardResponse getAllPlayerLeaderBoardResponse = response.as(GetAllPlayerLeaderBoardResponse.class);
        getAllPlayerLeaderBoardResponse.setStatusCode(statusCode);
        getAllPlayerLeaderBoardResponse.setResponseTime(responseTime);
        String response_in_mili_seconds=Long.toString(responseTime);
        Allure.step("Response time:"+response_in_mili_seconds+"MiliSeconds");
        return getAllPlayerLeaderBoardResponse;
    }


}
