package modules.service;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import modules.client.CommentaryClient;
import modules.client.LeaderBoardClient;
import pojo.get.Match.GetMatchCommentaryResponse;
import pojo.getAll.leaderboard.GetAllPlayerLeaderBoardResponse;
import util.AllureUtility;

import java.util.concurrent.TimeUnit;

public class CommentaryService {

    public GetMatchCommentaryResponse getMatchCommentary()
    {
        Response response= new CommentaryClient().getCommentary();
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        GetMatchCommentaryResponse getMatchCommentaryResponse = response.as(GetMatchCommentaryResponse.class);
        getMatchCommentaryResponse.setStatusCode(statusCode);
        getMatchCommentaryResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return getMatchCommentaryResponse;
    }

}
