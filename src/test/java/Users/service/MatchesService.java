package Users.service;

import Users.client.MatchesClient;
import Users.client.TeamsClient;
import io.restassured.response.Response;
import pojo.create.match.CreateMatchRequestBody;
import pojo.create.match.CreateMatchResponse;
import pojo.create.team.CreateTeamRequestBody;
import pojo.create.team.CreateTeamResponse;

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
        return createMatchResponse;
    }

}
