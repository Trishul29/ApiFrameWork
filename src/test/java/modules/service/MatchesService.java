package modules.service;

import io.qameta.allure.Allure;
import modules.client.MatchesClient;
import io.restassured.response.Response;
import pojo.create.match.CreateMatchRequestBody;
import pojo.create.match.CreateMatchResponse;
import pojo.get.Match.GetMatchInfoResponse;

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
        String response_in_mili_seconds=Long.toString(responseTime);
        Allure.step("Response time:"+response_in_mili_seconds+"MiliSeconds");

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
        String response_in_mili_seconds=Long.toString(responseTime);
        Allure.step("Response time:"+response_in_mili_seconds+"MiliSeconds");

        return getMatchInfoResponse;
    }


}
