package modules.service;

import io.restassured.response.Response;
import modules.client.RosterClient;
import pojo.getAll.rosterdetaills.GetPlaying11Response;
import pojo.update.roster.UpdateRosterBeforeMatchRequestBody;
import pojo.update.roster.UpdateRosterBeforeMatchResponse;
import util.AllureUtility;

import java.util.concurrent.TimeUnit;

public class RosterService {
    public GetPlaying11Response getPlayingBatsmen(String matchId)
    {
        Response response  = new RosterClient().getBatsmen(matchId);
        GetPlaying11Response getPlaying11Response =response.as(GetPlaying11Response.class);
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        getPlaying11Response.setStatusCode(statusCode);
        getPlaying11Response.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return getPlaying11Response;
    }
    public GetPlaying11Response getPlayingBowler(String matchId)
    {
        Response response  = new RosterClient().getBowler(matchId);
        GetPlaying11Response getPlaying11Response =response.as(GetPlaying11Response.class);
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        getPlaying11Response.setStatusCode(statusCode);
        getPlaying11Response.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return getPlaying11Response;

    }

    public UpdateRosterBeforeMatchResponse updateRosterBeforeMatchService(UpdateRosterBeforeMatchRequestBody updateRosterBeforeMatchRequestBody)
    {
        Response response  = new RosterClient().updateRosterBeforeMatch(updateRosterBeforeMatchRequestBody);
        UpdateRosterBeforeMatchResponse updateRosterBeforeMatchResponse =response.as(UpdateRosterBeforeMatchResponse.class);
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        updateRosterBeforeMatchResponse.setStatusCode(statusCode);
        updateRosterBeforeMatchResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return updateRosterBeforeMatchResponse;
    }
}
