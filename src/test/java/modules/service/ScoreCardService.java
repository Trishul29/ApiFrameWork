package modules.service;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import modules.client.ScoreCardClient;
import pojo.get.Match.GetMatchScoreCardResponse;
import util.AllureUtility;

import java.util.concurrent.TimeUnit;

public class ScoreCardService {

    public GetMatchScoreCardResponse getMatchScoreCard()
    {
        Response response= new ScoreCardClient().getScoreCard();
        GetMatchScoreCardResponse getMatchScoreCardResponse=response.as(GetMatchScoreCardResponse.class);
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        getMatchScoreCardResponse.setStatusCode(statusCode);
        getMatchScoreCardResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);

   return getMatchScoreCardResponse;
    }
}
