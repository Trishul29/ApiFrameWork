package modules.service;

import io.restassured.response.Response;
import modules.client.ScoringClient;
import pojo.create.scoring.batsman.SetCurrentBatsmanRequestBody;
import pojo.create.scoring.batsman.SetCurrentBatsmanResponse;
import pojo.create.scoring.batsman.SetNewBatsMenRequestBody;
import pojo.create.scoring.batsman.SetNewBatsMenResponse;
import pojo.create.scoring.bowler.SetCurrentBowlerRequestBody;
import pojo.create.scoring.bowler.SetCurrentBowlerResponse;
import pojo.create.scoring.endinning.EndInningRequestBody;
import pojo.create.scoring.endinning.EndInningResponse;
import pojo.create.scoring.over.SetChangeMatchOverRequestBody;
import pojo.create.scoring.over.SetChangeMatchOverResponse;
import pojo.create.scoring.registerball.RegisterBallRequestBody;
import pojo.create.scoring.registerball.RegisterBallResponse;
import pojo.create.scoring.score.StartScoringResponse;
import pojo.create.scoring.secondinning.StartSecondInningRequestBody;
import pojo.create.scoring.secondinning.StartSecondInningResponse;
import pojo.create.scoring.toss.CreateTossRequestBody;
import pojo.create.scoring.toss.CreateTossResponse;
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
    public SetCurrentBatsmanResponse setCurrentBatsman(String matchId, SetCurrentBatsmanRequestBody setCurrentBatsmanRequestBody)
    {
        Response response  = new ScoringClient().SetCurrentBatsmen(matchId,setCurrentBatsmanRequestBody);
        SetCurrentBatsmanResponse setCurrentBatsmanResponse =response.as(SetCurrentBatsmanResponse.class);
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        setCurrentBatsmanResponse.setStatusCode(statusCode);
        setCurrentBatsmanResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return setCurrentBatsmanResponse;
    }
    public SetCurrentBowlerResponse setCurrentBowler(String matchId, SetCurrentBowlerRequestBody setCurrentBowlerRequestBody)
    {
        Response response  = new ScoringClient().setCurrentBowler(matchId,setCurrentBowlerRequestBody);
        SetCurrentBowlerResponse setCurrentBowlerResponse =response.as(SetCurrentBowlerResponse.class);
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        setCurrentBowlerResponse.setStatusCode(statusCode);
        setCurrentBowlerResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return setCurrentBowlerResponse;
    }
    public SetChangeMatchOverResponse changeMatchOverService(String matchId, SetChangeMatchOverRequestBody setChangeMatchOverRequestBody)
    {
        Response response  = new ScoringClient().setChangeMatchOver(matchId,setChangeMatchOverRequestBody);
        SetChangeMatchOverResponse setChangeMatchOverResponse =response.as(SetChangeMatchOverResponse.class);
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        setChangeMatchOverResponse.setStatusCode(statusCode);
        setChangeMatchOverResponse.setResponseTime(responseTime);

        new AllureUtility().getResponseTime(responseTime);
        return setChangeMatchOverResponse;
    }
    public RegisterBallResponse registerBall(String matchId, RegisterBallRequestBody registerBallRequestBody)
    {
        Response response  = new ScoringClient().register(matchId,registerBallRequestBody);
        RegisterBallResponse registerBallResponse =response.as(RegisterBallResponse.class);
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        registerBallResponse.setStatusCode(statusCode);
        registerBallResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return registerBallResponse;
    }


    public SetNewBatsMenResponse ProcessDismissalService(String matchId, SetNewBatsMenRequestBody setNewBatsMenRequestBody)
    {
        Response response  = new ScoringClient().processDismissal(matchId,setNewBatsMenRequestBody);
        SetNewBatsMenResponse setNewBatsMenResponse =response.as(SetNewBatsMenResponse.class);
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        setNewBatsMenResponse.setStatusCode(statusCode);
        setNewBatsMenResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return setNewBatsMenResponse;
    }

    public StartScoringResponse startScoringService(String matchId )
    {
        Response response  = new ScoringClient().startScoringClient(matchId);
        StartScoringResponse startScoringResponse =response.as(StartScoringResponse.class);
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        startScoringResponse.setStatusCode(statusCode);
        startScoringResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return startScoringResponse;
    }


    public EndInningResponse endInningService(String matchId, EndInningRequestBody endInningRequestBody) {
        Response response  = new ScoringClient().endInning(matchId,endInningRequestBody);
        EndInningResponse endInningResponse =response.as(EndInningResponse.class);
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        endInningResponse.setStatusCode(statusCode);
        endInningResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return endInningResponse;

    }

    public StartSecondInningResponse ChangeInningService(String matchId, StartSecondInningRequestBody startSecondInningRequestBody) {
        Response response  = new ScoringClient().changeInning(matchId,startSecondInningRequestBody);
        StartSecondInningResponse startSecondInningResponse =response.as(StartSecondInningResponse.class);
        int statusCode=response.statusCode();
        long responseTime=  response.timeIn(TimeUnit.MILLISECONDS);
        startSecondInningResponse.setStatusCode(statusCode);
        startSecondInningResponse.setResponseTime(responseTime);
        new AllureUtility().getResponseTime(responseTime);
        return startSecondInningResponse;
    }
}

