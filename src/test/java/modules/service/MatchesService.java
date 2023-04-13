package modules.service;

import modules.client.MatchesClient;
import io.restassured.response.Response;
import pojo.create.match.CreateMatchRequestBody;
import pojo.create.match.CreateMatchResponse;
import pojo.get.Match.*;
import pojo.getAll.matches.GetMyyMatchesResponse;
import pojo.getAll.matches.GetRecommendedMatchesResponse;
import pojo.update.match.EditMatchRequestBody;
import pojo.update.match.EditMatchResponse;
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

    public GetOneMatchStatFootballResponse getOneMatchStat_Football() {

        Response response = new MatchesClient().getOneMatchStatFootball();
        int statusCode = response.getStatusCode();
        long responseTime = response.timeIn(TimeUnit.MILLISECONDS);
        GetOneMatchStatFootballResponse getOneMatchStatFootballResponse = response.as(GetOneMatchStatFootballResponse.class);
        getOneMatchStatFootballResponse.setStatusCode(statusCode);
        getOneMatchStatFootballResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);

        return getOneMatchStatFootballResponse;

    }

    public EditMatchResponse editMatchDetails(EditMatchRequestBody editMatchRequestBody)
    {

        Response response=new MatchesClient().editMatch(editMatchRequestBody);
        int statusCode = response.getStatusCode();
        long responseTime = response.timeIn(TimeUnit.MILLISECONDS);
        EditMatchResponse editMatchResponse=response.as(EditMatchResponse.class);
        editMatchResponse.setStatusCode(statusCode);
        editMatchResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return editMatchResponse;



    }

    public GetEditMatchDetailsResponse getEditMatchDetails()
    {

        Response response=new MatchesClient().GetEditMatchDetails();
        int statusCode = response.getStatusCode();
        long responseTime = response.timeIn(TimeUnit.MILLISECONDS);
        GetEditMatchDetailsResponse getEditMatchDetailsResponse=response.as(GetEditMatchDetailsResponse.class);
        getEditMatchDetailsResponse.setStatusCode(statusCode);
        getEditMatchDetailsResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);

        return getEditMatchDetailsResponse;

    }
    public GetRecommendedMatchesResponse getRecommendedMatches()
    {

        Response response=new MatchesClient().getRecommended();
        int statusCode = response.getStatusCode();
        long responseTime = response.timeIn(TimeUnit.MILLISECONDS);
        GetRecommendedMatchesResponse getRecommendedMatchesResponse=response.as(GetRecommendedMatchesResponse.class);
        getRecommendedMatchesResponse.setStatusCode(statusCode);
        getRecommendedMatchesResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);

        return getRecommendedMatchesResponse;

    }
    public GetMyyMatchesResponse getMyyMatchesUsingRole()
    {
        Response response=new MatchesClient().getMyyMatches();
        int statusCode = response.getStatusCode();

        long responseTime = response.timeIn(TimeUnit.MILLISECONDS);
        GetMyyMatchesResponse getMyyMatchesResponse=response.as(GetMyyMatchesResponse.class);
        getMyyMatchesResponse.setStatusCode(statusCode);
        getMyyMatchesResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);

        return getMyyMatchesResponse;
    }

    public GetLiveMatchDetailsResponse getCurrentMatchDetailsService(String matchId) {
        Response response=new MatchesClient().getCurrentMatchDetails(matchId);
        int statusCode = response.getStatusCode();

        long responseTime = response.timeIn(TimeUnit.MILLISECONDS);
        GetLiveMatchDetailsResponse getLiveMatchDetailsResponse=response.as(GetLiveMatchDetailsResponse.class);
        getLiveMatchDetailsResponse.setStatusCode(statusCode);
        getLiveMatchDetailsResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);

        return getLiveMatchDetailsResponse;

    }
}
