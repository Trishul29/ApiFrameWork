package modules.service;

import io.qameta.allure.Allure;
import modules.client.MatchesClient;
import io.restassured.response.Response;
import pojo.create.match.CreateMatchRequestBody;
import pojo.create.match.CreateMatchResponse;
import pojo.get.Match.GetMatchInfoResponse;
import pojo.get.Match.GetOneMatchStatFootballResponse;
import pojo.get.Match.GetOneMatch_FootballResponse;
import util.AllureUtility;

import java.util.concurrent.TimeUnit;

public class MatchesService {
    public CreateMatchResponse createMatch(CreateMatchRequestBody createMatchRequestBody)
    {

        Response response=new MatchesClient().CreateMatchClient(createMatchRequestBody);
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.SECONDS);
        CreateMatchResponse createMatchResponse=response.as(CreateMatchResponse.class);
        createMatchResponse.setStatusCode(statusCode);
        createMatchResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);

       return createMatchResponse;
    }

    public GetMatchInfoResponse getMatchInfo()

    {
        Response response=new MatchesClient().getMatchInfo();
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        GetMatchInfoResponse getMatchInfoResponse=response.as(GetMatchInfoResponse.class);
        getMatchInfoResponse.setStatusCode(statusCode);
        getMatchInfoResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);

        return getMatchInfoResponse;
    }
public GetOneMatch_FootballResponse getOneMatchFootball()
{

    Response response=new MatchesClient().getOneMatchFootball();
    int statusCode=response.getStatusCode();
    long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
    GetOneMatch_FootballResponse getOneMatch_footballResponse=response.as(GetOneMatch_FootballResponse.class);
    getOneMatch_footballResponse.setStatusCode(statusCode);
    getOneMatch_footballResponse.setResponseTime(responseTime);
    new AllureUtility().getResponseTime(responseTime);

    return getOneMatch_footballResponse;

}

    public GetOneMatchStatFootballResponse getOneMatchStat_Football()
    {

        Response response=new MatchesClient().getOneMatchStatFootball();
        int statusCode=response.getStatusCode();
        long responseTime= response.timeIn(TimeUnit.MILLISECONDS);
        GetOneMatchStatFootballResponse getOneMatchStatFootballResponse=response.as(GetOneMatchStatFootballResponse.class);
        getOneMatchStatFootballResponse.setStatusCode(statusCode);
        getOneMatchStatFootballResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);

        return getOneMatchStatFootballResponse;

    }

}
