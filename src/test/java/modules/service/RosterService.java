package modules.service;

import io.restassured.response.Response;
import modules.client.RosterClient;
import pojo.get.Match.GetMatchScoreCardResponse;
import pojo.getAll.rosterdetaills.GetPlaying11BatsmenResponse;
import util.AllureUtility;

import java.util.concurrent.TimeUnit;

public class RosterService {
    public GetPlaying11BatsmenResponse getPlayingBatsmen(String matchId)
    {
        Response response  = new RosterClient().getBatsmen(matchId);
        GetPlaying11BatsmenResponse getPlaying11BatsmenResponse=response.as(GetPlaying11BatsmenResponse.class);
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        getPlaying11BatsmenResponse.setStatusCode(statusCode);
        getPlaying11BatsmenResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return getPlaying11BatsmenResponse;


    }
}
