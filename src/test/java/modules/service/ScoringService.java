package modules.service;

import io.restassured.response.Response;
import modules.client.ScoreCardClient;
import modules.client.ScoringClient;
import pojo.create.scoring.CreateTossRequestBody;
import pojo.create.scoring.CreateTossResponse;
import pojo.get.Match.GetMatchScoreCardResponse;
import util.AllureUtility;

import java.util.concurrent.TimeUnit;

public class ScoringService {
    public CreateTossResponse createTossService(String matchId,CreateTossRequestBody createTossRequestBody)
    {
        Response response=new ScoringClient().createTossClient(matchId,createTossRequestBody);
        CreateTossResponse createTossResponse=response.as(CreateTossResponse.class);
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        createTossResponse.setStatusCode(statusCode);
        createTossResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return createTossResponse;


    }
}
