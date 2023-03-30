package modules.service;

import io.qameta.allure.Allure;
import modules.client.LeaderBoardClient;
import io.restassured.response.Response;
import pojo.getAll.leaderboard.GetAllPlayerLeaderBoardResponse;
import util.AllureUtility;

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
        new AllureUtility().getResponseTime(responseTime);
        return getAllPlayerLeaderBoardResponse;
    }


}
