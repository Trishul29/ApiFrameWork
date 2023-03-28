package modules.service;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import modules.client.ScoreCardClient;
import pojo.get.Match.GetMatchScoreCardResponse;

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
        String response_in_mili_seconds=Long.toString(responseTime);
        Allure.step("Response time:"+response_in_mili_seconds+" MiliSeconds");

   return getMatchScoreCardResponse; }
}
