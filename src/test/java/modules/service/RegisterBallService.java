package modules.service;

import io.restassured.response.Response;
import modules.client.RegisterBallClient;
import modules.client.RosterClient;
import pojo.create.match.RegisterBallRequestBody;
import pojo.create.match.RegisterBallResponse;
import pojo.getAll.rosterdetaills.GetPlaying11Response;
import util.AllureUtility;

import java.util.concurrent.TimeUnit;

public class RegisterBallService {
    public RegisterBallResponse registerBall(String matchId, RegisterBallRequestBody registerBallRequestBody)
    {
        Response response  = new RegisterBallClient().register(matchId,registerBallRequestBody);
        RegisterBallResponse registerBallResponse =response.as(RegisterBallResponse.class);
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        registerBallResponse.setStatusCode(statusCode);
        registerBallResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return registerBallResponse;
    }
}
